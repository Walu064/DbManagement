package pl.edu.wat.roomdbmanagement.dataManagement

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 Rolą tej klasy jest prowadzenie danych do interfejsu użytkownika aplikacji. Stanowi główne
 centrum komunikacyjne pomiędzy repozytorium, a GUI aplikacji.
 */

class TheFlowerEmployerViewModel(application : Application) : AndroidViewModel(application) {

    private val readAllData : LiveData<List<TheFlowerEmployer>>
    private val repository : TheFlowerEmployerRepository

    init{
        val theFlowerEmployerDao = TheFlowerEmployerDb.getDb(application).theFlowerEmployerDao()
        repository = TheFlowerEmployerRepository(theFlowerEmployerDao)
        readAllData = repository.readAllData
    }

    fun insertEmployer(theFlowerEmployer: TheFlowerEmployer){
        viewModelScope.launch(Dispatchers.IO){
            repository.insertEmployer(theFlowerEmployer)
        }
    }
}