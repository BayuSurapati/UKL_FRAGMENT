package com.bayusurapati.projectukl1

import android.app.DatePickerDialog
import android.icu.text.PluralRules.forLocale
import android.icu.util.ULocale
import android.icu.util.ULocale.forLocale
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import com.bayusurapati.projectukl1.Data.AppDatabase
import com.bayusurapati.projectukl1.Data.Dao.UserDao
import com.bayusurapati.projectukl1.Data.Entity.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btnRegister_activity
import kotlinx.android.synthetic.main.activity_main.editTextEmail
import kotlinx.android.synthetic.main.fragment_one.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.reflect.Array.getInt
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.Month
import java.time.Year
import java.util.*


class FragmentOne : Fragment() {
    private var db: AppDatabase? = null
    private var myFriendDao: UserDao? = null



    val c = Calendar.getInstance()
    private var namaInput: String = ""
    private var emailInput: String = ""
    private var telpInput: String = ""
    private var alamatInput: String = ""
    private var genderInput: String = ""
    private var date: String = ""

    private var editName: EditText? = null
    private var editEmail: EditText? = null
    private var editTelp: EditText? = null
    private var editAlamat: EditText? = null
    private var btnSimpan: Button? = null
    private var spinnerGender: Spinner? = null
    lateinit var tanggal: Button

    companion object {
        fun newInstance(): FragmentOne {
            return FragmentOne()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLocalDB()
        initView()

        tanggal = view.findViewById(R.id.pickDatebtn)
        tanggal.setOnClickListener {
            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                requireActivity(),
                { view, year, monthOfYear, dayOfMonth ->
                    tanggal.text =
                        (dayOfMonth.toString() + "\t-\t" + (monthOfYear + 1) + "\t-\t" + year)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }
    }
    private fun initLocalDB() {
        db = AppDatabase.getAppDatabase(requireActivity())
        myFriendDao = db?.myFriendDao()
    }

    private fun initView() {
        editName = activity?.findViewById(R.id.editTextNama)
        editEmail = activity?.findViewById(R.id.editTextEmail)
        editAlamat = activity?.findViewById(R.id.editTextAlamat)

        //tanggal = activity?.findViewById(R.id.pickDatebtn)!!
        btnSimpan = activity?.findViewById(R.id.btnRegister_activity)

        btnSimpan?.setOnClickListener {
            //(activity as MainActivity).tampilMyFriendsFragment()
            validasiInput()
            tampilToast("Berhasil Menambahkan Data")
        }
    }

    private fun validasiInput() {
        namaInput = editName?.text.toString()
        genderInput = spinnerGender?.selectedItem.toString()
        emailInput = editEmail?.text.toString()
        telpInput = editTelp?.text.toString()
        alamatInput = editAlamat?.text.toString()
        date = tanggal?.text.toString()

        when {
            namaInput.isEmpty() -> editName?.error = "Nama anda tidak boleh kosong"
            genderInput.equals("Pilih Gender") -> tampilToast("Pilih Gender Anda")
            emailInput.isEmpty() -> editEmail?.error = "Email tidak boleh kosong"
            telpInput.isEmpty() -> editTelp?.error = "Isi Nomor Telepon anda"
            alamatInput.isEmpty() -> editAlamat?.error = "Isikian alamat lengkap anda"
            date.isEmpty() -> tanggal?.error = "Pilih Tanggal"
            else -> {
                val teman = User(
                    0, namaInput, genderInput, emailInput, telpInput, alamatInput, date
                )
                tambahDataTeman(teman)
            }
        }
    }

    private fun tampilToast(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }

    private fun tambahDataTeman(teman: User): Job {
        return GlobalScope.launch {
            myFriendDao?.tambahTeman(teman)
            (activity as RegistActivity).tampilMyFriendsFragment()
        }
    }
}

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnRegist = btnRegister_activity

        btnRegist.setOnClickListener {
            val id = getInt("id", 0)
            var user = database.userDao().get(id)
            nama.setText(user.fullName)

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
    }*/

