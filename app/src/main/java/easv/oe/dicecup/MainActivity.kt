package easv.oe.dicecup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

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

        findViewById<Button>(R.id.btnRoll).setOnClickListener { v -> onClickRoll() }

        findViewById<ImageView>(R.id.imgDice2).setOnClickListener { v -> onClickRoll() }
        findViewById<ImageView>(R.id.imgDice1).setOnClickListener { v -> onClickRoll() }
    }

    fun onClickRoll(){
        val e1 = ran.nextInt(6) + 1
        val e2 = ran.nextInt(6) + 1
        mHistory.add(Pair(e1,e2))
        if (mHistory.size > 5) mHistory.removeAt(0)
        val d1 = findViewById<ImageView>(R.id.imgDice1)
        val d2 = findViewById<ImageView>(R.id.imgDice2)
        d1.setImageResource( diceId[e1] )
        d2.setImageResource( diceId[e2] )
        val tvHistory = findViewById<TextView>(R.id.tvHistory)
        var s:String = ""
        mHistory.forEach { p ->  val e1 = p.first
                                 val e2 = p.second
                                 s += "$e1 - $e2 \n"}
        tvHistory.text = s
    }

}
