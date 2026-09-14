package com.eshreef.help.di;

import com.eshreef.help.SignInActivity;
import com.eshreef.help.SignUpActivity;

import javax.inject.Singleton;

import dagger.Component;

import com.eshreef.help.freg.MessagesFragment;

@Singleton
@Component(modules = {FirebaseModule.class})
public interface AppComponent {
    void inject(SignInActivity activity);
    void inject(SignUpActivity activity);
    void inject(MessagesFragment fragment);
}
