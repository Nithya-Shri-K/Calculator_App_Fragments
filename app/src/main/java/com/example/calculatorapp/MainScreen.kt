package com.example.calculatorapp

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import com.example.calculatorapp.databinding.FragmentMainScreenBinding


class MainScreen : Fragment() {
lateinit var binding : FragmentMainScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainScreenBinding.inflate(layoutInflater,container,false)

        if(savedInstanceState?.getInt(IS_RESULT_PAGE) == 1){
            modifyScreenForResult()
            binding.textResult.text = savedInstanceState.getString(RESULT)
        }
        binding.add.setOnClickListener { navigate(it,Operation.ADD)}
        binding.subtract.setOnClickListener { navigate(it,Operation.SUBTRACT)}
        binding.multiply.setOnClickListener { navigate(it,Operation.MULTIPLY)}
        binding.divide.setOnClickListener { navigate(it,Operation.DIVIDE)}
        binding.buttonReset.setOnClickListener {
            binding.layoutResult.visibility=View.GONE
            binding.textResult.text=""
            binding.layoutButtons.visibility=View.VISIBLE

             }
        setFragmentResultListener(REQUEST_KEY){ requestKey, bundle ->
            binding.textResult.text = getString(R.string.result_text,bundle.getString(RESULT),bundle.getString("operand1"),bundle.getString("operand2"),bundle.getString("operation"))
            modifyScreenForResult()
        }
        return binding.root
    }
    private fun navigate(view: View, operation: Operation){
        view.findNavController().navigate(MainScreenDirections.actionMainScreenToCalculate(operation))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if(binding.layoutResult.isVisible){
            outState.putInt(IS_RESULT_PAGE, 1)
            outState.putString(RESULT,binding.textResult.text.toString())
        }
    }
    private fun modifyScreenForResult(){
        binding.layoutButtons.visibility=View.GONE
        binding.layoutResult.visibility=View.VISIBLE
    }


}