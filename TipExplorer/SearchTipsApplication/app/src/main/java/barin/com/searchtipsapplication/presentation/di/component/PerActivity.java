package barin.com.searchtipsapplication.presentation.di.component;

import java.lang.annotation.Retention;
import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 *  Custom scope living only activity lives.
 */

@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}
