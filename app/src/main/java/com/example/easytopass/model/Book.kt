package com.example.easytopass.model


import android.os.Parcel
import android.os.Parcelable

data class Book(
    val id: Long,
    val name: String,
    val chapters: List<Chapter>,
    val image: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString() ?: "",
        mutableListOf<Chapter>().apply {
            parcel.readList(this as List<*>, Chapter::class.java.classLoader)
        },
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeList(chapters)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Book> {
        override fun createFromParcel(parcel: Parcel): Book {
            return Book(parcel)
        }

        override fun newArray(size: Int): Array<Book?> {
            return arrayOfNulls(size)
        }
    }
}
