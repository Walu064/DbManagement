package pl.edu.wat.roomdbmanagement.dataManagement
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 Interfejs Dao - zawiera metody używane do uzyskania
 dostępu do zawartości bazy danych
 */

@Dao
interface TheFlowerEmployerDao {

    /**
     Walidacja dodawania kolejnych insertów - w razie
     powtórzenia rekordu insert zostanie zignorowany
     */

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertEmployer(theFlowerEmployer: TheFlowerEmployer)

    @Query("SELECT * FROM TheFlower_employers ORDER BY id ASC")
    fun readAllData(): LiveData<List<TheFlowerEmployer>>

}