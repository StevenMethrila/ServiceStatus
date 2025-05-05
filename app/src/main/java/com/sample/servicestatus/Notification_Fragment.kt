package com.sample.servicestatus

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class Notification_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("NotificationFragment", "Fragment created")
        return inflater.inflate(R.layout.fragment_notification_, container, false)
    }

}