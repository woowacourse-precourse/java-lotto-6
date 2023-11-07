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


}