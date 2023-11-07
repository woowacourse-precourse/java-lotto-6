package lotto.domain.number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RanNumbersTest {
    private RanNumbers ranNumbers;

    @BeforeEach
    void setUp() {
        ranNumbers = new RanNumbers();
    }

    @DisplayName("랜덤 숫자 리스트의 크기가 6개 인지 확인")
    @Test
    void createLottoNumbers_랜덤_숫자_크기_6_확인() {

        for (int i = 0; i < 1000; i++) {
            // given
            int size = RanNumbers.createLottoNumbers().size();

            // than
            assertThat(size).isEqualTo(6);
        }
    }

    @DisplayName("랜덤 숫자 리스트의 의 숫자의 범위가 1~45인지 확인")
    @Test
    void createLottoNumbers_랜덤_숫자_범위_검증() {

        for (int i = 0; i < 1000; i++) {
            // given
            List<Integer> numbers = RanNumbers.createLottoNumbers();

            // than
            assertThat(numbers)
                    .allMatch((value) -> isRange(value));
        }
    }

    private boolean isRange(Integer value) {
        if (value >= 1 && value <= 45) {
            return true;
        }
        return false;
    }
}