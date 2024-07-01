package com.example.easytopass.model


import android.os.Parcel
import android.os.Parcelable

data class Chapter(
    val id: Long,
    val name: String,
    val bookName:String,
    val sizeQuestion: Int,
    val questions: List<Question>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        mutableListOf<Question>().apply {
            parcel.readList(this as List<*>, Question::class.java.classLoader)
        }
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeString(bookName)
        parcel.writeInt(sizeQuestion)
        parcel.writeList(questions)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Chapter> {
        override fun createFromParcel(parcel: Parcel): Chapter {
            return Chapter(parcel)
        }

        override fun newArray(size: Int): Array<Chapter?> {
            return arrayOfNulls(size)
        }
    }
}
