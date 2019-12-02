package com.timpolicar.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import com.timpolicar.swoosh.Model.Player
import com.timpolicar.swoosh.R
import com.timpolicar.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("", "")

    override fun onSaveInstanceState(outState: Bundle) { // ko obrnemo mobitel se dejansko unici activity in na novo nalozi zato izgubimo podatke, v nasem primeru player. s tem jih shranimo
        // PREVERI CE JE TO SE, DELAL JE TUDI BREZ TEGA
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER, player) // shranimo
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) { // tuki se prepisejo podatki, ki jih hocemo
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null){
            player =
                savedInstanceState.getParcelable(EXTRA_PLAYER)!! // ce ni null se prepiši sam vase, ce je null pusti ker je tko al tko null
        }
    }

    fun onMensClicked(view: View){
        womensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        player.league = "mens"
    }

    fun onWomensClicked(view: View){
        mensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        player.league = "womens"
    }

    fun onCoedClicked(view: View){
        mensLeagueBtn.isChecked = false
        womensLeagueBtn.isChecked = false

        player.league = "co-ed"
    }

    fun leagueNextClicked(view: View){
        if(player.league != ""){
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player) // tu lahko naprej v nasledni activity nesemo extra stvari, v tem primeru nesemo const String - glej SkillActivity
            startActivity(skillActivity)
        }else{
            Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
        }
    }


}
