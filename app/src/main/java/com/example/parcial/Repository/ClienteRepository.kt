package com.example.parcial.Repository

import com.example.parcial.DAO.ClienteDao
import com.example.parcial.Model.Cliente

class ClienteRepository(private val clienteDao: ClienteDao) {

    suspend fun insertCliente(cliente: Cliente) {
        clienteDao.insertCliente(cliente)
    }

    suspend fun updateCliente(cliente: Cliente) {
        clienteDao.updateCliente(cliente)
    }

    suspend fun deleteCliente(cliente: Cliente) {
        clienteDao.deleteCliente(cliente)
    }

    suspend fun getClienteById(id: Int): Cliente? {
        return clienteDao.getClienteById(id)
    }

    suspend fun getAllClientes(): List<Cliente> {
        return clienteDao.getAllClientes()
    }
}