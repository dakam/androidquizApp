package com.dakam.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.get
import java.time.LocalDate
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var boeing = findViewById<CheckBox>(R.id.boeing);
        var ford = findViewById<CheckBox>(R.id.ford);
        var airbus = findViewById<CheckBox>(R.id.airbus);

        val rg = findViewById<RadioGroup>(R.id.rg);
        val sub = findViewById<Button>(R.id.btnSub);
        val cancel = findViewById<Button>(R.id.cancel);

        var totalMark=0;


      cancel.setOnClickListener {
          rg.clearCheck();
          boeing.isChecked=false
          ford.isChecked=false
          airbus.isChecked=false
          totalMark=0;

      }


        sub.setOnClickListener {



            val selectedOption: Int = rg!!.checkedRadioButtonId
           val radioButton = findViewById<RadioButton>(selectedOption)
            var year: String = radioButton.text.toString();
            if(year.equals("1969")){
                totalMark= totalMark+50;
            }

            if(boeing!!.isChecked){
                totalMark= totalMark+25;
            }
            if(airbus.isChecked){
                totalMark= totalMark+25;
            }
            if(ford.isChecked){
                totalMark= totalMark+0;
            }

            var builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("Quiz Results as at "+LocalDate.now().toString())
            builder.setMessage("Congulatulations you scored "+totalMark+" %")


            builder.setPositiveButton("Yes"){
             dialogInterface, which ->
                dialogInterface.dismiss()
                totalMark=0;
                finish()
            }

            builder.setNegativeButton("Cancel"){
                    dialogInterface, which ->
                totalMark=0;
                dialogInterface.dismiss()
            }

            val dialog:AlertDialog = builder.create();
            dialog.show();
        }




    }
}