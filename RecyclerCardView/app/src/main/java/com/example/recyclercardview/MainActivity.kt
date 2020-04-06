package com.example.recyclercardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclercardview.Adapters.StudentsAdapter
import com.example.recyclercardview.Data.StudentsDb
import com.example.recyclercardview.Data.StudentsEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val studentsDb = StudentsDb(this)
    private lateinit var studentsList : ArrayList<StudentsEntity>
    private lateinit var studentsAdapter: StudentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        studentsDb.studentAdd(StudentsEntity(-1, "Omar", "Olivera", 1, "1997/04/02"))
        studentsDb.studentAdd(StudentsEntity(-1, "Dantesa", "Alighera", 0, "1995/04/02"))


        studentsList = studentsDb.stundetsGetAll2()
        studentsAdapter = StudentsAdapter(studentsList, this@MainActivity)

        val linearLayoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)

        rvwStudents.layoutManager = linearLayoutManager
        rvwStudents.setHasFixedSize(true)
        rvwStudents.adapter = studentsAdapter

    }
}