package lotto.domain.number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}