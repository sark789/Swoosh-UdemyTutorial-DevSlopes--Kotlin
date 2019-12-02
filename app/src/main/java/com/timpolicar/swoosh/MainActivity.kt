package com.timpolicar.swoosh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) { //onCreate is called only once in its lifetime!!
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getStartedBtn.setOnClickListener {
            val leagueIntent = Intent(this, LeagueActivity::class.java) //to je eksplicitni intent.(eksplicitni: v appih, ker veš točno kateri class hočeš nardit
            // implicitni: neves tocno kater class nardit npr. pr browserjih (google, firefox), neves kater je na mobitelu kater ne
            // ta tu je eksplicitni)
            //context: v tem primeru podamo kontekst trenutnega activitija, podamo vse trenutne informacije
            startActivity(leagueIntent) //pozeni ta activity, prej smo samo kreirali
        }
    }
}

//onStart() - ko se activity naredi in smo na njem je onStart()
//onPause() - ko zgubimo fokus activitija/gremo na drug activity, ce se vrnemo na zaj pride nazaj v onStart()
//onStop() - ce gremo vn iz aplikacije, ko pridemo nazaj se klice onRestart(), onResume()
//onDestroy() - unici activity