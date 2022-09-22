package com.example.studentplacementandroidapp.databaseConnection
import java.sql.Connection
import java.sql.DriverManager

class Database {

    private var connection: Connection? = null

    // For Local PostgreSQL
    private val host = "containers-us-west-33.railway.app"
    private val database = "railway";
    private val port = 8002;
    private val user = "postgres";
    private val pass = "kGioGYyedLxkNiiJKR3m";
    private var url = "jdbc:postgresql://%s:%d/%s"
    private var status = false

    init{
        url = String.format(url, this.host, this.port, this.database)
        connect()
        println("connection status:$status")
    }

    private fun connect() {
        val thread = Thread {
            try {
                Class.forName("org.postgresql.Driver")
                connection = DriverManager.getConnection(url, user, pass)
                status = true
                println("connected:${this.status}")
            } catch (e: Exception) {
                status = false
                print(e.message)
                e.printStackTrace()
            }
        }
        thread.start()
        try {
            thread.join()
        } catch (e: Exception) {
            e.printStackTrace()
            status = false
        }
    }

    fun getExtraConnection(): Connection? {
        var c: Connection? = null
        try {
            Class.forName("org.postgresql.Driver")
            c = DriverManager.getConnection(url, user, pass)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return c
    }
}