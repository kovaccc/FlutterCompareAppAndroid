package com.example.fluttercompareapp.common.data.mappers

typealias DatabaseMapper<DBEntity, Response> = (Response) -> DBEntity
