package com.crowdfunding.dashboard

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.crowdfunding.agri_fund.R

class Campaign : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_campaign)
        
        val submit = findViewById<Button>(R.id.campaignSubmit)
        val etTitle = findViewById<EditText>(R.id.campaignTitle)
        val etDesc = findViewById<EditText>(R.id.campaignDescription)
        val etTargetAmt = findViewById<EditText>(R.id.campaignTarget)
        val selectedTypeRd = findViewById<RadioGroup>(R.id.campaignType)



        //when submit is clicked
        submit.setOnClickListener{
            val theTitle = etTitle.text.toString()
            val theDesc = etDesc.text.toString()
            val theTargetAmt = etTargetAmt.text.toString()
            selectedTypeRd.setOnCheckedChangeListener{ _,checkedId ->


            }

        }//end

    }
}