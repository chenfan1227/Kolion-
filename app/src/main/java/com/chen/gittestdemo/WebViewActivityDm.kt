package com.test.myapplication

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.WebView
import com.chen.gittestdemo.R
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web_view_dm.*

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

    @SuppressLint("SetJavaScriptEnabled")
    private fun init() {
        var settings: WebSettings = web.settings
        settings.javaScriptEnabled = true  //支持js
        settings.useWideViewPort = true //将图片调整到适合webview的大小
        settings.loadWithOverviewMode = true // 缩放至屏幕的大小
        settings.cacheMode = WebSettings.LOAD_NO_CACHE  //关闭webview中缓存
        settings.domStorageEnabled = true
        web.webChromeClient = object : WebChromeClient() {
            override fun onReceivedTitle(view: WebView?, title: String?) {
                super.onReceivedTitle(view, title)
                if (title != null) {
                    text.text = title

                }
            }

            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                webviewprogress.progress = newProgress
                //加载完网页进度条消失
                if (newProgress == 100) {
                    webviewprogress.setVisibility(View.GONE)
                }
            }
        }
        //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
        web.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }
        }
        //整个url地址 可以利用传值
        web.loadUrl("https://www.csdn.net")
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {

        if (event.action == KeyEvent.ACTION_DOWN && event.keyCode == KeyEvent.KEYCODE_BACK) {
            finish()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}



