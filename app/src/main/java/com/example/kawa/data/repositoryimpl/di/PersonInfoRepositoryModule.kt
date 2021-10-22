package com.example.kawa.data.repositoryimpl.di

import com.example.kawa.data.mapper.PersonInfoResponseMapper
import com.example.kawa.data.network.PersonInfoService
import com.example.kawa.data.repositoryimpl.PersonInfoRepositoryImpl
import com.example.kawa.domain.repository.PersonInfoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
class PersonInfoRepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun providePersonInfoRepository(
        personInfoService: PersonInfoService,
        personInfoResponseMapper: PersonInfoResponseMapper
    ): PersonInfoRepository {
        return PersonInfoRepositoryImpl(
            personInfoService,
            personInfoResponseMapper
        )
    }
}