package fr.imaginnovation.moneytracker

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database(context : Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    var databaseInfo = DatabaseInfo

    companion object {
        const val DATABASE_NAME = "FlowDatabase.db"
        const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db.execSQL(databaseInfo.SQL_CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db.execSQL(databaseInfo.SQL_DELETE_TABLE_QUERY)
        onCreate(db)
    }



}