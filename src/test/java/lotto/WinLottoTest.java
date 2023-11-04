package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class WinLottoTest {

    @Test
    void changeNumbersTest() {

    }

    @Test
    void validateSizeTest() {

        assertThatThrownBy(() -> new WinLotto("1,2,3,4,5,6,7", "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNumTest() {

        assertThatThrownBy(() -> new WinLotto("1,2,3,4,a,6", "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateRangeTest() {

        assertThatThrownBy(() -> new WinLotto("0,2,3,4,5,6", "1"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new WinLotto("1,2,3,4,46,6", "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateDuplicateTest() {

        assertThatThrownBy(() -> new WinLotto("1,2,3,4,5,4", "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNumTest() {

        assertThatThrownBy(() -> new WinLotto("1,2,3,4,5,6", "a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusSpaceTest() {

        assertThatThrownBy(() -> new WinLotto("1,2,3,4,5,6", " "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNullTest() {

        assertThatThrownBy(() -> new WinLotto("1,2,3,4,5,6", ""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
