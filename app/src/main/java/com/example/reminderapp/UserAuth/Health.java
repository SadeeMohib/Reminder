package com.example.reminderapp.UserAuth;

public class Health {
    public double weight,hight,BMI,BMR,diabetes,pulse;
    public double bloodSystol,bloodDiastol;

    public Health()
    {

    }

    public Health(double weight, double hight, double BMI, double BMR, double diabetes, double pulse, double bloodSystol, double bloodDiastol)
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

    public double getWeight() {
        return weight;
    }

    public double getHight() {
        return hight;
    }

    public double getBMI() {
        return BMI;
    }

    public double getBMR() {
        return BMR;
    }

    public double getDiabetes() {
        return diabetes;
    }

    public double getPulse() {
        return pulse;
    }

    public double getBloodSystol() {
        return bloodSystol;
    }

    public double getBloodDiastol() {
        return bloodDiastol;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }

    public void setBMI(double BMI) {
        this.BMI = BMI;
    }

    public void setBMR(double BMR) {
        this.BMR = BMR;
    }

    public void setDiabetes(double diabetes) {
        this.diabetes = diabetes;
    }

    public void setPulse(double pulse) {
        this.pulse = pulse;
    }

    public void setBloodSystol(double bloodSystol) {
        this.bloodSystol = bloodSystol;
    }

    public void setBloodDiastol(double bloodDiastol) {
        this.bloodDiastol = bloodDiastol;
    }
}
