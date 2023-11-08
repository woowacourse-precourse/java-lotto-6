package lotto.controller;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationTest {

    Validation validation = new Validation();

    @Test
    void purchaseAmountException_notNumber() {
        String input = "1,000";

        assertThatThrownBy(() -> validation.purchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다")
    @Test
    void purchaseAmountException_notMultipleOf1000() {
        String input = "3400";

        assertThatThrownBy(() -> validation.purchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void winNumberInput_notNumber() {
        List<String> input = new ArrayList<>(Arrays.asList("1", "2", "a", "b", "c", "d"));

        assertThatThrownBy(() -> validation.winNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void winNumberInput_under6() {
        List<String> input = new ArrayList<>(Arrays.asList("1", "2", "3"));

        assertThatThrownBy(() -> validation.winNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void winNumberInput_over6() {
        List<String> input = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7"));

        assertThatThrownBy(() -> validation.winNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void winNumberInput_duplicate() {
        List<String> input = new ArrayList<>(Arrays.asList("1", "1", "3", "4", "5", "6"));

        assertThatThrownBy(() -> validation.winNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
