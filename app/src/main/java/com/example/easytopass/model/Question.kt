package com.example.easytopass.model


import android.os.Parcel
import android.os.Parcelable

data class Question(
    val id: Long,
    val title: String,
    val options: List<String>,
    val image: String,
    val correctAnswer: String,
    val indexCorrectAnswer: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString() ?: "",
        parcel.createStringArrayList() ?: listOf(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(title)
        parcel.writeStringList(options)
        parcel.writeString(image)
        parcel.writeString(correctAnswer)
        parcel.writeInt(indexCorrectAnswer)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Question> {
        override fun createFromParcel(parcel: Parcel): Question {
            return Question(parcel)
        }

        override fun newArray(size: Int): Array<Question?> {
            return arrayOfNulls(size)
        }
    }
}
