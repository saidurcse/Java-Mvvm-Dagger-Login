package saidur.demo.app.view.landing.view;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import saidur.demo.app.util.SharedPrefsHelper;

public class LandingViewModel extends ViewModel {
    @Inject
    SharedPrefsHelper sharedPrefsHelper;
    @Inject
    protected Context context;
}
