package io.github.bayu1993.dicodingankolayout

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
            verticalLayout {
                imageView(R.drawable.google).lparams(width = matchParent) {
                    padding = dip(10)
                    margin = dip(10)
                }
                val name = editText() {
                    hint = "Your name"
                }
                button("submit") {
                    onClick { toast("${name.text}") }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }

}
