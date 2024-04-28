package com.insa.gamelist


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.insa.gamelist.databinding.DetailJeuLayoutBinding
import com.insa.gamelist.extentions.loadConsoleLogo
import com.insa.gamelist.utils.DataManager
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      val binding = DetailJeuLayoutBinding.inflate(inflater, container, false)
      val id = arguments?.getInt("gameId")
      val game = DataManager.getGame(id!!)
      binding.tvDescription.text = game!!.description
      binding.tvGenre.text = game.type
      binding.tvTitreDetail.text = game.title
      binding.tvTimeStamp.text = game.timestamp.toString()
      binding.tvDeveloper.text = game.developer
      binding.tvEditor.text = game.editor
      Picasso.get().load(game.image).into(binding.imageDetail)
      val linearLayout = binding.imageConsole
      for (i in 0 until game.console.size) {
        val imgView = ImageView(this.context)
        val lp = LinearLayout.LayoutParams(120, 120)
        imgView.layoutParams = lp
        when (game.console[i]) {
          "Xbox One" -> imgView.loadConsoleLogo("Xbox One", this.requireContext())
          "Xbox X|S" -> imgView.loadConsoleLogo("Xbox X|S", this.requireContext())
          "PC" -> imgView.loadConsoleLogo("PC", this.requireContext())
          "PS5" -> imgView.loadConsoleLogo("PS5", this.requireContext())
          "PS4" -> imgView.loadConsoleLogo("PS4", this.requireContext())
          "Switch" -> imgView.loadConsoleLogo("Switch", this.requireContext())
          else -> imgView.setImageResource(R.drawable.ic_launcher_background)
        }
        linearLayout.addView(imgView)
      }
      return binding.root
    }
}
