package lotto.v3.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoWinningNumberTest {
    @Test
    @DisplayName("당첨 번호가 올바르게 생성되는지 테스트")
    void createLottoWinningNumberSuccessfully() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(winningNumbers);

        assertThat(lottoWinningNumber.getNumbers())
                .hasSize(6)
                .isEqualTo(new HashSet<>(winningNumbers));
    }

    @Test
    @DisplayName("당첨 번호가 null이면 예외를 발생시킨다")
    void throwExceptionIfNumbersIsNull() {
        assertThatThrownBy(() -> new LottoWinningNumber(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호를 입력해야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호가 비어있으면 예외를 발생시킨다")
    void throwExceptionIfNumbersIsEmpty() {
        assertThatThrownBy(() -> new LottoWinningNumber(Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호를 입력해야 합니다.");
    }

}