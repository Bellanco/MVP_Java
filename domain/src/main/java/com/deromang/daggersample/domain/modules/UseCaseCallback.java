package com.deromang.daggersample.domain.modules;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 7/4/19.
 */
public interface UseCaseCallback<T extends UseCaseResponse> {

    void onResponse(T response);

}
