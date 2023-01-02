package com.rolwane.routes

import com.rolwane.dto.CustomerRequestDTO
import com.rolwane.repository.CustomerRepo
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.customerRouting() {
    val customerRepo = CustomerRepo()

    route("/customer") {
        post {
            val customer = call.receive<CustomerRequestDTO>()
            customerRepo.create(customer)
            call.respond(HttpStatusCode.Created, customer)
        }

        get {
            val customers = customerRepo.getAll()
            call.respond(HttpStatusCode.OK, customers)
        }
    }
}
