package com.rsh_engineering.tkachenkoni.imagedownloadurl

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.net.URL

class MainActivity : AppCompatActivity() {

    private val IMAGE_URL = "http://www.rsh-engineering.com/logo.gif"

    private val corotineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        corotineScope.launch {
            val originalDeferred = corotineScope.async(Dispatchers.IO) {
                getOriginalBitmap()
            }
            val originalBitmap = originalDeferred.await()
            val filteredDeferred = corotineScope.async(Dispatchers.Default) {
                applyFilter(originalBitmap)
            }
            val filteredBitmap = filteredDeferred.await()
            //loadImage(originalBitmap)
            loadImage(filteredBitmap)
        }
    }

    private fun getOriginalBitmap() = URL(IMAGE_URL).openStream().use { BitmapFactory.decodeStream(it) }

    private fun applyFilter(originalBitmap: Bitmap) = Filter.apply(originalBitmap)

    private fun loadImage(bmp: Bitmap){
        progressBar.visibility = View.GONE
        imageView.setImageBitmap(bmp)
        imageView.visibility = View.VISIBLE
    }

}
