package pl.edu.wat.roomdbmanagement.dataManagement

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 DATA CLASS - klasa reprezentująca rekord w tabeli:
 */

@Entity(tableName = "TheFlower_employers")
data class TheFlowerEmployer (
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String,
    val surname : String,
    val emplacement : String
    )
