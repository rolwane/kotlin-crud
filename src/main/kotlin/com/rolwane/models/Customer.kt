package com.rolwane.models

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Customer : Table<Nothing>("customers") {
    val id = int("id").primaryKey()
    val name = varchar("name")
    val email = varchar("email")
    val cpf = varchar("cpf")
}
