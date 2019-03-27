package kr.greenbugs.android.cleanarchitecturedemo.di.module


import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.Module
import dagger.Provides
import kr.greenbugs.android.cleanarchitecturedemo.R
import kr.greenbugs.android.cleanarchitecturedemo.data.repository.SignRepositoryImp
import kr.greenbugs.android.cleanarchitecturedemo.domain.repository.SignRepository
import javax.inject.Singleton

@Module(includes = [ApplicationModule::class])
class SignModule {

    @Singleton
    @Provides
    fun provideSignRepository(): SignRepository {
        return SignRepositoryImp()
    }

    @Provides
    @Singleton
    fun providesGoogleSignInOptions(context: Context): GoogleSignInOptions =
        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(context.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
}