package com.crowdfunding.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
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
        val etHost = findViewById<EditText>(R.id.campaignHost)


        //when submit is clicked
        submit.setOnClickListener{
            val theTitle = etTitle.text.toString()
            val theDesc = etDesc.text.toString()
            val theTargetAmt = etTargetAmt.text.toString()

            val selectedRd:Int = selectedTypeRd!!.checkedRadioButtonId
            val type = findViewById<RadioButton>(selectedRd)
            val selectedType = type?.text.toString()

            val theHost =  etHost.text.toString()

            val intent = Intent(this, Invest::class.java).apply{
                putExtra("getTitle", theTitle)
                putExtra("getDescription", theDesc)
                putExtra("getTargetAmt", theTargetAmt)
                putExtra("getType", selectedType)
                putExtra("getHost", theHost)

            }

            startActivity(intent)

        }//end

    }
}