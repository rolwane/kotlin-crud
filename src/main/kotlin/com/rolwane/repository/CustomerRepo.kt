package com.rolwane.repository

import com.rolwane.dto.CustomerRequestDTO
import com.rolwane.dto.CustomerResponseDTO
import com.rolwane.interfaces.ICustomerRepo
import com.rolwane.models.Customer
import org.ktorm.database.Database
import org.ktorm.dsl.forEach
import org.ktorm.dsl.from
import org.ktorm.dsl.insert
import org.ktorm.dsl.select

class CustomerRepo : ICustomerRepo {
    override val database = Database.connect("jdbc:mysql://localhost:3306/store", user = "root", password = "root")

    override fun create(customer: CustomerRequestDTO) {
        database.insert(Customer) {
            set(it.name, customer.name)
            set(it.email, customer.email)
            set(it.cpf, customer.cpf)
        }
    }

    override fun getAll(): List<CustomerResponseDTO> {
        val customers = mutableListOf<CustomerResponseDTO>()

        database
            .from(Customer)
            .select()
            .forEach { row -> customers.add(CustomerResponseDTO(
                row[Customer.id]!!,
                row[Customer.name]!!,
                row[Customer.email]!!,
                row[Customer.cpf]!!
            )) }

        return customers
    }
}
