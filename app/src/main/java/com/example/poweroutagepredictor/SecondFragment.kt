package com.example.poweroutagepredictor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myWebView: WebView = view.findViewById(R.id.webview)
        myWebView.getSettings().setJavaScriptEnabled(true)
        myWebView.getSettings().setAllowFileAccess(true)
        myWebView.getSettings().setUseWideViewPort(true)
        myWebView.getSettings().setLoadWithOverviewMode(true)
        myWebView.getSettings().setBuiltInZoomControls(true)
        myWebView.loadUrl("http://192.168.100.95:8000")

        // chromium, enable hardware acceleration
        myWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
    }

}