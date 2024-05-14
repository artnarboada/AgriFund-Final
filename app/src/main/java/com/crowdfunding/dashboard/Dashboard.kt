package com.crowdfunding.dashboard
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
//import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.crowdfunding.AdapterClass
import com.crowdfunding.DataClass
import com.crowdfunding.agri_fund.R


class Dashboard : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)

        //forCampaignList




        //for menu trigger
        val menuSpinner = findViewById<Spinner>(R.id.menuSpinner)
        menuSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> {
                        // Start Profile activity
                        val intent = Intent(this@Dashboard, UserProfile::class.java)
                        startActivity(intent)
                    }
                    1 -> {
                        // Start Customer Support activity
                        val intent = Intent(this@Dashboard, Cs::class.java)
                        startActivity(intent)
                    }
                    // Handle other menu items if needed
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case when nothing is selected (if needed)
            }
        }


        //for Business
        val businessBut = findViewById<Button>(R.id.businessButton)
        businessBut.setOnClickListener {
            val intent = Intent(this, Business::class.java)
            startActivity(intent)
        }

        //for Campaign
        val campaignBut = findViewById<Button>(R.id.campaignButton)
        campaignBut.setOnClickListener {
            val intent2 = Intent(this, Campaign::class.java)
            startActivity(intent2)
        }

        //for Progress
        val progressBut = findViewById<Button>(R.id.progressButton)
        progressBut.setOnClickListener {
            val intent = Intent(this, Progress::class.java)
            startActivity(intent)
        }

        //for Invest button
        val investBut = findViewById<Button>(R.id.investButton)
        investBut.setOnClickListener {
            val intent = Intent(this, Invest::class.java)
            startActivity(intent)
        }


    }



}
