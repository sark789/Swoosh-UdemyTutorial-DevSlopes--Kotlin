package com.timpolicar.swoosh.Model

import android.os.Parcel
import android.os.Parcelable

class Player(var league: String?, var skill: String?) : Parcelable{ //parcelable wraps up everything in a class and put it in format so u can pass it thru activities, it unwraps on the other activity
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(league)
        parcel.writeString(skill)
    }

    // we wont be needing this
    override fun describeContents(): Int {
        return 0
    }

    // this 2 methods are required for parcelable class
    companion object CREATOR : Parcelable.Creator<Player> {
        override fun createFromParcel(parcel: Parcel): Player {
            return Player(parcel)
        }

        override fun newArray(size: Int): Array<Player?> {
            return arrayOfNulls(size)
        }
    }

}
