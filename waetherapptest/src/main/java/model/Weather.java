package model;

public class Weather {
    private int tempInFahrenheit;
    private int tempInCelsius;

    public Weather() {
    }

    public int getTempInCelsius() {
        return tempInCelsius;
    }

    public void setTempInCelsius(int tempInCelsius) {
        this.tempInCelsius = tempInCelsius;
    }

    public int getTempInFahrenheit() {
        return tempInFahrenheit;
    }

    public void setTempInFahrenheit(int tempInFahrenheit) {
        this.tempInFahrenheit = tempInFahrenheit;
    }
}
