package easv.oe.dicecup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val MAX_HISTORY = 5

    val diceId = intArrayOf(0, R.drawable.dice1,
                               R.drawable.dice2,
                               R.drawable.dice3,
                               R.drawable.dice4,
                               R.drawable.dice5,
                               R.drawable.dice6)

    val ran = Random()

    val mHistory = mutableListOf<Pair<Int, Int>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRoll.setOnClickListener { v -> onClickRoll() }

        imgDice1.setOnClickListener { v -> onClickRoll() }
        imgDice2.setOnClickListener { v -> onClickRoll() }
    }

    fun onClickRoll(){
        val e1 = ran.nextInt(6) + 1
        val e2 = ran.nextInt(6) + 1
        mHistory.add(Pair(e1,e2))
        if (mHistory.size > MAX_HISTORY) mHistory.removeAt(0)

        imgDice1.setImageResource( diceId[e1] )
        imgDice2.setImageResource( diceId[e2] )
        var s:String = ""
        mHistory.forEach { p ->  val e1 = p.first
                                 val e2 = p.second
                                 s += "$e1 - $e2 \n"}
        tvHistory.text = s
    }

}
