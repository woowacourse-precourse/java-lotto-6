package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void 숫자가_아닌_수_입력() {
        String money = "11000d";
        assertThatThrownBy(() -> new Customer(money)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 나누어떨어지지않는수() {
        String money = "1100";
        assertThatThrownBy(() -> new Customer(money)).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 음수() {
        String money = "-10000";
        assertThatThrownBy(() -> new Customer(money)).isInstanceOf(IllegalArgumentException.class);
    }


}