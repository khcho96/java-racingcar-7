package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @Test
    void carHasName() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void nameTooLongThrows() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void moveIfRandomAtLeast4_increasePosition() {
        Car car = new Car("pobi");
        car.moveIf(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
