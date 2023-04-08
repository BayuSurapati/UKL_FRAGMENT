package com.bayusurapati.projectukl1.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bayusurapati.projectukl1.Data.Dao.UserDao
import com.bayusurapati.projectukl1.Data.Entity.User
import com.bayusurapati.projectukl1.FragmentOne

@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun myFriendDao(): UserDao
    companion object{
        var INSTANCE: AppDatabase?=null
        fun getAppDatabase(context: Context): AppDatabase?{
            if(INSTANCE == null){
                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "MyFriendDB").build()
                }
            }
            return INSTANCE
        }
        fun destroyDatabase(){
            INSTANCE = null
        }
    }
}