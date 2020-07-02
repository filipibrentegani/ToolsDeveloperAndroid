package com.filipibrentegani.toolsdeveloperandroid.component

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.util.SparseArray
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import com.filipibrentegani.toolsdeveloperandroid.R

class Component @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    FrameLayout(context, attrs, defStyleAttr) {

    private lateinit var editText: EditText

    init {
        LayoutInflater.from(context).inflate(R.layout.component, this, true)
        editText = findViewById(R.id.component_edit_text)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.Component, 0, 0)

            val text = typedArray.getString(R.styleable.Component_custom_title)
            editText.setText(text, TextView.BufferType.EDITABLE)
            typedArray.recycle()
        }
    }

    override fun dispatchSaveInstanceState(container: SparseArray<Parcelable>) {
        //do not store state for their children views
        super.dispatchFreezeSelfOnly(container)
    }

    override fun dispatchRestoreInstanceState(container: SparseArray<Parcelable>) {
        //do not restore state for their children views
        super.dispatchThawSelfOnly(container)
    }

    override fun onSaveInstanceState(): Parcelable {
        val superState = super.onSaveInstanceState()!!
        val state = SavedState(superState)
        state.text = editText.text.toString()
        return state
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        if (state !is SavedState) {
            super.onRestoreInstanceState(state)
            return
        }

        editText.setText(state.text, TextView.BufferType.EDITABLE)
        super.onRestoreInstanceState(state.superState)
    }

    class SavedState: BaseSavedState {
        var text: String? = ""

        constructor(superState: Parcelable) : super(superState)

        private constructor(parcel: Parcel) : super(parcel) {
            text = parcel.readString()
        }

        override fun writeToParcel(out: Parcel?, flags: Int) {
            super.writeToParcel(out, flags)
            out?.writeString(text)
        }

        companion object {
            @JvmField
            val CREATOR: Parcelable.Creator<SavedState> = object : Parcelable.Creator<SavedState> {
                override fun createFromParcel(parcel: Parcel): SavedState {
                    return SavedState(parcel)
                }

                override fun newArray(size: Int): Array<SavedState?> {
                    return arrayOfNulls(size)
                }
            }
        }
    }
}