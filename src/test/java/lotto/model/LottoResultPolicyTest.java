package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoResultPolicyTest {
    private LottoResultPolicy lottoRankPolicy = new LottoResultPolicy();

    @DisplayName("로또 결과를 제대로 검정하는지 테스트")
    @Test
    void calculateResultTest(){
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoRankPolicy.setWinningNumbers(List.of(1,2,3,4,10,11));
        lottoRankPolicy.setBonusNumber(20);
        // when
        LottoResult lottoResult = lottoRankPolicy.calculateResult(lotto);
        int winningCount = lottoResult.getWinningCount();
        boolean bonusMatch = lottoResult.isBonusMatch();
        // then
        assertEquals(4, winningCount);
        assertEquals(false, bonusMatch);
    }

    @DisplayName("당첨 번호의 개수가 6개를 넘으면 예외가 발생한다.")
    @Test
    void createOverWinningNumbers() {
        assertThatThrownBy(() -> lottoRankPolicy.setWinningNumbers(List.of(1,2,3,4,5,6,7)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_NUMBERS_COUNT_ERROR.getMessage());
    }

    @DisplayName("당첨 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void createLessWinningNumbers() {
        assertThatThrownBy(() -> lottoRankPolicy.setWinningNumbers(List.of(1,2,3,4,5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_NUMBERS_COUNT_ERROR.getMessage());
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> lottoRankPolicy.setWinningNumbers(List.of(1,2,3,4,5,5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.DUPLICATE_NUMBER_ERROR.getMessage());
    }

    @DisplayName("당첨 번호가 1부터 45 사이가 아니면 예외가 발생한다.")
    @Test
    void createExceedRangeWinningNumber() {
        assertThatThrownBy(() -> lottoRankPolicy.setWinningNumbers(List.of(1,2,3,4,5,55)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.EXCEED_LOTTO_RANGE_ERROR.getMessage());
    }

    @DisplayName("당첨 번호가 음수이면 예외가 발생한다.")
    @Test
    void createNegativeWinningNumber() {
        assertThatThrownBy(() -> lottoRankPolicy.setWinningNumbers(List.of(1,2,3,4,5,-6)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.EXCEED_LOTTO_RANGE_ERROR.getMessage());
    }

    @DisplayName("보너스 번호도 1부터 45 사이어야 한다.")
    @ParameterizedTest
    @CsvSource({"-1", "0", "50","100"})
    void createNegativeBonusNumber(int num){
        assertThatThrownBy(() -> lottoRankPolicy.setBonusNumber(num))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.EXCEED_LOTTO_RANGE_ERROR.getMessage());
    }

    @DisplayName("보너스 번호와 당첨 번호는 중복되면 안된다")
    @Test
    void createDuplicateBonusNumber() {
        // given
        lottoRankPolicy.setWinningNumbers(List.of(1,2,3,4,5,6));
        int bonusNumber = 1;

        // when, then
        assertThatThrownBy(() -> lottoRankPolicy.setBonusNumber(bonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.DUPLICATE_WINNING_NUMBER_ERROR.getMessage());
    }
}