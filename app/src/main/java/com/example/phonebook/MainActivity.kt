package com.example.phonebook

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private val contacts = mutableListOf<Contact>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contacts.add(Contact(1,"avatar1", "Aario", "091092019","Aario@gmail.com", "Ha Nam"))
        contacts.add(Contact(2,"avatar2", "Bario", "091092019","Bario@gmail.com", "Ninh Binh"))
        contacts.add(Contact(3,"avatar3", "Cario", "091092019","Cario@gmail.com", "Thai Nguyen"))
        contacts.add(Contact(4,"avatar4", "Dario", "091092019","Dario@gmail.com", "Hai Phong"))
        contacts.add(Contact(5,"avatar5", "Eario", "091092019","Eario@gmail.com", "Ha Noi"))
        contacts.add(Contact(6,"avatar6", "Fario", "091092019","Fario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(7,"avatar7", "Gario", "091092019","Gario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(8,"avatar8", "Hario", "091092019","Hario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(9,"avatar9", "Iario", "091092019","Iario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(10,"avatar10","Jario", "091092019","Jario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(11,"avatar26", "Kario", "091092019","Kario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(12,"avatar11", "Lario", "091092019","Lario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(13,"avatar12", "Mario", "091092019","Mario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(14,"avatar13", "Nario", "091092019","Nario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(15,"avatar14", "Oario", "091092019","Oario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(16,"avatar15", "Pario", "091092019","Pario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(17,"avatar16", "Qario", "091092019","Qario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(18,"avatar17", "Rario", "091092019","Rario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(19,"avatar18", "Sario", "091092019","Sario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(20,"avatar19", "Tario", "091092019","Tario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(21,"avatar20","Uario", "091092019","Uario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(22,"avatar21","Vario", "091092019","Vario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(23,"avatar22","Wario", "091092019","Wario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(24,"avatar23","Xario", "091092019","Xario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(25,"avatar24","Yario", "091092019","Yario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(26,"avatar25","Zario", "091092019","Zario@gmail.com", "Nam Dinh"))



        val contactAdapter = ContactAdapter(this, contacts)
        val recyclerView: RecyclerView = findViewById(R.id.contact_rv)
        recyclerView.adapter = contactAdapter
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        registerForContextMenu(recyclerView)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val position = info.position
        val contact = contacts[position]
        return when (item.itemId) {
            R.id.action_call -> {
                callContact(contact.phoneNumber)
                true
            }

            R.id.action_send_message -> {
                sendSms(contact.phoneNumber)
                true
            }

            R.id.action_send_email -> {
                sendEmail(contact.email)
                true
            }

            else -> super.onContextItemSelected(item)
        }
    }

    private fun callContact(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
        startActivity(intent)
    }

    private fun sendSms(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$phoneNumber"))
        startActivity(intent)
    }

    private fun sendEmail(email: String) {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:$email")
        startActivity(intent)
    }
}