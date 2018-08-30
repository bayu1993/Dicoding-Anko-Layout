package io.github.bayu1993.dicodingankoui

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import io.github.bayu1993.dicodingankoui.R.color.colorAccent
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {
    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
            verticalLayout {
                padding = dip(16)
                val name = editText {
                    hint = "enter your name"
                }
                button("say hello") {
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        toast("Hello, ${name.text}!!")
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(10)
                }
                button("Show Alert"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick { it ->
                        alert("Hello ${name.text}!") {
                            yesButton { toast("yeah") }
                            noButton { toast("oh no") }
                        }.show()
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(10)
                }
                button("Show Selector"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick { it ->
                        val club = listOf<String>("Liverpool","Chelse", "Watford", "Spurs","Man City","Man United")
                        selector("Hello, ${name.text}, what your favorite club on PL?", club){
                            _, i -> toast("your favorite club on PL ${club[i]}")
                        }
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(10)
                }
                button("Show Snackbar"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick { it ->
                        snackbar(name, "Hello ${name.text}!!")
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(10)
                }
                button("Show Progressbar"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick { it ->
                        indeterminateProgressDialog("Hello ${name.text}, please wait..").show()
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(10)
                }
                button("Intent Activity"){
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick { it ->
                        startActivity<SecondActivity>("name" to "${name.text}")
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(10)
                }
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }
}
