package com.chen.gittestdemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.test.myapplication.WebViewActivityDm
import com.test.myapplication.bean.TextModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }
    //list本地加载数组数据
    fun initView() {
        val items = listOf(
                "给初学者的RxJava2.0教程（七）: Flowable",
                "Android之View的诞生之谜",
                "Android之自定义View的死亡三部曲之Measure",
                "Using ThreadPoolExecutor in Android ",
                "Kotlin 泛型定义与 Java 类似，但有着更多特性支持。",
                "Android异步的姿势，你真的用对了吗？",
                "Android 高质量录音库。",
                "Android 边缘侧滑效果，支持多种场景下的侧滑退出。",
                "给初学者的RxJava2.0教程（七）: Flowable",
                "Android之View的诞生之谜",
                "Android之自定义View的死亡三部曲之Measure",
                "Using ThreadPoolExecutor in Android ",
                "Kotlin 泛型定义与 Java 类似，但有着更多特性支持。",
                "Android异步的姿势，你真的用对了吗？",
                "Android 高质量录音库。",
                "Android 边缘侧滑效果，支持多种场景下的侧滑退出。",
                "给初学者的RxJava2.0教程（七）: Flowable",
                "Android之View的诞生之谜",
                "Android之自定义View的死亡三部曲之Measure",
                "Using ThreadPoolExecutor in Android ",
                "Kotlin 泛型定义与 Java 类似，但有着更多特性支持。",
                "Android异步的姿势，你真的用对了吗？",
                "Android 高质量录音库。",
                "Android 边缘侧滑效果，支持多种场景下的侧滑退出。",
                "给初学者的RxJava2.0教程（七）: Flowable",
                "Android之View的诞生之谜",
                "Android之自定义View的死亡三部曲之Measure",
                "Using ThreadPoolExecutor in Android ",
                "Kotlin 泛型定义与 Java 类似，但有着更多特性支持。",
                "Android异步的姿势，你真的用对了吗？",
                "Android 高质量录音库。",
                "Android 边缘侧滑效果，支持多种场景下的侧滑退出。",
                "给初学者的RxJava2.0教程（七）: Flowable",
                "Android之View的诞生之谜",
                "Android之自定义View的死亡三部曲之Measure",
                "Using ThreadPoolExecutor in Android ",
                "Kotlin 泛型定义与 Java 类似，但有着更多特性支持。",
                "Android异步的姿势，你真的用对了吗？",
                "Android 高质量录音库。",
                "Android 边缘侧滑效果，支持多种场景下的侧滑退出。", "给初学者的RxJava2.0教程（七）: Flowable",
                "Android之View的诞生之谜",
                "Android之自定义View的死亡三部曲之Measure",
                "Using ThreadPoolExecutor in Android ",
                "Kotlin 泛型定义与 Java 类似，但有着更多特性支持。",
                "Android异步的姿势，你真的用对了吗？",
                "Android 高质量录音库。",
                "Android 边缘侧滑效果，支持多种场景下的侧滑退出。", "给初学者的RxJava2.0教程（七）: Flowable",
                "Android之View的诞生之谜",
                "Android之自定义View的死亡三部曲之Measure",
                "Using ThreadPoolExecutor in Android ",
                "Kotlin 泛型定义与 Java 类似，但有着更多特性支持。",
                "Android异步的姿势，你真的用对了吗？",
                "Android 高质量录音库。",
                "Android 边缘侧滑效果，支持多种场景下的侧滑退出。", "给初学者的RxJava2.0教程（七）: Flowable",
                "Android之View的诞生之谜",
                "Android之自定义View的死亡三部曲之Measure",
                "Using ThreadPoolExecutor in Android ",
                "Kotlin 泛型定义与 Java 类似，但有着更多特性支持。",
                "Android异步的姿势，你真的用对了吗？",
                "Android 高质量录音库。",
                "Android 边缘侧滑效果，支持多种场景下的侧滑退出。"


        )
        text.visibility = View.GONE
        recycle.layoutManager = LinearLayoutManager(this)
//        传统bean方式加载数据
        val datas = mutableListOf<TextModel>()
//        recycle.adapter = GankNewsAdapter(datas) {
//            val intent = Intent()
//            intent.setClass(this, WebViewActivityDm::class.java)
//            startActivity(intent)
//        }
        recycle.adapter = MainAdapter(items)
        text.text = ("测试用语")
        text.textSize = 20f
        text.setOnClickListener {
            text.text = "测试"
            if (!text.equals("测试1")) {
            } else {
                text.text = "测试2 "
            }

        }
        go_to_web.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, WebViewActivityDm::class.java)
            intent.putExtra("pwd", text.text.toString())
            startActivity(intent)
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
//    class GankNewsAdapter(val datas: List<TextModel>, val itemClickListener: (TextModel) -> Unit) : RecyclerView.Adapter<GankNewsAdapter.ViewHolder>() {
//
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_list_layout, parent, false)
//            return ViewHolder(view, itemClickListener)
//        }
//
//        override fun getItemCount(): Int = 10
//
//        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        }
//
//        class ViewHolder(val view: View, val itemClickListener: (TextModel) -> Unit) : RecyclerView.ViewHolder(view) {
//            fun bind(datas: TextModel) {
//                view.title.text = datas.id
//                view.desc.text = datas.name
//                view.setOnClickListener {
//                    itemClickListener(datas)
//                }
//            }
//        }
//    }
}