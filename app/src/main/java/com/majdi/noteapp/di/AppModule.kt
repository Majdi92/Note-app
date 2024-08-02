package com.majdi.noteapp.di

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Room
import com.majdi.noteapp.data.NoteDataBase
import com.majdi.noteapp.data.NoteDataBaseDao
import com.majdi.noteapp.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNotesDao(noteDatabase: NoteDataBase): NoteDataBaseDao
            = noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): NoteDataBase
            = Room.databaseBuilder(
        context,
        NoteDataBase::class.java,
        "notes_db")
        .fallbackToDestructiveMigration()
        .build()

}