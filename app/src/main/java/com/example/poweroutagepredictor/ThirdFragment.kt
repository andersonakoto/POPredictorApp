package com.example.poweroutagepredictor

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.fragment_third.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ThirdFragment : Fragment() {


    private val sharedPrefFile = "kotlinsharedpreference"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences: SharedPreferences = requireContext().getSharedPreferences(sharedPrefFile,
            Context.MODE_PRIVATE)

        val laty = sharedPreferences.getString("latt", null)
        val lngy = sharedPreferences.getString("lngg", null)

        lat!!.text = "Latitude: " + laty
        lng!!.text = "Longitude: " + lngy

        get_likelihood.setOnClickListener(){
            getLikelihood()
        }

    }


    fun getLikelihood (){
        val textView = view?.findViewById<TextView>(R.id.likelihood)
        val lat = view?.findViewById<TextView>(R.id.lat)
        val lng = view?.findViewById<TextView>(R.id.lng)

        val queue = Volley.newRequestQueue(this.context)
        val url = "http://192.168.100.95:8000/predict?lat=${lat}&lng=${lng}"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                // Display the first 500 characters of the response string.
                textView!!.text = "There is a " + response.toString() +" % chance of a power outage at your location"
            },
            { textView!!.text = "Unable to retrieve Probabilities at this time." })

        queue.add(stringRequest)
    }

}