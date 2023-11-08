package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinningNumbersTest {
    private List<Integer> lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("보너스 번호가 로또 번호랑 겹치면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new LottoWinningNumbers(lottoNumbers, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호와 보너스 번호는 중복될 수 없습니다.");
    }

    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createBonusNumberWithInvalidRange() {
        assertThatThrownBy(() -> new LottoWinningNumbers(lottoNumbers, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호도 1부터 45 사이의 숫자여야 합니다.");
    }
}
