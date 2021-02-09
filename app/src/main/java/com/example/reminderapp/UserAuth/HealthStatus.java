package com.example.reminderapp.UserAuth;

public class HealthStatus {
    public double weight,hight,BMI,BMR,diabetes,pulse;
    public double bloodSystol,bloodDiastol;

    public HealthStatus()
    {

    }

    public HealthStatus(double weight,double hight,double BMI,double BMR,double diabetes,double pulse,double bloodSystol,double bloodDiastol)
    {
        this.weight=weight;
        this.hight=hight;
        this.BMI=BMI;
        this.BMR=BMR;
        this.diabetes=diabetes;
        this.bloodSystol=bloodSystol;
        this.bloodDiastol=bloodDiastol;
        this.pulse=pulse;
    }

}
