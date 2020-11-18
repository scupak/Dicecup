package easv.oe.dicecup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    // mapping from 1..6 to drawables, the first index is unused
    val diceId = intArrayOf(0, R.drawable.dice1,
                               R.drawable.dice2,
                               R.drawable.dice3,
                               R.drawable.dice4,
                               R.drawable.dice5,
                               R.drawable.dice6)

    val mRandomGenerator = Random()

    val mHistory = mutableListOf<Pair<Int, Int>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnRoll).setOnClickListener { v -> onClickRoll() }

        findViewById<ImageView>(R.id.imgDice2).setOnClickListener { v -> onClickRoll() }
        findViewById<ImageView>(R.id.imgDice1).setOnClickListener { v -> onClickRoll() }
        findViewById<Button>(R.id.btnClear).setOnClickListener { v -> onClickClear() }
    }

    fun onClickRoll(){
        val e1 = mRandomGenerator.nextInt(6) + 1
        val e2 = mRandomGenerator.nextInt(6) + 1

        // update dices
        val d1 = findViewById<ImageView>(R.id.imgDice1)
        val d2 = findViewById<ImageView>(R.id.imgDice2)
        d1.setImageResource( diceId[e1] )
        d2.setImageResource( diceId[e2] )

        //update history
        mHistory.add(Pair(e1,e2))
        if (mHistory.size > 5) mHistory.removeAt(0)
        updateHistory()
    }

    fun onClickClear() {
        mHistory.clear()
        updateHistory()
    }

    // ensures that the history text aligns the history object
    fun updateHistory() {
        val tvHistory = findViewById<TextView>(R.id.tvHistory)
        var s = ""
        mHistory.forEach { p ->  val e1 = p.first; val e2 = p.second; s += "$e1 - $e2 \n" }
        tvHistory.text = s
    }

}
