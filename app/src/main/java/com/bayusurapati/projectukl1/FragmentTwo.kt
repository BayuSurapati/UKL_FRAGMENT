package com.bayusurapati.projectukl1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_two.*


class FragmentTwo : Fragment() {

    lateinit var email: String
    lateinit var nama: String
    lateinit var alamat: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        email = arguments?.getString("keyEmail").toString()
        nama = arguments?.getString("keyNama").toString()
        alamat = arguments?.getString("keyAlamat").toString()

        val tEmail = hasilTextEmail
        val tNama = hasilTextNama
        val tAlamat = hasilTextAlamat

        tEmail.text = "$email"
        tNama.text = "$nama"
        tAlamat.text = "$alamat"
    }
}