package ev.axirgaorn.testgame

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Point
import android.os.*
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import ev.axirgaorn.testgame.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var score = 0
    private var screenWidth = 0
    private var screenHeight = 0
    private var downX1 = 0
    private var downX2 = 0
    private var downX3 = 0
    private var downX4 = 0
    private var downX5 = 0
    private var downX6 = 0
    private var downX7 = 0
    private var downX8 = 0
    private var downX9 = 0
    private var downX10 = 0
    private var arrowDownY = 0f
    private val handler: Handler = Handler()
    private var timer: Timer? = Timer()

    private val listOfPositionsByY = listOf(
        0,
        30,
        80,
        120,
        180,
        230,
        280,
        330,
        380,
        430,
        480,
        520,
        580,
        620,
        680,
        720,
        780,
        820,
        880,
        920,
        980,
        1020,
        1080
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClouds()
        startGame()
        initClickers()
    }

    private fun initClouds() {
        animateCloud(binding.imgCloudOne)
        animateCloudRevert(binding.imgCloudTwo)
        animateCloud(binding.imgCloudThree)
        animateCloudRevert(binding.imgCloudFour)
    }

    private fun animateCloud(cloud: ImageView) {
        ObjectAnimator.ofFloat(cloud, "translationX", -2000f).apply {
            duration = kotlin.random.Random.nextLong(2000, 6000)
            repeatCount = ValueAnimator.INFINITE
            start()
        }
    }

    private fun animateCloudRevert(cloud: ImageView) {
        ObjectAnimator.ofFloat(cloud, "translationX", 2000f).apply {
            duration = kotlin.random.Random.nextLong(2000, 6000)
            repeatCount = ValueAnimator.INFINITE
            start()
        }
    }

    private fun resetBall(ball: ImageView) {
        ball.visibility = View.VISIBLE
    }

    private fun setScore(){
        binding.txtScore.text = "$score"
        vibratePhone()
    }

    private fun vibratePhone() {
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            vibrator.vibrate(200)
        }
    }

    private fun initClickers() {
        binding.item1.setOnClickListener {
            score++
            binding.item1.visibility = View.INVISIBLE
            setScore()
        }
        binding.item2.setOnClickListener {
            score++
            binding.item2.visibility = View.INVISIBLE
            setScore()
        }
        binding.item3.setOnClickListener {
            score++
            binding.item3.visibility = View.INVISIBLE
            setScore()
        }
        binding.item4.setOnClickListener {
            score++
            binding.item4.visibility = View.INVISIBLE
            setScore()
        }
        binding.item5.setOnClickListener {
            score++
            binding.item5.visibility = View.INVISIBLE
            setScore()
        }
        binding.item6.setOnClickListener {
            score++
            binding.item6.visibility = View.INVISIBLE
            setScore()
        }
        binding.item7.setOnClickListener {
            score++
            binding.item7.visibility = View.INVISIBLE
            setScore()
        }
        binding.item8.setOnClickListener {
            score++
            binding.item8.visibility = View.INVISIBLE
            setScore()
        }
        binding.item9.setOnClickListener {
            score++
            binding.item9.visibility = View.INVISIBLE
            setScore()
        }
        binding.item10.setOnClickListener {
            score++
            binding.item10.visibility = View.INVISIBLE
            setScore()
        }
    }

    private fun startGame() {
        val wm = windowManager
        val disp = wm.defaultDisplay
        val size = Point()
        disp.getSize(size)
        screenWidth = size.x
        screenHeight = size.y
        randomizePosition(1)
        randomizePosition(2)
        randomizePosition(3)
        randomizePosition(4)
        randomizePosition(5)
        randomizePosition(6)
        randomizePosition(7)
        randomizePosition(8)
        randomizePosition(9)
        randomizePosition(10)

        binding.item1.x = -80.0f
        binding.item1.y = screenHeight + 80.0f
        binding.item2.x = screenWidth + 80.0f
        binding.item2.y = -80.0f
        binding.item3.x = screenWidth + 80.0f
        binding.item3.y = -80.0f

        timer!!.schedule(object : TimerTask() {
            override fun run() {
                handler.post(Runnable {
                    changePos()
                })
            }
        }, 0, 20)
    }


    fun changePos() {
        arrowDownY += 10f

        if (binding.item1.y > (screenHeight)) {
            arrowDownY = -100.0f
            resetBall(binding.item1)
            randomizePosition(1)
        }

        binding.item1.x = downX1.toFloat()
        binding.item1.y = arrowDownY

        if (binding.item2.y > screenHeight) {
            arrowDownY = -200.0f
            resetBall(binding.item2)
            randomizePosition(2)
        }
        binding.item2.x = downX2.toFloat()
        binding.item2.y = arrowDownY

        if (binding.item3.y > screenHeight) {
            arrowDownY = -300.0f
            resetBall(binding.item3)
            randomizePosition(3)
        }
        binding.item3.x = downX3.toFloat()
        binding.item3.y = arrowDownY

        if (binding.item4.y > screenHeight) {
            arrowDownY = -350.0f
            resetBall(binding.item4)
            randomizePosition(4)
        }
        binding.item4.x = downX4.toFloat()
        binding.item4.y = arrowDownY

        if (binding.item5.y > screenHeight) {
            arrowDownY = -400.0f
            resetBall(binding.item5)
            randomizePosition(5)
        }
        binding.item5.x = downX5.toFloat()
        binding.item5.y = arrowDownY

        if (binding.item6.y > screenHeight) {
            arrowDownY = -450.0f
            resetBall(binding.item6)
            randomizePosition(6)
        }
        binding.item6.x = downX6.toFloat()
        binding.item6.y = arrowDownY

        if (binding.item7.y > screenHeight) {
            arrowDownY = -500.0f
            resetBall(binding.item7)
            randomizePosition(7)
        }
        binding.item7.x = downX7.toFloat()
        binding.item7.y = arrowDownY

        if (binding.item8.y > screenHeight) {
            arrowDownY = -550.0f
            resetBall(binding.item8)
            randomizePosition(8)
        }
        binding.item8.x = downX8.toFloat()
        binding.item8.y = arrowDownY

        if (binding.item9.y > screenHeight) {
            arrowDownY = -600.0f
            resetBall(binding.item9)
            randomizePosition(9)
        }
        binding.item9.x = downX9.toFloat()
        binding.item9.y = arrowDownY

        if (binding.item10.y > screenHeight) {
            arrowDownY = -650.0f
            resetBall(binding.item10)
            randomizePosition(10)
        }
        binding.item10.x = downX10.toFloat()
        binding.item10.y = arrowDownY
    }

    private fun randomizePosition(ball: Int) {
        when (ball) {
            1 -> downX1 = listOfPositionsByY[(listOfPositionsByY.indices).random()]
            2 -> downX2 = listOfPositionsByY[(listOfPositionsByY.indices).random()]
            3 -> downX3 = listOfPositionsByY[(listOfPositionsByY.indices).random()]
            4 -> downX3 = listOfPositionsByY[(listOfPositionsByY.indices).random()]
            5 -> downX3 = listOfPositionsByY[(listOfPositionsByY.indices).random()]
            6 -> downX3 = listOfPositionsByY[(listOfPositionsByY.indices).random()]
            7 -> downX3 = listOfPositionsByY[(listOfPositionsByY.indices).random()]
            8 -> downX3 = listOfPositionsByY[(listOfPositionsByY.indices).random()]
            9 -> downX3 = listOfPositionsByY[(listOfPositionsByY.indices).random()]
            10 -> downX3 = listOfPositionsByY[(listOfPositionsByY.indices).random()]

        }
    }

}