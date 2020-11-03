package bo.edu.cleanexampleucb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import bo.edu.data.MoviesRepository
import bo.edu.framework.MovieDataSource
import bo.edu.framework.RetrofitBuilder
import bo.edu.usecases.GetPopularMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val useCases = GetPopularMovie(MoviesRepository(MovieDataSource(RetrofitBuilder, getString(R.string.api_key))))

        GlobalScope.launch(Dispatchers.IO) {
            val list = useCases.invoke()

            list.forEach {
                Log.d("MOVIE", it.title )
            }
        }

    }
}