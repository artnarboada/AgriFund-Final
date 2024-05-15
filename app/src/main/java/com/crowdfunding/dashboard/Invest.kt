package com.crowdfunding.dashboard

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.crowdfunding.AdapterClass
import com.crowdfunding.DataClass
import com.crowdfunding.agri_fund.R

class Invest : AppCompatActivity() {
    private lateinit var camArrayList:ArrayList<DataClass>
    private lateinit var adapter: AdapterClass
    private lateinit var recCampaign: RecyclerView
    private lateinit var searchText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_invest)

       // val campaignTitle = findViewById<EditText>(R.id.campaignTitle)

        searchText = findViewById(R.id.searchbar)
        camArrayList = ArrayList()
        recCampaign = findViewById(R.id.listOfCampaign)
        adapter = AdapterClass(camArrayList, this)
        val layoutManager = LinearLayoutManager(this)
        recCampaign.layoutManager = layoutManager
        recCampaign.adapter = adapter




        setCamList()
        searchData()

        val addbtn = findViewById<Button>(R.id.newCamp)
        addbtn.setOnClickListener {
            val intent = Intent(this, Campaign::class.java)
            startActivity(intent)
        }

    }
    private fun searchData() {
        searchText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                filter(s.toString())

            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }

    private fun setCamList() {
        // Retrieve data from putExtra
        val getTitle = intent.getStringExtra("getTitle")
        val getDesc = intent.getStringExtra("getDescription")
        val getTarget = intent.getStringExtra("getTargetAmt")
        val getType = intent.getStringExtra("getType")
        val getHost = intent.getStringExtra("getHost")

        // Check for null values
        if (getTitle != null && getDesc != null && getTarget != null && getType != null && getHost != null) {
            // Create a DataClass object and add it to camArrayList
            val data = DataClass(getTitle, getDesc, getTarget, getType, getHost)
            addCamData(data)
        } else {
            // Handle the case where any of the retrieved strings are null
            // For example, show a toast message or log an error
            Toast.makeText(this, "Invalid!", Toast.LENGTH_SHORT).show()
        }
    }

    // Function to add new items to camArrayList
    private fun addCamData(data: DataClass) {
        camArrayList.add(data)
        adapter.notifyDataSetChanged()
    }


    private fun filter(text:String){
        val filteredList = ArrayList<DataClass>()
        for(item in camArrayList){
            if(item.title.lowercase().contains(text.lowercase())){
                filteredList.add(item)
            }
        }
        adapter.filterList(filteredList)
        if(filteredList.isEmpty()){
            Toast.makeText(this, "No Data Found!", Toast.LENGTH_SHORT).show()
        }
    }

}

