class AutomatedBikeSystem:
    def __init__(self):
        self.is_on = False
        self.acceleration = 0

    def toggle_power(self):
        self.is_on = not self.is_on

    def increase_acceleration(self):
        MAX_ACCELERATION = 70
        if not self.is_on:
            return
        if 0 <= self.acceleration <= 19:
            self.acceleration += 1
        elif 20 <= self.acceleration <= 29:
            self.acceleration += 2
        elif 30 <= self.acceleration <= 39:
            self.acceleration += 3
        elif 40 <= self.acceleration < MAX_ACCELERATION:
            self.acceleration += 4
        if self.acceleration > MAX_ACCELERATION:
            self.acceleration = MAX_ACCELERATION

    def decrease_acceleration(self):
        MIN_ACCELERATION = 0
        if not self.is_on:
            return
        if 40 <= self.acceleration <= 70:
            self.acceleration -= 4
        elif 30 <= self.acceleration <= 39:
            self.acceleration -= 3
        elif 20 <= self.acceleration <= 29:
            self.acceleration -= 2
        elif 1 <= self.acceleration <= 19:
            self.acceleration -= 1
        if self.acceleration < MIN_ACCELERATION:
            self.acceleration = MIN_ACCELERATION

    def get_acceleration(self):
        return self.acceleration


def main():
    bike = AutomatedBikeSystem()
    running = True

    while running:
        print("""
        Please enter an option:
        1. Power On
        2. Accelerate
        3. Decelerate
        0. Power Off
        """)
        try:
            user_choice = int(input("--->> "))
        except ValueError:
            print("Invalid input. Please enter a number.")
            continue

        if user_choice == 1:
            bike.toggle_power()
            print("Bike powered on." if bike.is_on else "Bike powered off.")
        elif user_choice == 2:
            if bike.is_on:
                bike.increase_acceleration()
                print("Bike acceleration ===> ", bike.get_acceleration())
            else:
                print("The bike is off. Please power it on first.")
        elif user_choice == 3:
            if bike.is_on:
                bike.decrease_acceleration()
                print("Bike deceleration ===> ", bike.get_acceleration())
            else:
                print("The bike is off. Please power it on first.")
        elif user_choice == 0:
            if bike.is_on:
                bike.toggle_power()
                print("Bike powered off.")
        else:
            print("Invalid option. Try again.")


if __name__ == "__main__":
    main()
