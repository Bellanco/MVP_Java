package com.deromang.daggersample.ui.product;


import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.deromang.daggersample.R;
import com.deromang.daggersample.deromang.modules.presentation.product.ProductListComponent;
import com.deromang.daggersample.deromang.modules.presentation.product.ProductListModule;
import com.deromang.daggersample.domain.data.Product;
import com.deromang.daggersample.presentation.product.ProductListPresenter;
import com.deromang.daggersample.presentation.product.ProductListView;
import com.deromang.daggersample.ui.BaseFragment;
import com.deromang.daggersample.ui.product.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductListFragment extends BaseFragment implements ProductListView {

    private ProductListComponent component;

    @Inject
    ProductListPresenter presenter;

    @BindView(R.id.rvMain)
    RecyclerView rvMain;

    @BindView(R.id.etFilter)
    EditText etFilter;

    @BindView(R.id.ivClose)
    ImageView ivClose;

    @BindView(R.id.tvEmpty)
    TextView tvEmpty;

    private MainAdapter adapter;

    private List<Product> productList = new ArrayList<>();


    public ProductListFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return new ProductListFragment();
    }


    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void prepareInjection() {
        component = getActivityComponent()
                .productListComponent()
                .productListModule(new ProductListModule())
                .build();

        component.inject(this);

        presenter.setView(this);

        setupView();

    }

    private void setupView() {
        adapter = new MainAdapter(productList, new MainListener() {
            @Override
            public void onItemClick(Product product) {
                presenter.goToDetails(product);
            }
        });

        rvMain.setLayoutManager(new LinearLayoutManager(getActivity()));

        rvMain.setAdapter(adapter);

        presenter.requestData();

        ivClose.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ic_search));

    }

    @OnTextChanged(R.id.etFilter)
    void onChangeText(CharSequence value) {
        presenter.onTextChanged(value);
        ivClose.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ic_search));
        if (value.length() > 0) {
            ivClose.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ic_close));
        }
    }

    @OnClick(R.id.ivClose)
    void onClickCross() {
        etFilter.setText("");
        adapter.clear();
        showText();
    }


    @Override
    public void notifyDataSetChanged(List<Product> productList) {
        adapter.clear();
        adapter.addAll(productList);
        adapter.notifyDataSetChanged();
        if (productList.size() > 0) {
            hideText();
        } else {
            showText();
        }
    }

    private void hideText() {
        tvEmpty.setVisibility(View.GONE);
    }

    private void showText() {
        tvEmpty.setVisibility(View.VISIBLE);
    }
}
