package com.example.unitconversionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    String[] unitTypes = {"Select Unit Type", "Length", "Weight", "Temperature"};
    String[] length = {"Select Unit", "Inch", "Foot", "Yard", "Mile", "Centimeter", "Kilometer"};
    String[] weight = {"Select Unit", "Pound", "Ounce", "Ton", "Gram", "Kilogram"};
    String[] temperature = {"Select Unit", "Kelvin", "Celsius", "Fahrenheit"};
    String[] defaultUnit = {"Select Unit Type"};

    String selectedType, selectedSourceUnit, selectedDestUnit;
    String numberToConvert, convertedNumber;

    ArrayAdapter conversionAD, sourceAD, destinationAD;
    TextView titleText;
    EditText inputText;
    TextView outputText;

    Spinner conversionType;
    Spinner sourceUnit;
    Spinner destinationUnit;

    Button convertButton;

    double lengthConversion(int number, String from, String to){
        if (Objects.equals(from, to)){
            return number;
        }
        if (Objects.equals(from, "Inch")){
            if (Objects.equals(to, "Foot")){
                return number/12;
            }
            if (Objects.equals(to, "Yard")){
                return number/36;
            }
            if (Objects.equals(to, "Mile")){
                return number/63360;
            }
            if (Objects.equals(to, "Centimeter")){
                return number*2.54;
            }
            if (Objects.equals(to, "Kilometer")){
                return number/39370;
            }
        }
        if (Objects.equals(from, "Foot")){
            if (Objects.equals(to, "Inch")){
                return number*12;
            }
            if (Objects.equals(to, "Yard")){
                return number/3;
            }
            if (Objects.equals(to, "Mile")){
                return number/5280;
            }
            if (Objects.equals(to, "Centimeter")){
                return number*30.48;
            }
            if (Objects.equals(to, "Kilometer")){
                return number/3281;
            }
        }
        if (Objects.equals(from, "Yard")){
            if (Objects.equals(to, "Inch")){
                return number*36;
            }
            if (Objects.equals(to, "Foot")){
                return number*3;
            }
            if (Objects.equals(to, "Mile")){
                return number/1760;
            }
            if (Objects.equals(to, "Centimeter")){
                return number*91.44;
            }
            if (Objects.equals(to, "Kilometer")){
                return number/1094;
            }
        }
        if (Objects.equals(from, "Mile")){
            if (Objects.equals(to, "Inch")){
                return number*63360;
            }
            if (Objects.equals(to, "Foot")){
                return number*5280;
            }
            if (Objects.equals(to, "Yard")){
                return number*1760;
            }
            if (Objects.equals(to, "Centimeter")){
                return number*160900;
            }
            if (Objects.equals(to, "Kilometer")){
                return number*1.609;
            }
        }
        if (Objects.equals(from, "Centimeter")){
            if (Objects.equals(to, "Inch")){
                return number/2.54;
            }
            if (Objects.equals(to, "Foot")){
                return number/30.48;
            }
            if (Objects.equals(to, "Yard")){
                return number/91.44;
            }
            if (Objects.equals(to, "Mile")){
                return number/160900;
            }
            if (Objects.equals(to, "Kilometer")){
                return number/100000;
            }
        }
        if (Objects.equals(from, "Kilometer")){
            if (Objects.equals(to, "Inch")){
                return number*39370;
            }
            if (Objects.equals(to, "Foot")){
                return number*3281;
            }
            if (Objects.equals(to, "Yard")){
                return number*1094;
            }
            if (Objects.equals(to, "Mile")){
                return number/1.609;
            }
            if (Objects.equals(to, "Centimeter")){
                return number*100000;
            }
        }
        return number;
    }

    double weightConversion(int number, String from, String to){
        if (Objects.equals(from, to)){
            return number;
        }
        if (Objects.equals(from, "Pound")){
            if (Objects.equals(to, "Ounce")){
                return number*16;
            }
            if (Objects.equals(to, "Ton")){
                return number/2000;
            }
            if (Objects.equals(to, "Gram")){
                return number*453.6;
            }
            if (Objects.equals(to, "Kilogram")){
                return number/2.205;
            }
        }
        if (Objects.equals(from, "Ounce")){
            if (Objects.equals(to, "Pound")){
                return number/16;
            }
            if (Objects.equals(to, "Ton")){
                return number/32000;
            }
            if (Objects.equals(to, "Gram")){
                return number*28.35;
            }
            if (Objects.equals(to, "Kilogram")){
                return number/35.274;
            }
        }
        if (Objects.equals(from, "Ton")){
            if (Objects.equals(to, "Pound")){
                return number*2000;
            }
            if (Objects.equals(to, "Ounce")){
                return number*32000;
            }
            if (Objects.equals(to, "Gram")){
                return number*907200;
            }
            if (Objects.equals(to, "Kilogram")){
                return number*907.2;
            }
        }
        if (Objects.equals(from, "Gram")){
            if (Objects.equals(to, "Pound")){
                return number/453.6;
            }
            if (Objects.equals(to, "Ounce")){
                return number/28.35;
            }
            if (Objects.equals(to, "Ton")){
                return number/907200;
            }
            if (Objects.equals(to, "Kilogram")){
                return number/1000;
            }
        }
        if (Objects.equals(from, "Kilogram")){
            if (Objects.equals(to, "Pound")){
                return number*2.205;
            }
            if (Objects.equals(to, "Ounce")){
                return number*35.274;
            }
            if (Objects.equals(to, "Ton")){
                return number/907.2;
            }
            if (Objects.equals(to, "Gram")){
                return number*1000;
            }
        }
        return number;
    }

    double tempConversion(int number, String from, String to){
        if (Objects.equals(from, to)){
            return number;
        }
        if (Objects.equals(from, "Kelvin")){
            if (Objects.equals(to, "Celsius")){
                return number-273.15;
            }
            if (Objects.equals(to, "Fahrenheit")){
                return (number-273.15)* 9/5 + 32;
            }
        }
        if (Objects.equals(from, "Celsius")){
            if (Objects.equals(to, "Kelvin")){
                return number+273.15;
            }
            if (Objects.equals(to, "Fahrenheit")){
                return (number*9/5) + 32;
            }
        }
        if (Objects.equals(from, "Fahrenheit")){
            if (Objects.equals(to, "Kelvin")){
                return (number-32)*5/9+273.15;
            }
            if (Objects.equals(to, "Celsius")){
                return (number-32)*5/9;
            }
        }
        return number;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigns values to their id
        titleText = findViewById(R.id.titleText);
        inputText = findViewById(R.id.inputText);
        outputText = findViewById(R.id.outputText);

        conversionType = findViewById(R.id.conversionType);
        sourceUnit = findViewById(R.id.sourceUnit);
        destinationUnit = findViewById(R.id.destinationUnit);

        convertButton = findViewById(R.id.convertButton);

        //creates first spinner that allows selection of the unit type
        conversionAD = new ArrayAdapter(this, android.R.layout.simple_spinner_item, unitTypes);
        conversionType.setAdapter(conversionAD);
        conversionType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedType = conversionType.getSelectedItem().toString();
                int adapterID = adapterView.getId();

                //after first spinner selects an option, the following spinners use that value to change the options they offer
                if (adapterID == R.id.conversionType){
                    switch(selectedType){
                        case "Select Unit Type": sourceAD = new ArrayAdapter(adapterView.getContext(), android.R.layout.simple_spinner_item, defaultUnit);
                            break;
                        case "Length": sourceAD = new ArrayAdapter(adapterView.getContext(), android.R.layout.simple_spinner_item, length);
                        break;
                        case "Weight": sourceAD = new ArrayAdapter(adapterView.getContext(), android.R.layout.simple_spinner_item, weight);
                        break;
                        case "Temperature": sourceAD = new ArrayAdapter(adapterView.getContext(), android.R.layout.simple_spinner_item, temperature);
                        default: break;
                    }

                    sourceAD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sourceUnit.setAdapter(sourceAD);

                    sourceUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            selectedSourceUnit = sourceUnit.getSelectedItem().toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }if (adapterID == R.id.conversionType){
                    switch(selectedType){
                        case "Select Unit Type": destinationAD = new ArrayAdapter(adapterView.getContext(), android.R.layout.simple_spinner_item, defaultUnit);
                            break;
                        case "Length": destinationAD = new ArrayAdapter(adapterView.getContext(), android.R.layout.simple_spinner_item, length);
                            break;
                        case "Weight": destinationAD = new ArrayAdapter(adapterView.getContext(), android.R.layout.simple_spinner_item, weight);
                            break;
                        case "Temperature": destinationAD = new ArrayAdapter(adapterView.getContext(), android.R.layout.simple_spinner_item, temperature);
                        default: break;
                    }

                    destinationAD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    destinationUnit.setAdapter(destinationAD);

                    destinationUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            selectedDestUnit = destinationUnit.getSelectedItem().toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //takes the value in the editText and makes it ready to calculate
                numberToConvert = inputText.getText().toString();
                int number = Integer.parseInt(numberToConvert);

                //takes selected unit type gotten from first spinner, and runs it through the calculators
                if (Objects.equals(selectedType, "Weight")){
                    convertedNumber = String.valueOf(weightConversion(number, selectedSourceUnit, selectedDestUnit));
                    outputText.setText(convertedNumber);
                }
                if (Objects.equals(selectedType, "Temperature")){
                    convertedNumber = String.valueOf(tempConversion(number, selectedSourceUnit, selectedDestUnit));
                    outputText.setText(convertedNumber);
                }
                if (Objects.equals(selectedType, "Length")){
                    convertedNumber = String.valueOf(lengthConversion(number, selectedSourceUnit, selectedDestUnit));
                    outputText.setText(convertedNumber);
                }
            }
        });
    }
}