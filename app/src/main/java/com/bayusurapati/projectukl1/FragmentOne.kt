package com.bayusurapati.projectukl1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btnRegister_activity
import kotlinx.android.synthetic.main.activity_main.editTextEmail
import kotlinx.android.synthetic.main.fragment_one.*


class FragmentOne : Fragment() {
    private lateinit var sd : SendData
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnRegist = btnRegister_activity

        btnRegist.setOnClickListener{
            val email = editTextEmail.text.toString()
            val nama = editTextNama.text.toString()
            val alamat = editTextAlamat.text.toString()

            if(email.equals("") || nama.equals("") || alamat.equals("")){
                Toast.makeText(context,"Mohon isi data diri anda", Toast.LENGTH_SHORT).show()
            }else{
                val bundle  = Bundle()
                bundle.putString("keyEmail",email)
                bundle.putString("keyNama",nama)
                bundle.putString("keyAlamat",alamat)

                val fragment = FragmentTwo()
                fragment.arguments = bundle

                Toast.makeText(context,"Submit data diri berhasil",Toast.LENGTH_SHORT).show()
                fragmentManager?.beginTransaction()?.replace(R.id.contol,fragment)?.commit()
            }
        }
    }
}
