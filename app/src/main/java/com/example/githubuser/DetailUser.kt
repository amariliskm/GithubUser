package com.example.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail_user.*

class DetailUser : AppCompatActivity() {


    companion object{
        const val EXTRA_USER = "extra_user"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val user = intent.getParcelableExtra(EXTRA_USER) as User
        setActionBarTitle(user.username)

        val loc = R.drawable.pin
        val company = R.drawable.company
        val followers = R.drawable.user
        val star = R.drawable.star

        tv_detail_name.text = user.name
        tv_detail_username.text = user.username
        tv_detail_loc.text = user.location
        tv_detail_company.text = user.company
        tv_detail_followers.text = user.followers
        tv_detail_following.text = user.following
        tv_detail_repository.text = user.repository

        Glide.with(this)
            .load(user.avatar)
            .apply(RequestOptions())
            .into(img_detail_avatar)

        Glide.with(this)
            .load(loc)
            .apply(RequestOptions())
            .into(img_loc)

        Glide.with(this)
            .load(company)
            .apply(RequestOptions())
            .into(img_company)

        Glide.with(this)
            .load(followers)
            .apply(RequestOptions())
            .into(img_followers)

        Glide.with(this)
            .load(star)
            .apply(RequestOptions())
            .into(img_star)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    private fun setActionBarTitle(username: String?) {
        supportActionBar?.title = username
    }
}