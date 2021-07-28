package com.vertigo.fragmentsimplemediaplayer

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class ButtonFragment: Fragment() {
    private var mContext: Context? = null
    private var button: Button? = null

    // Interfaces
    private var buttonFragmentClickListener: ButtonFragmentClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.button_fragment, container, false)
        mContext = inflater.context
        button = view.findViewById(R.id.btn)
        button?.apply {
            setOnClickListener {
                buttonFragmentClickListener?.nextFragmentButtonClickListener()
            }
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ButtonFragmentClickListener) {
            buttonFragmentClickListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        buttonFragmentClickListener = null
        mContext = null
    }
}

interface ButtonFragmentClickListener {
    fun nextFragmentButtonClickListener()
}