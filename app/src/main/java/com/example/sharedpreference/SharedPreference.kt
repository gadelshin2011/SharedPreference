package com.example.sharedpreference

import android.content.Context
import android.content.SharedPreferences

class SharedPreference(val context: Context) {
    private val PREF_NAME = "data_storage"
    var SharedPreference = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveString(KEY_NAME: String, value: String) {
        val editor: SharedPreferences.Editor = SharedPreference.edit()

        editor.putString(KEY_NAME, value)

        editor.commit()
    }
    fun saveInt(KEY_NAME: String, value: Int) {
        val editor: SharedPreferences.Editor = SharedPreference.edit()

        editor.putInt(KEY_NAME, value)

        editor.commit()
    }

    fun saveBoolean(KEY_NAME: String, status: Boolean) {

        val editor: SharedPreferences.Editor = SharedPreference.edit()

        editor.putBoolean(KEY_NAME, status!!)

        editor.commit()
    }




    fun getValueString(KEY_NAME: String): String? {

        return SharedPreference.getString(KEY_NAME, null)
    }


    fun clearSharedPreference() {

        val editor: SharedPreferences.Editor = SharedPreference.edit()

        //sharedPref = PreferenceManager.getDefaultSharedPreferences(context);

        editor.clear()
        editor.commit()
    }

    fun removeValue(KEY_NAME: String) {

        val editor: SharedPreferences.Editor = SharedPreference.edit()

        editor.remove(KEY_NAME)
        editor.commit()
    }





}
