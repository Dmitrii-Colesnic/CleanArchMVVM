package com.example.cleanarchmvvm.data.sharedprefs_storage

import android.content.Context

private const val SHARED_PREFS_NAME = "SHARED_PREFS_NAME"
private const val KEY_FIRST_NAME = "KEY_FIRST_NAME"
private const val KEY_LAST_NAME = "KEY_LAST_NAME"
private const val DEFAULT_FIRST_NAME = ""
private const val DEFAULT_LAST_NAME = "Default last name"

class SharedPrefsUserStorage(context: Context): UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        return true
    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, DEFAULT_FIRST_NAME) ?: DEFAULT_FIRST_NAME
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_LAST_NAME) ?: DEFAULT_LAST_NAME
        return User(firstName, lastName)
    }
}