package com.shpprr.calculator

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var str1 = ""
    private var str2 = ""
    private var _0: Button? = null
    private var _1: Button? = null
    private var _2: Button? = null
    var _3: Button? = null
    var _4: Button? = null
    var _5: Button? = null
    var _6: Button? = null
    var _7: Button? = null
    var _8: Button? = null
    var _9: Button? = null
    var _b: Button? = null
    var _e: Button? = null
    var rb1: RadioButton? = null
    var rb2: RadioButton? = null
    var result: TextView? = null
    private var rg: RadioGroup? = null
    var calcs: RadioGroup? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        rg = findViewById(R.id.rg)
        _0 = findViewById(R.id._0)
        _1 = findViewById(R.id._1)
        _2 = findViewById(R.id._2)
        _3 = findViewById(R.id._3)
        _4 = findViewById(R.id._4)
        _5 = findViewById(R.id._5)
        _6 = findViewById(R.id._6)
        _7 = findViewById(R.id._7)
        _8 = findViewById(R.id._8)
        _9 = findViewById(R.id._9)
        _b = findViewById(R.id._C)
        _e = findViewById(R.id._e)
        rb1 = findViewById(R.id.n1)
        rb2 = findViewById(R.id.n2)
        calcs = findViewById(R.id.calc_bar)
        result = findViewById(R.id.result)
        _0?.setOnClickListener {
            setValue(0)
        }
        _1?.setOnClickListener {
            setValue(1)
        }
        _2?.setOnClickListener {
            setValue(2)
        }
        _3?.setOnClickListener {
            setValue(3)
        }
        _4?.setOnClickListener {
            setValue(4)
        }
        _5?.setOnClickListener {
            setValue(5)
        }
        _6?.setOnClickListener {
            setValue(6)
        }
        _7?.setOnClickListener {
            setValue(7)
        }
        _8?.setOnClickListener {
            setValue(8)
        }
        _9?.setOnClickListener {
            setValue(9)
        }
        _b?.setOnClickListener {
            val id: Int = rg!!.checkedRadioButtonId
            if (id == R.id.n1) {
                if (str1.isNotEmpty()) {
                    str1 = str1.substring(0, str1.length - 1)
                    rb1?.text = str1
                    if (str1.isEmpty()) {
                        rb1?.text = "Enter number 1"
                    }
                } else {
                    rb1?.text = "Enter number 1"
                }
            } else if (id == R.id.n2) {
                if (str2.isNotEmpty()) {
                    str2 = str2.substring(0, str2.length - 1)
                    rb2?.text = str2
                    if (str2.isEmpty()) {
                        rb2?.text = "Enter number 2"
                    }
                } else {
                    rb2?.text = "Enter number 2"
                }
            } else {
                Toast.makeText(this, "Select a box", Toast.LENGTH_SHORT).show()
            }
        }

        _e?.setOnClickListener {
//            setValue(0)
            if (str1.isNotEmpty()) {
                if (str2.isNotEmpty()) {
                    val num1: Double = str1.toDouble()
                    val num2: Double = str2.toDouble()
                    val id: Int = calcs!!.checkedRadioButtonId
                    var sum = 0.0
                    var flag = 0
                    if (id == R.id.add) {
                        flag = 1
                        sum = num1 + num2
                    }
                    if (id == R.id.minus) {
                        flag = 1
                        sum = num1 - num2
                    }
                    if (id == R.id.pro) {
                        flag = 1
                        sum = num1 * num2
                    }
                    if (id == R.id.div) {
                        flag = 1
                        sum = num1 / num2
                    }
                    if (flag == 1)
                        result?.text = "" + sum
                    else
                        Toast.makeText(this, "Select an operation", Toast.LENGTH_LONG).show()

                } else {
                    Toast.makeText(this, "Box 2 is empty", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Box 1 is empty", Toast.LENGTH_LONG).show()
            }
        }


    }

    fun setValue(num: Int) {
        val id: Int = rg!!.checkedRadioButtonId
        if (id == R.id.n1) {
            str1 += num
            rb1?.text = str1
        } else if (id == R.id.n2) {
            str2 += num
            rb2?.text = str2
        } else {
            Toast.makeText(this, "Select a box", Toast.LENGTH_SHORT).show()
        }
    }
}