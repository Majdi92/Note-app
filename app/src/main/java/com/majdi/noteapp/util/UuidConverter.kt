package com.majdi.noteapp.util

import androidx.room.TypeConverter
import java.util.UUID

class UuidConverter {
    @TypeConverter
    fun fromUuid(uuid: UUID) : String {
        return uuid.toString()
    }

    @TypeConverter
    fun toUuid(uuid: String) : UUID {
        return UUID.fromString(uuid)
    }
}