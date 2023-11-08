package lotto;

import lotto.domain.EnterLottoWinningNumbersDomain;
import lotto.domain.validation.LottoWinningNumberValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EnterLottoWinningNumbersDomainTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private LottoWinningNumberValidation lottoWinningNumberValidation = new LottoWinningNumberValidation();
    private static EnterLottoWinningNumbersDomain enterLottoWinningNumbersDomain;
    private EnterLottoWinningNumbersDomainTest() {
        enterLottoWinningNumbersDomain = new EnterLottoWinningNumbersDomain();
    }

    @DisplayName("당첨 번호의 개수가 6개보다 낮으면 에러가 발생한다.")
    @Test
    void createWinningNumbersUnderSize() {
        String invalidWinningNumbers = "1,2,3,4,5";
        assertThatThrownBy(() -> lottoWinningNumberValidation.winningNumberValidation(invalidWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("당첨 번호의 개수가 6개보다 크다면 에러가 발생한다.")
    @Test
    void createWinningNumbersOverSize() {
        String invalidWinningNumbers = "1,2,3,4,5,6,7";
        assertThatThrownBy(() -> lottoWinningNumberValidation.winningNumberValidation(invalidWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("당첨 번호가 ','로 구분이 안된다면 오류가 발생한다.")
    @Test
    void createWinningNumbersSeparatorByComma() {
        String invalidWinningNumbers = "1.2.3.4.5.6";
        assertThatThrownBy(() -> lottoWinningNumberValidation.winningNumberValidation(invalidWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("당첨 번호가 1~45숫자 사이에 존재 하지 않는다면 오류가 발생한다.")
    @Test
    void createWinningNumbersIsRange() {
        String invalidWinningNumbers = "-1,2,66,89,100,155";
        assertThatThrownBy(() -> lottoWinningNumberValidation.winningNumberValidation(invalidWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("당첨 번호 중 중복된 숫자가 존재한다면 오류가 발생한다.")
    @Test
    void createWinningNumbersIsDuplicate() {
        String invalidWinningNumbers = "1,2,3,4,5,5";
        assertThatThrownBy(() -> lottoWinningNumberValidation.winningNumberValidation(invalidWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
