public class AutomatedBikeSystem {
    private boolean isOn = false;
    private int acceleration = 0;


    public void togglePower() {
        isOn = !isOn;
    }

    public boolean isBikeOn() {
        return isOn;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void increaseAcceleration() {
        if (!isOn) return;

        final int maxAcceleration = 70;

        if (acceleration >= 0 && acceleration <= 20) {
            acceleration += 1;
        } else if (acceleration >= 21 && acceleration <= 30) {
            acceleration += 2;
        } else if (acceleration >= 31 && acceleration <= 40) {
            acceleration += 3;
        } else if (acceleration >= 41 && acceleration < maxAcceleration) {
            acceleration += 4;
        }

        if (acceleration > maxAcceleration) {
            acceleration = maxAcceleration;
        }
    }

    public void decreaseAcceleration() {
        if (!isOn) return;

        final int minAcceleration = 0;

        if (acceleration >= 41 && acceleration <= 70) {
            acceleration -= 4;
        } else if (acceleration >= 31 && acceleration <= 40) {
            acceleration -= 3;
        } else if (acceleration >= 21 && acceleration <= 30) {
            acceleration -= 2;
        } else if (acceleration >= 1 && acceleration <= 20) {
            acceleration -= 1;
        }

        if (acceleration < minAcceleration) {
            acceleration = minAcceleration;
        }
    }

}
