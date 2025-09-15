import unittest
import automated_bike_system


class TestAutomatedBikeSystem(unittest.TestCase):

    def setUp(self):
        self.bike = ()

    def test_bike_is_off_by_default(self):
        self.assertFalse(self.bike.is_on())

    def test_toggle_power_turns_bike_on(self):
        self.bike.power_toggle()
        self.assertTrue(self.bike.is_on())

    def test_toggle_power_twice_turns_bike_off(self):
        self.bike.power_toggle()
        self.bike.power_toggle()
        self.assertFalse(self.bike.is_on())

    def test_initial_acceleration_is_zero(self):
        self.assertEqual(self.bike.get_acceleration(), 0)

    def test_acceleration_does_not_increase_when_off(self):
        self.bike.increase_acceleration()
        self.assertEqual(self.bike.get_acceleration(), 0)

    def test_acceleration_increases_by_1_in_gear_1(self):
        self.bike.power_toggle()
        self.bike.increase_acceleration()
        self.assertEqual(self.bike.get_acceleration(), 1)

    def test_acceleration_increases_by_2_in_gear_2(self):
        self.bike.power_toggle()
        self.bike.acceleration = 21
        self.bike.increase_acceleration()
        self.assertEqual(self.bike.get_acceleration(), 23)

    def test_acceleration_increases_by_3_in_gear_3(self):
        self.bike.power_toggle()
        self.bike.acceleration = 35
        self.bike.increase_acceleration()
        self.assertEqual(self.bike.get_acceleration(), 38)

    def test_acceleration_increases_by_4_in_gear_4(self):
        self.bike.power_toggle()
        self.bike.acceleration = 45
        self.bike.increase_acceleration()
        self.assertEqual(self.bike.get_acceleration(), 49)

    def test_acceleration_does_not_exceed_max(self):
        self.bike.power_toggle()
        self.bike.acceleration = 69
        self.bike.increase_acceleration()
        self.assertEqual(self.bike.get_acceleration(), 70)

    def test_decrease_acceleration_by_4_from_gear_4(self):
        self.bike.power_toggle()
        self.bike.acceleration = 50
        self.bike.decrease_acceleration()
        self.assertEqual(self.bike.get_acceleration(), 46)

    def test_decrease_acceleration_by_3_from_gear_3(self):
        self.bike.power_toggle()
        self.bike.acceleration = 35
        self.bike.decrease_acceleration()
        self.assertEqual(self.bike.get_acceleration(), 32)

    def test_decrease_acceleration_by_2_from_gear_2(self):
        self.bike.power_toggle()
        self.bike.acceleration = 25
        self.bike.decrease_acceleration()
