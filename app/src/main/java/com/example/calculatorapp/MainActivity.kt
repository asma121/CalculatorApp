package com.example.calculatorapp

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var bu1:Button
    lateinit var bu2:Button
    lateinit var bu3:Button
    lateinit var bu4:Button
    lateinit var bu5:Button
    lateinit var bu6:Button
    lateinit var bu7:Button
    lateinit var bu8:Button
    lateinit var bu9:Button
    lateinit var bu0:Button
    lateinit var bupoint:Button
    lateinit var bucl:Button
    lateinit var budel:Button
    lateinit var buadd:Button
    lateinit var busub:Button
    lateinit var bumultiply:Button
    lateinit var budiv:Button
    lateinit var buequal:Button
    lateinit var buminus:Button
    var num1=""
    var num2=""
    var operation=' '
    var result=0f
    var tvshow=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView=findViewById(R.id.textView)


        bu1=findViewById(R.id.bu1)
        bu2=findViewById(R.id.bu2)
        bu3=findViewById(R.id.bu3)
        bu4=findViewById(R.id.bu4)
        bu5=findViewById(R.id.bu5)
        bu6=findViewById(R.id.bu6)
        bu7=findViewById(R.id.bu7)
        bu8=findViewById(R.id.bu8)
        bu9=findViewById(R.id.bu9)
        bu0=findViewById(R.id.bu0)
        bupoint=findViewById(R.id.bupoint)
        bucl=findViewById(R.id.bucl)
        budel=findViewById(R.id.budel)
        buadd=findViewById(R.id.buadd)
        busub=findViewById(R.id.busub)
        bumultiply=findViewById(R.id.bumultiply)
        budiv=findViewById(R.id.budiv)
        buequal=findViewById(R.id.buequal)
        buminus=findViewById(R.id.buminus)

        bu1.setOnClickListener { setnum("1") }
        bu2.setOnClickListener { setnum("2") }
        bu3.setOnClickListener { setnum("3") }
        bu4.setOnClickListener { setnum("4") }
        bu5.setOnClickListener { setnum("5") }
        bu6.setOnClickListener { setnum("6") }
        bu7.setOnClickListener { setnum("7") }
        bu8.setOnClickListener { setnum("8") }
        bu9.setOnClickListener { setnum("9") }
        bu0.setOnClickListener { setnum("0") }

        buadd.setOnClickListener { setoperation('+') }
        busub.setOnClickListener { setoperation('-') }
        bumultiply.setOnClickListener { setoperation('*') }
        budiv.setOnClickListener { setoperation('/') }



        buequal.setOnClickListener { calculation(operation) }

        bucl.setOnClickListener { clearall() }

        buminus.setOnClickListener { minus() }

        bupoint.setOnClickListener { decimal() }

    }

    fun setnum(n:String){
        if(operation==' '){
            num1+=n
            tvshow+=n
        }else{
            num2+=n
            tvshow+=n
        }
        textView.text=tvshow
    }
    fun setoperation(op: Char){
        if(operation==' '){
            operation=op
            tvshow+=op
        }
        textView.text=tvshow
    }

    fun calculation(op:Char){
       if(result!=0f){num1=result.toString()}
        when(op){
            '+'-> {result=num1.toFloat()+num2.toFloat(); tvshow=result.toString()}
            '-'-> {result=num1.toFloat()-num2.toFloat(); tvshow=result.toString()}
            '*'-> {result=num1.toFloat()*num2.toFloat(); tvshow=result.toString()}
            '/'-> { if (num2.toFloat()!=0f){
                  result=num1.toFloat()/num2.toFloat()
                  tvshow=result.toString()}
                else{
                    clearall()
                }
            }
        }
        textView.text=tvshow
    }

    fun clearall(){
        num1=""
        num2=""
        operation=' '
        result=0f
        tvshow=""
        textView.text=tvshow
    }
  fun minus(){
     if (operation==' '){
       if (num1.startsWith("-")){
           num1=num1.substring(1,num1.length)
       }else{
           num1="-$num1"
       }
         tvshow+=num1
    }else{
         if (num2.startsWith("-")){
             num2=num2.substring(1,num2.length)
         }else{
             num2="-$num2"
         }
         tvshow+=num2
    }
      textView.text=tvshow
  }

    fun decimal(){
        if(operation==' '&&!num1.contains(".")){setnum(".")}
        if(operation!=' '&&!num2.contains(".")){setnum(".")}
    }

}