package com.deromang.daggersample.domain.data.repository;

import com.deromang.daggersample.domain.data.Product;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 7/4/19.
 */
public interface UserRepository {

    boolean makeLogin(String username, String password);

    Product getCurrentUser();

}
