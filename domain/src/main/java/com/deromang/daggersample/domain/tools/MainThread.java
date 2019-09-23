package com.deromang.daggersample.domain.tools;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 7/4/19.
 */
public interface MainThread {

    void runOnUi(Runnable runnable);

}