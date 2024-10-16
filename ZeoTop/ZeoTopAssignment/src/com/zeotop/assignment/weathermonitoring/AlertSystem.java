package com.zeotop.assignment.weathermonitoring;

class AlertSystem {

    private double temperatureThreshold;
    private int consecutiveThresholdBreaches = 0;
    
    public AlertSystem(double temperatureThreshold) {
        this.temperatureThreshold = temperatureThreshold;
    }

    public void checkForAlerts(double currentTemp) {
        if (currentTemp > temperatureThreshold) {
            consecutiveThresholdBreaches++;
        } else {
            consecutiveThresholdBreaches = 0;  // Reset if not breached
        }

        if (consecutiveThresholdBreaches >= 2) {
            triggerAlert(currentTemp);
        }
    }

    private void triggerAlert(double temp) {
        System.out.println("Alert: Temperature exceeded " + temperatureThreshold + "°C. Current temperature: " + temp + "°C.");
        // we could also send an email here using JavaMail API
    }
}
