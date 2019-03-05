package com.example.admin.surface_demo_kto

import android.graphics.Canvas
import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.lang.Exception
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var surfice_id: SurfaceViewJ
    lateinit var surfice_holder: SurfaceHolder
    lateinit var canvs: Canvas
    // 子线程标志位
    var isDrawing: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
//        surfice_id = findViewById(R.id.surfice_id)
    }


}
