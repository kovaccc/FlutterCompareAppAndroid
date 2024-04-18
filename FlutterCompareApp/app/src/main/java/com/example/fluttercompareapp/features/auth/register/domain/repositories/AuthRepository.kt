package com.example.fluttercompareapp.features.auth.register.domain.repositories

import com.example.fluttercompareapp.core.domain.util.Resource
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun register(email: String, password: String): Resource<FirebaseUser?>
    suspend fun login(email: String, password: String): Resource<FirebaseUser?>
    fun logout(): Resource<Unit>
    fun subscribeToAuthChanges(): Flow<FirebaseUser?>
}