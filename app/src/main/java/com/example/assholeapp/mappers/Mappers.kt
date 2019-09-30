package com.example.assholeapp.mappers

import com.example.assholeapp.api.CatApi
import com.example.assholeapp.db.CatDb

fun List<CatApi>.toCatsDb(): List<CatDb> =
        map { catApi -> catApi.toCatDb() }

fun CatApi.toCatDb(): CatDb =
        CatDb().apply { imageUrl = this@toCatDb.imageUrl }