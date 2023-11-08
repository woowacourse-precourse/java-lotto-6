package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningNumbersTest {

    @Test
    @DisplayName("LottoWinningNumbers 에 저장된 당첨번호와 보너스 번호를 비교하여 해당 객체 생성을 검증하는 테스트")
    void testLottoWinningNumbersCreation() {
        int number = 7;
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.create(numbers, number);

        Lotto winningNumbers = lottoWinningNumbers.getWinningNumbers();
        int bonusNumber = lottoWinningNumbers.getBonusNumber().getNumber();

        assertAll(
                () -> assertThat(winningNumbers.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6),
                () -> assertThat(bonusNumber).isEqualTo(number)
        );
    }
}