package bo.edu.cleanexampleucb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import bo.edu.data.MoviesRepository
import bo.edu.domain.Movie
import bo.edu.framework.MovieDataSource
import bo.edu.framework.RetrofitBuilder
import bo.edu.usecases.GetPopularMovie
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = GridLayoutManager(this, 3)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        val useCases = GetPopularMovie(MoviesRepository(MovieDataSource(RetrofitBuilder, getString(R.string.api_key))))

        mainViewModel = MainViewModel(useCases)

        mainViewModel.model.observe(this, Observer(::updateUi))

        mainViewModel.loadMovies()
//
//        GlobalScope.launch(Dispatchers.IO) {
//            val list = useCases.invoke()
//
//            list.forEach {
//                Log.d("MOVIE", it.title )
//            }
//        }

    }

    fun updateUi(model: MainViewModel.UiModel) {
        when( model) {
            is MainViewModel.UiModel.Content -> showlist(model.movies)
        }
    }

    fun showlist(list: List<Movie>) {
        recyclerView.adapter = MainAdapter(list)
    }


}