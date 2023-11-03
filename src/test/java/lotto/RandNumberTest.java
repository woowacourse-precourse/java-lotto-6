package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.controller.RandNumber.makeBonusNumber;
import static lotto.controller.RandNumber.makeRandNumber;

public class RandNumberTest {
    @DisplayName("랜덤 넘버 6개 뽑기")
    @Test
    void createRandomNumberTest() {
        List<Integer> numbers =makeRandNumber();
        Assertions.assertThat(numbers.size()).isEqualTo(6);
    }

    @DisplayName("보너스 넘버 1개 뽑기")
    @Test
    void createRandomBonusNumberTest() {
        List<Integer> bonusNumber = makeBonusNumber();
        Assertions.assertThat(bonusNumber.size()).isEqualTo(1);
    }

}
