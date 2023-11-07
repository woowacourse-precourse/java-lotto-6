package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.utils.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberTest {
    @Test
    @DisplayName("당첨 번호, 보너스 번호 생성 성공")
    void createWinningNumber() {
        // given
        String win = "1,2,3,4,5,6";
        String bonus = "7";

        // when
        WinningNumber winningNumber = new WinningNumber(win, bonus);

        // then
        assertThat(winningNumber).isNotNull();
    }

    /*
    당첨 번호 예외 테스트
     */
    @ParameterizedTest
    @ValueSource(strings = {"1.2.3.4.5.6", "1-2-3-4-5-6"})
    @DisplayName("당첨 번호를 쉼표(,)로 구분하지 않으면 에러가 발생한다.")
    void createWinningNumberByWrongDelimiter(String win) {
        // given
        String bonus = "7";

        // when // then
        assertThatThrownBy(() -> new WinningNumber(win, bonus))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_SPLIT_DELIMITER);
    }

    @Test
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void createWinningNumberByOverSize() {
        // given
        String win = "1,2,3,4,5,6,7";
        String bonus = "8";

        // when // then
        assertThatThrownBy(() -> new WinningNumber(win, bonus))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_NUMBER_SIZE);
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void createWinningNumberByDuplicatedNumber() {
        // given
        String win = "1,2,3,4,5,5";
        String bonus = "7";

        // when // then
        assertThatThrownBy(() -> new WinningNumber(win, bonus))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.DUPLICATED_NUMBER);
    }

    @Test
    @DisplayName("당첨 번호가 1~45 사이의 숫자가 아니라면 예외가 발생한다.")
    void createWinningNumberByWrongRangeNumber() {
        // given
        String win = "0,46,3,4,5,6";
        String bonus = "7";

        // when // then
        assertThatThrownBy(() -> new WinningNumber(win, bonus))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_NUMBER_RANGE);
    }

    /*
    보너스 번호 예외 테스트
     */
    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아니라면 예외가 발생한다.")
    void createBonusNumberByWrongRangeNumber(String bonus) {
        // given
        String win = "1,2,3,4,5,6";

        // when // then
        assertThatThrownBy(() -> new WinningNumber(win, bonus))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_NUMBER_RANGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "6"})
    @DisplayName("보너스 번호가 당첨 번호와 중복되는 숫자라면 예외가 발생한다.")
    void createBonusNumberByDuplicatedNumber(String bonus) {
        // given
        String win = "1,2,3,4,5,6";

        // when // then
        assertThatThrownBy(() -> new WinningNumber(win, bonus))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.DUPLICATED_BONUS_NUMBER);
    }

    /*
    당첨 계산 기능
     */
    @Test
    @DisplayName("로또 번호와 당첨 번호가 몇 개 일치하는지 계산한다.")
    public void countWinningNumber() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        String win = "1,3,6,8,15,45";
        String bonus = "5";
        WinningNumber winningNumber = new WinningNumber(win, bonus);

        // when
        int winningCount = winningNumber.countWinningNumber(lottoNumbers);

        // then
        assertThat(winningCount).isEqualTo(3);
    }

    @Test
    @DisplayName("로또 번호에 보너스 번호가 포함되어 있는지 확인한다.")
    public void checkBonusNumber() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        String win = "1,3,6,8,15,45";
        String bonus = "5";
        WinningNumber winningNumber = new WinningNumber(win, bonus);

        // when
        boolean checkBonus = winningNumber.checkBonusNumber(lottoNumbers);

        // then
        assertThat(checkBonus).isTrue();
    }
}