package com.example.kawa.domain.usecase.di

import com.example.kawa.domain.repository.PersonInfoRepository
import com.example.kawa.domain.usecase.GetPersonInfoListUseCase
import com.example.kawa.domain.usecase.GetPersonInfoListUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
class PersonInfoModule {

    @Provides
    @ActivityRetainedScoped
    fun provideGetPersonInfoListUseCase(personInfoRepository: PersonInfoRepository): GetPersonInfoListUseCase {
        return GetPersonInfoListUseCaseImpl(personInfoRepository)
    }
}