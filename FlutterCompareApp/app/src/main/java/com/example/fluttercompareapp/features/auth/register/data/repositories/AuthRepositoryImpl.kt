package com.example.fluttercompareapp.features.auth.register.data.repositories

import com.example.fluttercompareapp.core.domain.util.Resource
import com.example.fluttercompareapp.features.auth.register.domain.repositories.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor() : AuthRepository {
    private val firebaseAuth = FirebaseAuth.getInstance()


    override suspend fun register(email: String, password: String): Resource<FirebaseUser?> {
        return try {
            Resource.Success(
                firebaseAuth.createUserWithEmailAndPassword(email, password).await().user
            )
        } catch (e: Exception) {
            Resource.Error(e.message ?: "")
        }
    }


    override suspend fun login(email: String, password: String): Resource<FirebaseUser?> {
        return try {
            Resource.Success(firebaseAuth.signInWithEmailAndPassword(email, password).await().user)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "")
        }
    }

    override fun logout(): Resource<Unit> {
        return try {
            firebaseAuth.signOut()
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "")
        }
    }


    override fun subscribeToAuthChanges(): Flow<FirebaseUser?> = callbackFlow {
        val listener = FirebaseAuth.AuthStateListener { auth ->
            val user = auth.currentUser
            trySend(user).isSuccess
        }
        firebaseAuth.addAuthStateListener(listener)
        awaitClose { firebaseAuth.removeAuthStateListener(listener) }
    }
}