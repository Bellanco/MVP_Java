package com.deromang.daggersample.deromang.modules.base.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 7/4/19.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PresentationScope {
}
