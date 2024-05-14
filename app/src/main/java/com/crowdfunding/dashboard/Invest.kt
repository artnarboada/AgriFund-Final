package com.crowdfunding.dashboard

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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

        val campaignTitle = findViewById<EditText>(R.id.campaignTitle)

        searchText = findViewById(R.id.searchbar)
        camArrayList = ArrayList()
        recCampaign = findViewById(R.id.listOfCampaign)
        adapter = AdapterClass(camArrayList, this)
        val layoutManager = LinearLayoutManager(this)
        recCampaign.layoutManager = layoutManager
        recCampaign.adapter = adapter

        setCamList()
        searchData()

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
        camArrayList.add(DataClass("Piggery", "Starting in piggery business and farming",
            "50,000","Crops", "Art narboada"))
        camArrayList.add(DataClass("Crops", "Starting crops farming",
            "40,000","Crops", "miles maratas"))
        camArrayList.add(DataClass("Telapia farm", "Starting fish farming",
            "30,000","Fish", "lowe canete"))
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

