package com.bayusurapati.projectukl1.Data.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bayusurapati.projectukl1.Data.Entity.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun tambahTeman(friend: User)

    @Query("SELECT * FROM User")
    fun ambilSemuaTeman(): LiveData<List<User>>
}