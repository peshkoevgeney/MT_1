package com.example.android.crosszero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    var boardarray : ArrayList<Int> = ArrayList()
    var x: String = "x"
    var o: String = "o"
    var buttonsXO = arrayOfNulls<Button>(9)
    lateinit var switchbutton: Button
    lateinit var PlayerX: TextView
    lateinit var PlayerO: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchbutton = findViewById(R.id.switchbutton)
        var resetButton: Button = findViewById(R.id.reset)
        PlayerX = findViewById(R.id.textViewX)
        PlayerO = findViewById(R.id.textViewO)

        for(i in 0..8){
            var nameButton: String  = "a" + (i+1)
            buttonsXO[i] = findViewById(resources!!.getIdentifier(nameButton, "id", packageName!!))
            buttonsXO[i]!!.setOnClickListener(this)

        }
        resetButton()
        resetButton.setOnClickListener{
            resetButton()
        }
        switchbutton.setOnClickListener{
            flag = 0
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.run {
            putInt("Counter", counter)
            putIntegerArrayList("BoardArray", boardarray)
            putInt("Flag", flag)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        flag = savedInstanceState!!.getInt("Flag")
        counter = savedInstanceState!!.getInt("Counter")
        boardarray = savedInstanceState.getIntegerArrayList("BoardArray")
    }
    var flag = 1;
    var counter: Int = 0
    override fun onClick(view: View){
        counter++
        if (counter >= 1) {
            switchbutton.visibility = View.INVISIBLE
        }
        when (view.getId()) {
            R.id.a1 -> {
                if (flag == 1){
                    boardarray.set(0, 1)
                    a1.setText(x)
                    a1.freezesText
                    flag = 0
                }
                else{
                    boardarray.set(0, 0)
                    a1.setText(o)
                    a1.freezesText
                    flag = 1
                }
            }
            R.id.a2 -> {
                if (flag == 1){
                    boardarray.set(1, 1)
                    a2.setText(x)
                    a2.freezesText
                    flag = 0
                }
                else{
                    boardarray.set(1, 0)
                    a2.setText(o)
                    a2.freezesText
                    flag = 1
                }
            }
            R.id.a3 -> {
                if (flag == 1){
                    boardarray.set(2, 1)
                    a3.setText(x)
                    a3.freezesText
                    flag = 0
                }
                else{
                    boardarray.set(2, 0)
                    a3.setText(o)
                    a3.freezesText
                    flag = 1
                }
            }
            R.id.a4 -> {
                if (flag == 1){
                    boardarray.set(3, 1)
                    a4.setText(x)
                    a4.freezesText
                    flag = 0
                }
                else{
                    boardarray.set(3, 0)
                    a4.setText(o)
                    a4.freezesText
                    flag = 1
                }
            }
            R.id.a5 -> {
                if (flag == 1){
                    boardarray.set(4, 1)
                    a5.setText(x)
                    a5.freezesText
                    flag = 0
                }
                else{
                    boardarray.set(4, 0)
                    a5.setText(o)
                    a5.freezesText
                    flag = 1
                }
            }
            R.id.a6 -> {
                if (flag == 1){
                    boardarray.set(5, 1)
                    a6.setText(x)
                    a6.freezesText
                    flag = 0
                }
                else{
                    boardarray.set(5, 0)
                    a6.setText(o)
                    a6.freezesText
                    flag = 1
                }
            }
            R.id.a7 -> {
                if (flag == 1){
                    boardarray.set(6, 1)
                    a7.setText(x)
                    a7.freezesText
                    flag = 0
                }
                else{
                    boardarray.set(6, 0)
                    a7.setText(o)
                    a7.freezesText
                    flag = 1
                }
            }
            R.id.a8 -> {
                if (flag == 1){
                    boardarray.set(7, 1)
                    a8.setText(x)
                    a8.freezesText
                    flag = 0
                }
                else{
                    boardarray.set(7, 0)
                    a8.setText(o)
                    a8.freezesText
                    flag = 1
                }
            }
            R.id.a9 -> {
                if (flag == 1){
                    boardarray.set(8, 1)
                    a9.setText(x)
                    a9.freezesText
                    flag = 0
                }
                else{
                    boardarray.set(8, 0)
                    a9.setText(o)
                    a9.freezesText
                    flag = 1
                }
            }
            else -> {}
        }
        if((winChecker(boardarray) == true) && (flag == 1)){
            PlayerX.setText(" Lose")
            PlayerO.setText("Win")
        }
        if((winChecker(boardarray) == true) && (flag == 0)){
            PlayerO.setText("Lose")
            PlayerX.setText("Win")

        }
        if((winChecker(boardarray) == false) && (counter == 9)){
            Toast.makeText(applicationContext, "Nichiya", Toast.LENGTH_SHORT).show()
        }

        if(counter >  9 ){
            counter = 1;
        }
    }

    public fun winChecker(array: ArrayList<Int>): Boolean {

            if((array[0] == array[1]) && (array[1] == array[2])){
                return true
            }
            if((array[3] == array[4]) && (array[4] == array[5])){
                return true
            }
            if((array[6] == array[7]) && (array[7] == array[8])){
                return true
            }

            if((array[0] == array[3]) && (array[3] == array[6])){
                return true
            }
            if((array[1] == array[4]) && (array[4] == array[7])){
                return true
            }
            if((array[2] == array[5]) && (array[5] == array[8])){
                return true
            }

            if((array[0] == array[4]) && (array[4] == array[8])){
                return true
            }
            if((array[2] == array[4]) && (array[4] == array[6])){
                return true
            }
        return false
    }

    fun resetButton(){

        counter = 0;
        switchbutton.visibility = View.VISIBLE

        for (i in buttonsXO!!.indices){
            buttonsXO[i]!!.setText("button" + i)
        }

        boardarray.clear()

            var someNumber: Int = 3;
        for(i in 0..8){
                boardarray.add(i, someNumber)
                someNumber++
        }

        winChecker(boardarray)

        PlayerX.setText("PlayerX")
        PlayerO.setText("PlayerO")
    }
}

