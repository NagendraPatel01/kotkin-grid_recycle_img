package com.dw.gridlayoutkotlin

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    var adapter: HorizontalRecyclerView? = null
    var uri = ArrayList<Uri>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView = findViewById<RecyclerView>(R.id.recycle)
        val button = findViewById<Button>(R.id.btn)

        button.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            startActivityForResult(Intent.createChooser(intent, "Pictures: "), 1)
        })

        adapter = HorizontalRecyclerView(uri)
        recyclerView.setLayoutManager(GridLayoutManager(this, 2))
        recyclerView.setAdapter(adapter)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    if (data.clipData != null) {
                        val count = data.clipData!!.itemCount
                        for (i in 0 until count) {
                            uri.add(data.clipData!!.getItemAt(i).uri)
                        }
                        adapter!!.notifyDataSetChanged()
                    }
                }
            } else if (data != null) {
                if (data.data != null) {
                    val imagePath = data.data!!.path
                }
            }
        }
    }

}