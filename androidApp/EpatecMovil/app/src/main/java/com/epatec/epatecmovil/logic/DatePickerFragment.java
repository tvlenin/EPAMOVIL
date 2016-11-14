package com.epatec.epatecmovil.logic;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TextView;

import com.epatec.epatecmovil.R;
import com.epatec.epatecmovil.UserDataHolder;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        TextView tv1= (TextView) getActivity().findViewById(R.id.txtViewDate);
        UserDataHolder dd = UserDataHolder.getInstance();
        dd.pUserDate = view.getMonth()+1 + "/" + view.getDayOfMonth() + "/" + view.getYear();
        tv1.setText(view.getMonth()+1 + " / " + view.getDayOfMonth() + " / " + view.getYear());
    }
}