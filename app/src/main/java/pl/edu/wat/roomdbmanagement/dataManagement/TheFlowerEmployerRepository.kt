package pl.edu.wat.roomdbmanagement.dataManagement

import androidx.lifecycle.LiveData

class TheFlowerEmployerRepository (private val theFlowerEmployerDao: TheFlowerEmployerDao) {

    val readAllData : LiveData<List<TheFlowerEmployer>> = theFlowerEmployerDao.readAllData()

    suspend fun insertEmployer(theFlowerEmployer: TheFlowerEmployer){
        theFlowerEmployerDao.insertEmployer(theFlowerEmployer)
    }

}