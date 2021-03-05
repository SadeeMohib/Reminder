package com.example.reminderapp.calculators;

public class BMICalc {
    double meterHeight;
    double weightKg;
    double bmi;

    public BMICalc()
    {

    }

    public BMICalc(double meter,double kg)
    {
        this.meterHeight=meter;
        this.weightKg=kg;
    }

    public double CalculateBMI(double meter,double kg)
    {
        bmi=kg/(meter*meter);
        return bmi;
    }
}
