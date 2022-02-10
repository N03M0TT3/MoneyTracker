package fr.imaginnovation.moneytracker

import android.provider.BaseColumns

object DatabaseInfo {

    const val SQL_CREATE_TABLE_QUERY =
        "CREATE TABLE ${TableInfo.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${TableInfo.COLUMN_FLOW_VALUE} NUMBER," +
                "${TableInfo.COLUMN_FLOW_NAME} TEXT," +
                "${TableInfo.COLUMN_FLOW_METHOD} TEXT," +
                "${TableInfo.COLUMN_FLOW_DATE} TEXT," +
                "${TableInfo.COLUMN_FLOW_NOTE} TEXT)"

    const val SQL_DELETE_TABLE_QUERY = "DROP TABLE IF EXISTS ${TableInfo.TABLE_NAME}"


    // Table contents are grouped together in an anonymous object.
    object TableInfo : BaseColumns {
        const val TABLE_NAME = "flowTable"
        const val COLUMN_FLOW_VALUE = "flowValue"
        const val COLUMN_FLOW_NAME = "flowName"
        const val COLUMN_FLOW_METHOD = "flowMethod"
        const val COLUMN_FLOW_DATE = "flowDate"
        const val COLUMN_FLOW_NOTE = "flowNote"
    }
}
