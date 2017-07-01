package com.example.dmko.converter.utils;

public class ConverterUtils {
    public static double convertCelsiusToFahrenheit(double celsius) {
        return celsius * 1.8 + 32;
    }
    public static double convertCelsiusToKelvin(double celsius){
        return celsius + 273.15;
    }
    public static double convertFahrenheitToCelsius(double fahrenheit){
        return ((fahrenheit - 32) / 1.8);
    }
    public static double convertFahrenheitToKelvin(double fahrenheit){
        return convertCelsiusToKelvin(convertFahrenheitToCelsius(fahrenheit));
    }
    public static double convertKelvinToCelsius(double kelvin){
        return kelvin - 273.15;
    }
    public static double convertKelvinToFahrenheit(double kelvin){
        return convertCelsiusToFahrenheit(convertKelvinToCelsius(kelvin));
    }
}