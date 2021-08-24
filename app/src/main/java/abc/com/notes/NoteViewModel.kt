package abc.com.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.w3c.dom.Node

class NoteViewModel(application: Application) : AndroidViewModel(application){
    private val   repository : NoteRepository
   // private val repository: NoteRepository = TODO()
    val allNotes:LiveData<List<Note>>
    init{
        val dao= NoteDatabase.getDatabase(application).getNoteDao()
         repository=NoteRepository(dao)
        allNotes=repository.allNotes

    }
    fun deleteNote(note: Note)=viewModelScope.launch (Dispatchers.IO){
repository.delete(note)
    }
    fun insertNote(note: Note)=viewModelScope.launch (Dispatchers.IO){
        repository.insert(note)
    }
}