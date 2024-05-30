package com.example.hutchsystemstest

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.DisplayMetrics
import android.view.View


class MyView(private val context: Context?) : View(context) {
    internal inner class Pt(var x: Float, var y: Float)

    private var myPath = arrayOf<Pt>(
        Pt(100f, 100f),
        Pt(100f, 200f)
    )

    override fun onDraw(canvas: Canvas) {

        super.onDraw(canvas)

        showTextLeft(canvas)
        drawHorizontalLines(canvas)
        drawVerticalLines(canvas)
        drawGraphLine(canvas)

    }

    private fun drawVerticalLines(canvas: Canvas) {
        val metrics: DisplayMetrics = context!!.resources.displayMetrics
        val width = metrics.widthPixels
        val columnWidth = width/24

        for (i in 1..24){
            val paint = Paint()
            paint.color = Color.GRAY
            paint.strokeWidth = 2f
            paint.style = Paint.Style.STROKE
            val path = Path()
            path.moveTo(columnWidth*i.toFloat(), 100f)
            path.lineTo(columnWidth*i.toFloat(), 780f)
            canvas.drawPath(path, paint)
        }

    }

    private fun drawGraphLine(canvas: Canvas) {
        val paint = Paint()
        paint.color = Color.RED
        paint.strokeWidth = 5f
        paint.style = Paint.Style.STROKE
        val path = Path()
        path.moveTo(300f, 700f)
        path.lineTo(150f, 700f)
        canvas.drawPath(path, paint)


    }

    private fun drawHorizontalLines(canvas: Canvas) {
        val metrics: DisplayMetrics = context!!.resources.displayMetrics
        val width = metrics.widthPixels
        val paintLine1 = Paint()
        paintLine1.color = Color.WHITE
        paintLine1.strokeWidth = 2f
        paintLine1.style = Paint.Style.STROKE
        val path = Path()
        path.moveTo(width.toFloat(), 180f)
        path.lineTo(100f, 180f)
        canvas.drawPath(path, paintLine1)

        val paintLine2 = Paint()
        paintLine2.color = Color.WHITE
        paintLine2.strokeWidth = 2f
        paintLine2.style = Paint.Style.STROKE
        val path2 = Path()
        path2.moveTo(width.toFloat(), 380f)
        path2.lineTo(100f, 380f)
        canvas.drawPath(path2, paintLine2)

        val paintLine3 = Paint()
        paintLine3.color = Color.WHITE
        paintLine3.strokeWidth = 2f
        paintLine3.style = Paint.Style.STROKE
        val path3 = Path()
        path3.moveTo(width.toFloat(), 580f)
        path3.lineTo(100f, 580f)
        canvas.drawPath(path3, paintLine3)

        val paintLine4 = Paint()
        paintLine4.color = Color.WHITE
        paintLine4.strokeWidth = 2f
        paintLine4.style = Paint.Style.STROKE
        val path4 = Path()
        path4.moveTo(width.toFloat(), 780f)
        path4.lineTo(100f, 780f)
        canvas.drawPath(path4, paintLine4)
    }

    private fun showTextLeft(canvas: Canvas) {
        val textOffduty = Paint()
        textOffduty.color = Color.WHITE
        textOffduty.textSize = 30f
        canvas.drawText(context!!.resources.getString(R.string.off_duty), 20f, 100f, textOffduty)

        val textSleeper = Paint()
        textSleeper.color = Color.WHITE
        textSleeper.textSize = 30f
        canvas.drawText(context.getString(R.string.sleeper_berth), 20f, 300f, textSleeper)

        val textDriving = Paint()
        textDriving.color = Color.WHITE
        textDriving.textSize = 30f
        canvas.drawText(context.getString(R.string.driving), 20f, 500f, textDriving)

        val textOnDuty = Paint()
        textOnDuty.color = Color.WHITE
        textOnDuty.textSize = 30f
        canvas.drawText(context.getString(R.string.on_duty), 20f, 700f, textOnDuty)
    }
}