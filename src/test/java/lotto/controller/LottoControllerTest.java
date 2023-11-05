package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoControllerTest {

    @Test
    @DisplayName("당첨 번호와 보너스 번호의 중복을 검증한다.")
    void validateDuplicatedNumber_throwException() {
        /**
         * given : 당첨 번호와 보너스 번호가 주어진다.
         * when : 당첨 번호와 보너스 번호의 중복을 검증한다.
         * then : IllegalArgumentException 예외가 발생한다.
         */
        List<Integer> winningNums = List.of(1, 2, 3, 4, 5, 6);
        int bonusNum = 6;

        assertThatThrownBy(() -> validateDuplicatedNumber(winningNums, bonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void validateDuplicatedNumber(List<Integer> winningNums, int bonusNum) {
        if (winningNums.contains(bonusNum)) {
            throw new IllegalArgumentException();
        }
    }
}