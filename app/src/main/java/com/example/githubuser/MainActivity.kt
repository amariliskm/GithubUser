package com.example.githubuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private var title = "GitHub User's"

    private lateinit var rvUsers:RecyclerView
    private var list:ArrayList<User> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rvUsers = findViewById(R.id.rv_user)
        rvUsers.setHasFixedSize(true)


        list.addAll(UsersData.listData)
        showRecyclerList()

    }

    private fun showRecyclerList() {
        rvUsers.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rvUsers.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                showSelectedUSer(data)
                val moveDetailUser = Intent(this@MainActivity, DetailUser::class.java)
                moveDetailUser.putExtra(DetailUser.EXTRA_USER,data)
                startActivity(moveDetailUser)
            }
        })
    }

    private fun showSelectedUSer(data: User) {
        Toast.makeText(this, data.name, Toast.LENGTH_SHORT).show()
    }


    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }


}