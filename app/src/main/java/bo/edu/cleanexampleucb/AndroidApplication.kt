package bo.edu.cleanexampleucb

import android.app.Application

class AndroidApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initDI()
    }

}