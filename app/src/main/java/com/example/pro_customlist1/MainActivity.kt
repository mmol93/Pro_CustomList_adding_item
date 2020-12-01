package com.example.pro_customlist1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data1 = mutableListOf<String>()
        val data2 = mutableListOf<Int>()
        var counter = 1

        val totalData = ArrayList<HashMap<String, Any>>()

        // 1. editText to textView
        button1.setOnClickListener {
            if (checkBox1.isChecked){
                textView1.text = editText1.text
            }
            // 2. editText to listView
            // 2-1. whenever you click the button, text will be added on listView
            if(checkBox2.isChecked){
                data1.add(editText1.text.toString())
                data2.add(counter)
                counter += 1

                for (i in data1.indices){
                    val map = HashMap<String, Any>()
                    map["data1"] = data1[i]
                    map["num1"] = data2[i]

                    totalData.add(map)
                }
                val keys = arrayOf("data1", "num1")
                val values = intArrayOf(R.id.list_textView1, R.id.list_textView2)

                val adapter1 = SimpleAdapter(this, totalData, R.layout.list_row_no_img, keys, values)
                list1.adapter = adapter1
                data1.clear()
                data2.clear()
            }
        }
    }
}