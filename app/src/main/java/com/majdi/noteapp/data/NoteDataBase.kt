package com.majdi.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.majdi.noteapp.model.Note
import com.majdi.noteapp.util.DateConverter
import com.majdi.noteapp.util.UuidConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class,UuidConverter::class)
abstract class NoteDataBase : RoomDatabase() {
    abstract fun noteDao() : NoteDataBaseDao
}