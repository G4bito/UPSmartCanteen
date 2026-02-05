package com.yutahnahsyah.upsmartcanteenfrontend.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yutahnahsyah.upsmartcanteenfrontend.R
import com.yutahnahsyah.upsmartcanteenfrontend.data.model.Cart
import com.yutahnahsyah.upsmartcanteenfrontend.adapter.CartAdapter


class CartFragment : Fragment() {

  private lateinit var adapter: CartAdapter

  private val cartList = listOf(
    Cart(
      "Cart Number One",
      "Status/Description",
      101.0,
      R.drawable.food_image,
      R.drawable.food_image
    ),
    Cart(
      "Cart Number Two",
      "Status/Description",
      202.0,
      R.drawable.food_image,
      R.drawable.food_image
    )
  )

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_cart, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val rv = view.findViewById<RecyclerView>(R.id.recyclerView)

    adapter = CartAdapter(cartList) { selectedCart ->
      Toast.makeText(requireContext(), "Clicking ${selectedCart.name}", Toast.LENGTH_SHORT)
        .show()
    }

    rv.layoutManager = LinearLayoutManager(requireContext())
    rv.adapter = adapter
  }
}