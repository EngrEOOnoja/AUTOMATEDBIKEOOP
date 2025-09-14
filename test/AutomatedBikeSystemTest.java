import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AutomatedBikeSystemTest {

    private AutomatedBikeSystem bike;

    @BeforeEach
    public void setUp() {
        bike = new AutomatedBikeSystem();
    }

    @Test
    void bikeIsOffByDefault() {
        assertFalse(bike.isBikeOn());
    }

    @Test
    void togglePowerTurnsBikeOn() {
        bike.togglePower();
        assertTrue(bike.isBikeOn());
    }

    @Test
    void togglePowerTwiceTurnsBikeOff() {
        bike.togglePower();
        bike.togglePower();
        assertFalse(bike.isBikeOn());
    }

    @Test
    void togglePowerThriceTurnsBikeOnAgain() {
        for (int i = 0; i < 3; i++) bike.togglePower();
        assertTrue(bike.isBikeOn());
    }

    @Test
    void powerStatusIsIndependentOfAcceleration() {
        bike.increaseAcceleration();
        assertEquals(0, bike.getAcceleration());
    }

    @Test
    void togglePowerOnThenCheckAccelerationIsZero() {
        bike.togglePower();
        assertEquals(0, bike.getAcceleration());
    }

    @Test
    void togglePowerOffDoesNotResetAcceleration() {
        bike.togglePower();
        for (int i = 0; i < 5; i++) bike.increaseAcceleration();
        bike.togglePower(); // turn off
        assertEquals(5, bike.getAcceleration());
    }

    @Test
    void initialAccelerationIsZero() {
        assertEquals(0, bike.getAcceleration());
    }

    @Test
    void increaseFromGear1() {
        bike.togglePower();
        bike.increaseAcceleration();
        assertEquals(1, bike.getAcceleration());
    }

    @Test
    void increaseToGear2() {
        bike.togglePower();
        for (int i = 0; i < 21; i++) bike.increaseAcceleration();
        assertEquals(21, bike.getAcceleration());
    }

    @Test
    void increaseWithinGear2() {
        bike.togglePower();
        for (int i = 0; i < 22; i++) bike.increaseAcceleration();
        assertEquals(23, bike.getAcceleration());
    }

    @Test
    void increaseToGear3() {
        bike.togglePower();
        for (int i = 0; i < 26; i++) bike.increaseAcceleration();
        assertTrue(bike.getAcceleration() >= 31);
    }

    @Test
    void increaseAboveMaxStopsAt70() {
        bike.togglePower();
        for (int i = 0; i < 100; i++) bike.increaseAcceleration();
        assertEquals(70, bike.getAcceleration());
    }

    @Test
    void decreaseFromGear1() {
        bike.togglePower();
        for (int i = 0; i < 10; i++) bike.increaseAcceleration(); // 10
        bike.decreaseAcceleration(); // -1
        assertEquals(9, bike.getAcceleration());
    }

    @Test
    void cannotGoBelowZero() {
        bike.togglePower();
        bike.decreaseAcceleration();
        bike.decreaseAcceleration();
        assertEquals(0, bike.getAcceleration());
    }

    @Test
    void decreaseDownToZero() {
        bike.togglePower();
        for (int i = 0; i < 10; i++) bike.increaseAcceleration();
        for (int i = 0; i < 10; i++) bike.decreaseAcceleration();
        assertEquals(0, bike.getAcceleration());
    }



    @Test
    void decreaseFromMax70() {
        bike.togglePower();
        for (int i = 0; i < 100; i++) bike.increaseAcceleration();
        bike.decreaseAcceleration(); // -4
        assertEquals(66, bike.getAcceleration());
    }

    @Test
    void decreaseFromEdgeCaseGear2ToGear1() {
        bike.togglePower();
        for (int i = 0; i < 21; i++) bike.increaseAcceleration(); // 21 (Gear 2)
        bike.decreaseAcceleration(); // -2 → 19
        assertEquals(19, bike.getAcceleration());
    }

    @Test
    void accelerationDoesNotChangeWhenPowerIsOff() {
        for (int i = 0; i < 10; i++) bike.increaseAcceleration();
        assertEquals(0, bike.getAcceleration());
        bike.decreaseAcceleration();
        assertEquals(0, bike.getAcceleration());
    }
}
