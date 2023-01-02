package com.rolwane.interfaces

import com.rolwane.dto.CustomerRequestDTO
import com.rolwane.dto.CustomerResponseDTO
import org.ktorm.database.Database

interface ICustomerRepo {
    val database: Database

    fun create(customer: CustomerRequestDTO)
    fun getAll(): List<CustomerResponseDTO>
}