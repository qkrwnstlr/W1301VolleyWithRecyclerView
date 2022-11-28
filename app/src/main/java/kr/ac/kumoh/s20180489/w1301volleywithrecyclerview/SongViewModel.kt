package kr.ac.kumoh.s20180489.w1301volleywithrecyclerview

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class SongViewModel(application: Application) : AndroidViewModel(application) {
    data class Song(var id: Int, var title: String, var singer: String)

    companion object {
        const val QUEUE_TAG = "SongVolleyRequest"
    }

    private val songs = ArrayList<Song>()
    private val _list = MutableLiveData<ArrayList<Song>>()

    val list: LiveData<ArrayList<Song>>
        get() = _list

    private val queue: RequestQueue

    init {
        _list.value = songs
        queue = Volley.newRequestQueue(getApplication())
    }

    fun requestSong() {
        val request = JsonArrayRequest(
            Request.Method.GET,
            "https://expresssongdb-vhkim.run.goorm.io/",
            null,
            {
                Toast.makeText(
                    getApplication(),
                    it.toString(), Toast.LENGTH_LONG
                ).show()
            },
            {
                Toast.makeText(
                    getApplication(),
                    it.toString(), Toast.LENGTH_LONG
                ).show()
            }
        )
    }
}