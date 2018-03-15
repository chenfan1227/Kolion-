package com.test.myapplication

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.chen.gittestdemo.R

@SuppressLint("Registered")
/**
 * web界面
* */
class WebViewActivityDm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_dm)
        init()
    }

    fun init() {
        val web = WebView(this)
        setContentView(web)
        web.settings.javaScriptEnabled = true
        web.loadUrl("https://www.baidu.com")

    }
}
