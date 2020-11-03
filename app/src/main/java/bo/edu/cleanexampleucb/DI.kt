package bo.edu.cleanexampleucb

import bo.edu.data.IRemoteDataSource
import bo.edu.data.MoviesRepository
import bo.edu.framework.MovieDataSource
import bo.edu.framework.RetrofitBuilder
import bo.edu.usecases.GetPopularMovie
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun AndroidApplication.initDI() {
    startKoin {
        androidLogger()
        androidContext(this@initDI)
        modules(listOf(appModule, scopeModule, dataModule, frameworkModule))
    }
}


private val scopeModule = module {
    scope(named<MainActivity>()) {
        viewModel { MainViewModel(get()) }
        scoped { GetPopularMovie(get()) }
    }
}

private val dataModule = module {
    factory { MoviesRepository(get())  }
    factory<IRemoteDataSource> { MovieDataSource(get(), get(named("apiKey")))  }
}
private val frameworkModule = module {
    factory { RetrofitBuilder }
}
private val appModule = module {
    single(named("apiKey")) { androidApplication().getString(R.string.api_key) }
}



