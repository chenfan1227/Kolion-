package com.chen.gittestdemo

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.test.myapplication.WebViewActivityDm
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.exit.*

class MainActivity : AppCompatActivity() {
    lateinit var mContext: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mContext = this
        initView()
    }

    @SuppressLint("InflateParams")
//list本地加载数组数据
    private fun initView() {
        val items = listOf("1", "1", "1", "1", "1", "1")
        text.visibility = View.GONE
        recycle.layoutManager = LinearLayoutManager(mContext)
        //文字编辑跟文字大小等具体操作
        recycle.adapter = MainAdapter(items)
        text.textSize = 20f
        text.textColors.defaultColor

        val dialog = Dialog(this, R.style.MyDialog)
        dialog.setContentView(R.layout.exit)
        dialog.tv_share_title.text = "测试弹出框"
        dialog.tv_content.text = "你饿了么"
        dialog.btn_myinfo_cancel.setOnClickListener { dialog.dismiss() }
        dialog.btn_myinfo_sure.setOnClickListener {
            val intent = Intent(mContext, WebViewActivityDm::class.java)
            mContext.startActivity(intent)
            dialog.dismiss()
        }
        dialog.window.setGravity(Gravity.CENTER)
        dialog.window.setWindowAnimations(R.style.MyDialog)
        goToWeb.setOnClickListener {
            dialog.show()
        }


    }

    class MainAdapter(val items: List<String>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(TextView(parent.context))

        }

        override fun getItemCount(): Int = items.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.textView.text = items[position]
        }

        class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
    }

}
