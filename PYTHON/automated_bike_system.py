class AutomatedBikeSystem:
    MAX_ACCELERATION = 70
    MIN_ACCELERATION = 0

    def __init__(self, acceleration: int = 0, power_toggle: bool = False) -> None:
        self.acceleration = acceleration
        self.isOn = power_toggle

    def power_toggle(self) -> None:
        self.isOn = not self.isOn

    def is_on(self) -> bool:
        return self.isOn

    def get_acceleration(self) -> int:
        return self.acceleration

    def increase_acceleration(self) -> None:
        if not self.isOn:
            return

        if 0 <= self.acceleration <= 20:
            self.acceleration += 1
        elif 21 <= self.acceleration <= 30:
            self.acceleration += 2
        elif 31 <= self.acceleration <= 40:
            self.acceleration += 3
        elif 41 <= self.acceleration < self.MAX_ACCELERATION:
            self.acceleration += 4

        if self.acceleration > self.MAX_ACCELERATION:
            self.acceleration = self.MAX_ACCELERATION

    def decrease_acceleration(self) -> None:
        if not self.isOn:
            return

        if 41 <= self.acceleration <= 70:
            self.acceleration -= 4
        elif 31 <= self.acceleration <= 40:
            self.acceleration -= 3
        elif 21 <= self.acceleration <= 30:
            self.acceleration -= 2
        elif 1 <= self.acceleration <= 19:
            self.acceleration -= 1

        if self.acceleration < self.MIN_ACCELERATION:
            self.acceleration = self.MIN_ACCELERATION

if __name__ == '__main__':
    main = AutomatedBikeSystem()
