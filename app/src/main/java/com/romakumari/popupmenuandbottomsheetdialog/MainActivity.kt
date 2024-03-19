package com.romakumari.popupmenuandbottomsheetdialog

import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.widget.PopupMenu
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.romakumari.popupmenuandbottomsheetdialog.databinding.ActivityMainBinding
import com.romakumari.popupmenuandbottomsheetdialog.databinding.BottomsheetBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.popupmenu.setOnClickListener {
            binding.BottomSheet.let {
                PopupMenu(this,it).apply {
                    menuInflater.inflate(R.menu.popupmenu,menu)
                    gravity=Gravity.END
                    setOnMenuItemClickListener {
                        when(it.itemId){
                            R.id.first->Toast.makeText(this@MainActivity,"first",Toast.LENGTH_SHORT).show()
                            R.id.second->Toast.makeText(this@MainActivity,"second",Toast.LENGTH_SHORT).show()
                            R.id.third->Toast.makeText(this@MainActivity,"third",Toast.LENGTH_SHORT).show()
                        }

                          return@setOnMenuItemClickListener true

                    }
                    show()

                }
            }
        }
                     binding.BottomSheet.setOnClickListener {
                         var dialogbinding=BottomsheetBinding.inflate(layoutInflater)
                         BottomSheetDialog(this).apply {
                             setContentView(dialogbinding.root)


                             dialogbinding.btn1.setOnClickListener {
                                  dismiss()
                                 val navController = findNavController(R.id.nav_graph)
                                 navController.navigate(R.id.fragment_first)
                             }

                             show()
                         }

                         }



        binding.ettext.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val newtext = s.toString()
                val intValue = newtext.toIntOrNull() ?: 0
                val result = intValue + 1
                binding.tvtext.text =result.toString()
            }

        })
    }


    }

