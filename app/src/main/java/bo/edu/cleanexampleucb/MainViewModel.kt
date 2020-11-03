package bo.edu.cleanexampleucb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import bo.edu.domain.Movie
import bo.edu.usecases.GetPopularMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(private val popularMovie: GetPopularMovie): ViewModel() {

    val model: LiveData<UiModel>
        get() = _model
    private val _model = MutableLiveData<UiModel>()
    sealed class UiModel {
        class Content(val movies: List<Movie>): UiModel()
    }

    fun loadMovies() {
        GlobalScope.launch(Dispatchers.IO) {
            _model.value = UiModel.Content( popularMovie.invoke())
        }

    }


}