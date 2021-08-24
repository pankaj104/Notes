package abc.com.notes

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.selects.select

@Dao
interface NoteDao {
    @Insert (onConflict = OnConflictStrategy.IGNORE)
  suspend fun  insert(note: Note)
@Delete
   suspend fun delete(note: Note)
@Query("Select * from notes_table order by id ASC")
    fun getAllNotes():LiveData<List<Note>>
}