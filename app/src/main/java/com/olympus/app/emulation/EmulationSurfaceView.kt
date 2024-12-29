package com.olympus.app.emulation

import android.content.Context
import android.util.AttributeSet
import android.view.Surface
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Rect
import android.graphics.RectF
import android.graphics.Typeface
import android.graphics.Bitmap
import android.util.Log
import android.graphics.BitmapFactory

import com.olympus.app.R

class EmulationSurfaceView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : SurfaceView(context, attrs, defStyleAttr), SurfaceHolder.Callback {

    /** Callbacks definitions */
    inner class EmulationSurfaceCallbacks {
        var surfaceCreatedHandler: ((SurfaceHolder) -> Unit)? = null
        var surfaceChangedHandler: ((SurfaceHolder, Int, Int, Int) -> Unit)? = null
        var surfaceDestroyedHandler: ((SurfaceHolder) -> Unit)? = null
    }
    
    
    companion object {
         /** variable to store surface callbacks acessible for other class */
         lateinit var callbacks: EmulationSurfaceCallbacks 
    }
    
    init {
        holder.addCallback(this)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        callbacks.surfaceCreatedHandler?.invoke(holder)
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        callbacks.surfaceChangedHandler?.invoke(holder, format, width, height)
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        callbacks.surfaceDestroyedHandler?.invoke(holder)
    }
}