package com.alex.mcarstatistic.screens.dialogs

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentResultListener
import androidx.lifecycle.LifecycleOwner
import com.alex.mcarstatistic.databinding.DialogAddPartsBinding
import com.alex.mcarstatistic.model.SparePart
import java.util.Calendar

class DialogAdd: DialogFragment() {

    private var _binding: DialogAddPartsBinding? = null
    private val binding get() = _binding!!

    private var editedSparePart: SparePart? = null
    private var parentId: Int = 0

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        _binding = DialogAddPartsBinding.inflate(layoutInflater)


        parentId = arguments?.getInt(BUNDLE_PARENT_KEY) as Int
        editedSparePart = arguments?.getSerializable(BUNDLE_PART_KEY) as SparePart

        val dialog = AlertDialog.Builder(requireActivity())
            .setView(binding.root)
            .setCancelable(false)
            .setPositiveButton("OK", null)
            .setNegativeButton("Cancel", null)
            .create()

        if (editedSparePart != null) { setSparePart() }

        dialog.setOnShowListener {
            dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener {

                if (validate()) return@setOnClickListener

                //add to database
                createSparePart()

                dialog.dismiss()
            }
        }
        return dialog
    }

    private fun setSparePart(){

        with(binding){
            etName.setText(editedSparePart?.name)
            etPartnumber.setText(editedSparePart?.partNumber)
            etOriginalPartnumber.setText(editedSparePart?.originalPartNumber)
            etNumber.setText(editedSparePart?.number.toString())
            etCost.setText(editedSparePart?.cost.toString())
        }
    }

    private fun validate(): Boolean{

        var status = true

        val name = binding.etName.toString()
        val cost = binding.etCost.toString().toIntOrNull()
        val number = binding.etNumber.toString().toIntOrNull()

        if (name.isEmpty()) {
            binding.etLayName.error = "Потрбіно вказати назву деталі"
            status = false
        }

        if (cost == null || cost == 0){
            binding.etLayCost.error = " "
            status = false
        }

        if (number == null || number == 0){
            binding.etLayNumber.error = " "
            status = false
        }
        return status
    }

    private fun createSparePart(){

        val newSparePart = SparePart(
            id = editedSparePart?.id ?: 0,
            name = binding.etName.toString(),
            partNumber = binding.etPartnumber.toString(),
            originalPartNumber = binding.etOriginalPartnumber.toString(),
            cost = binding.etCost.toString().toInt(),
            number = binding.etNumber.toString().toInt(),
            date = editedSparePart?.date ?: Calendar.getInstance()
        )
    }

    companion object{

        private val DIALOG_ADD_TAG = "DialogAdd_tag"
        private val DIALOG_ADD_REQUEST_KEY = "DialogAdd_request_key"
        private val BUNDLE_PART_KEY = "bundle_part_key"
        private val BUNDLE_PARENT_KEY = "bundle_parent_key"

        fun showDialogAdd(fManager: FragmentManager, sparePart: SparePart?){
            val dialog = DialogAdd()
            if (sparePart != null) {
//                val bundle = Bundle()
//                bundle.putSerializable(BUNDLE_KEY, sparePart)
//                dialog.arguments = bundle
                dialog.arguments = bundleOf(BUNDLE_PART_KEY to sparePart)
            }
            dialog.show(fManager, DIALOG_ADD_TAG)
        }

        fun setupDialogAddListener(fManager: FragmentManager, lcOwner: LifecycleOwner, listener: (SparePart) -> Unit){
            fManager.setFragmentResultListener(DIALOG_ADD_REQUEST_KEY, lcOwner, FragmentResultListener { _, result ->
                val sparePart = result.getSerializable(BUNDLE_PART_KEY) as SparePart
                listener.invoke(sparePart)
            })
        }
    }
}