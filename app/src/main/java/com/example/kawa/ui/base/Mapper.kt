package com.example.kawa.ui.base

interface Mapper<R, D> {
    fun mapFrom(sourceModel: R): D
}