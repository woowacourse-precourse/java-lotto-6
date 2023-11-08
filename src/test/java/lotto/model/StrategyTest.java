package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StrategyTest {
    private List<Integer> possibleNumbers;

    @BeforeEach
    private void init() {
        possibleNumbers = new ArrayList<>();
        for (int i = LottoNumber.MIN; i <= LottoNumber.MAX; i++) {
            possibleNumbers.add(i);
        }
    }

    @Test
    @DisplayName("1~45의 숫자 중 총 6개의 랜덤한 값이 추출된다")
    void create() {
        List<Integer> numbers = Strategy.generateLotto();
        Assertions.assertAll(
                () -> assertThat(possibleNumbers.containsAll(numbers)).isTrue(),
                () -> assertThat(numbers.size()).isEqualTo(Lotto.SIZE)
        );
    }
}