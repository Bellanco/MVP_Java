package com.deromang.daggersample.ui.detail;


import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.deromang.daggersample.R;
import com.deromang.daggersample.deromang.modules.presentation.main.DetailComponent;
import com.deromang.daggersample.deromang.modules.presentation.main.DetailModule;
import com.deromang.daggersample.domain.data.Product;
import com.deromang.daggersample.presentation.detail.DetailPresenter;
import com.deromang.daggersample.presentation.detail.DetailView;
import com.deromang.daggersample.ui.BaseFragment;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends BaseFragment implements DetailView {

    @Inject
    DetailPresenter presenter;

    @BindView(R.id.ivTitle)
    ImageView ivTitle;

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @BindView(R.id.tvDescription)
    TextView tvDescription;

    @BindView(R.id.tvUrl)
    TextView tvUrl;

    private Product product;

    private DetailComponent component;


    public DetailFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(Product product) {
        DetailFragment fragment = new DetailFragment();
        fragment.product = product;
        return fragment;
    }


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_detail;
    }

    @Override
    protected void prepareInjection() {
        component = getActivityComponent()
                .detailComponent()
                .detailModule(new DetailModule())
                .build();

        component.inject(this);

        presenter.setView(this);

        setupView();

    }

    @OnClick(R.id.ivBack)
    public void onClickBack() {
        getActivity().onBackPressed();
    }

    private void setupView() {
        Picasso.get().load(product.getThumbnail()).into(ivTitle);
        tvTitle.setText(product.getTitle());
        tvDescription.setText(product.getIngredients());
        SpannableString content = new SpannableString(product.getHref());
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        tvUrl.setText(content);
    }

    @OnClick(R.id.tvUrl)
    public void onClickUrl() {
        final Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(product.getHref()));
        getActivity().startActivity(intent);

    }
}
