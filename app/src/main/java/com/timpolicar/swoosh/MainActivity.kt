package com.timpolicar.swoosh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
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
