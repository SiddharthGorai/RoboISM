package com.sid.roboism.ui

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.sid.roboism.R
import com.sid.roboism.data.CreateAnnouncementModel
import com.sid.roboism.data.PushNotification
import com.sid.roboism.databinding.FragmentNewAnnoucementBinding



class NewAnnoucementFragment : Fragment() {

    private val topic = "/topics/announcement"
    private var _binding: FragmentNewAnnoucementBinding? = null
    private val binding get() = _binding!!
    private lateinit var dialog: Dialog


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewAnnoucementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSubmit.setOnClickListener {
            if(binding.etTitle.text.isEmpty()) {
                Toast.makeText(context, "Please enter the title", Toast.LENGTH_SHORT).show()
            }
            else if(binding.etBody.text.isEmpty()) {
                Toast.makeText(context, "Please enter the body", Toast.LENGTH_SHORT).show()
            }
            else {
                val title = binding.etTitle.text.toString()
                val body = binding.etBody.text.toString()

//                sendAnnouncement(title, body)
            }
        }
    }
//    private fun sendAnnouncement(title: String, body: String) {
//        dialog.show()
//        val newAnnouncement = CreateAnnouncementModel(title, body)
//
//        val announcementApi: AnnouncementApi = AnnouncementRetrofitInstance.announcementApi
//        val createAnnouncementCall: Call<Void> = announcementApi.createAnnouncement(newAnnouncement)
//
//        createAnnouncementCall.enqueue(object : Callback<Void> {
//            override fun onResponse(call: Call<Void>, response: Response<Void>) {
//                if (response.isSuccessful) {
////                    sendNotifications(title, body)
//                    binding.etTitle.setText("")
//                    binding.etBody.setText("")
//                    sendNotificationsToTopic(newAnnouncement)
//                } else {
//                    Log.e("CreateAnnouncement", "Failed to create announcement. Code: " + response.code())
//                    Toast.makeText(context, "Failed to create announcement", Toast.LENGTH_SHORT).show()
//                    dialog.dismiss()
//                }
//            }
//
//            override fun onFailure(call: Call<Void>, t: Throwable) {
//                Log.e("CreateAnnouncement", "Network request failed", t)
//            }
//        })
//    }
//    private fun sendNotificationsToTopic(newAnnouncement: CreateAnnouncementModel) {
//        PushNotification(newAnnouncement, topic)
//            .also {
//                sendNotification(it)
//            }
//    }
//
//    private fun sendNotification(notification: PushNotification) = CoroutineScope(Dispatchers.IO).launch {
//        try {
//            val response = NotificationRetrofitInstance.api.postNotification(notification)
//            if(response.isSuccessful) {
//                Log.d("POST NOTIFICATION", "Notification sent")
//                withContext(Dispatchers.Main) {
//                    context?.let {
//                        Toast.makeText(it, "Announcement made successfully!", Toast.LENGTH_SHORT).show()
//                    }
//                    dialog.dismiss()
//                }
//            }
//        } catch (e: Exception) {
//            Log.e("POST NOTIFICATION", e.toString())
//            withContext(Dispatchers.Main) {
//                context?.let {
//                    Toast.makeText(it, "Failed to send announcement!", Toast.LENGTH_SHORT).show()
//                }
//                dialog.dismiss()
//            }
//        }
//    }

    private fun initializeDialog() {
        dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.progress_bar)
        dialog.setCancelable(false)
        val layoutParams = WindowManager.LayoutParams().apply {
            width = WindowManager.LayoutParams.MATCH_PARENT
            height = WindowManager.LayoutParams.MATCH_PARENT
        }
        dialog.window?.attributes = layoutParams
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(requireContext(), R.color.transparent)))
        }
    }
}