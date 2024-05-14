package com.crowdfunding.dashboard
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import com.crowdfunding.agri_fund.R
import java.io.File

class UserProfile: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        // Set the profile picture using a Bitmap
        val profilePictureImageView = findViewById<ImageView>(R.id.profile_picture)
        val file = File(getExternalFilesDir(null), "profile_picture.jpg")
        if (file.exists()) {
            val profilePictureBitmap = BitmapFactory.decodeFile(file.absolutePath)
            profilePictureImageView.setImageBitmap(profilePictureBitmap)
        }

        // Set the click listener for the profile picture button
        val profilePictureButton = findViewById<Button>(R.id.profile_picture_button)
        profilePictureButton.setOnClickListener {
            // Open the image picker activity to allow the user to select a new profile picture
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 1)
        }

        // Set the home button click listener
        val homeButtonCs = findViewById<Button>(R.id.homeButtonCs)
        homeButtonCs.setOnClickListener {
            finish()
        }

        // Set the click listener for the profile picture image view
        profilePictureImageView.setOnClickListener {
            // Open a dialog or activity for the user to select a new profile picture
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            val file = File(getExternalFilesDir(null), "profile_picture.jpg")
            val imageUri = data.data
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri)
            val outputStream = file.outputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
            outputStream.flush()
            outputStream.close()
            val profilePictureImageView = findViewById<ImageView>(R.id.profile_picture)
            val profilePictureBitmap = BitmapFactory.decodeFile(file.absolutePath)
            profilePictureImageView.setImageBitmap(profilePictureBitmap)
        }
    }
}