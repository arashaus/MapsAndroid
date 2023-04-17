package cr.ac.menufragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class ConfigurationFragment : Fragment() {
    lateinit var texto: EditText
    lateinit var boton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_configuration, container, false)

        texto = view.findViewById(R.id.locationUpdate)
        boton = view.findViewById(R.id.updateButton)

        boton.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("edit_text_value", texto.text.toString())

            val fragment = MapsFragment()
            fragment.arguments = bundle


            fragmentManager?.beginTransaction()?.replace(R.id.fragment_container, fragment)?.commit()
        }

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}
