package com.example.fluttercompareapp.core.di

import android.content.Context
import com.example.fluttercompareapp.core.data.database.AppDatabase
import com.example.fluttercompareapp.features.photos.data.dao.PhotoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun providePhotosDao(appDatabase: AppDatabase): PhotoDao {
        return appDatabase.photoDao()
    }
}