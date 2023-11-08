package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;
import lotto.domain.LottoWinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoWinningNumbersInputConstantServiceTest {

    @Nested
    @DisplayName("LottoWinningNumbersService의 createLottoWinningNumbers 기능 테스트")
    class createLottoWinningNumbersTestInputConstant {

        @Test
        @DisplayName("createLottoWinningNumbers를 사용하여 LottoWinningNumbers 객체에 당첨 번호가 올바르게 저장 되는지 테스트")
        void testWinningNumbersStorageInLottoWinningNumbers() {
            LottoWinningNumbersService winningNumbersService = new LottoWinningNumbersService();
            String winningNumbers = "1,2,3,4,5,6";
            String bonusNumber = "7";
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

            LottoWinningNumbers lottoWinningNumbers = winningNumbersService.createLottoWinningNumbers(winningNumbers,
                    bonusNumber);

            assertIterableEquals(lottoWinningNumbers.getWinningNumbers().getNumbers(), numbers);
        }

        @Test
        @DisplayName("createLottoWinningNumbers를 사용하여 LottoWinningNumbers 객체에 보너스 번호가 올바르게 저장 되는지 테스트")
        void testBonusNumberStorageInLottoWinningNumbers() {
            LottoWinningNumbersService winningNumbersService = new LottoWinningNumbersService();
            String winningNumbers = "1,2,3,4,5,6";
            String bonusNumber = "7";
            int number = Integer.parseInt(bonusNumber);

            LottoWinningNumbers lottoWinningNumbers = winningNumbersService.createLottoWinningNumbers(winningNumbers,
                    bonusNumber);

            assertThat(lottoWinningNumbers.getBonusNumber().getNumber()).isEqualTo(number);
        }
    }
}