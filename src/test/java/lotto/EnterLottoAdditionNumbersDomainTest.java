package lotto;

import lotto.domain.EnterLottoWinningNumbersDomain;
import lotto.domain.validation.LottoAdditionNumberValidation;
import lotto.domain.validation.LottoWinningNumberValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EnterLottoAdditionNumbersDomainTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static EnterLottoWinningNumbersDomain enterLottoWinningNumbersDomain;
    List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    private LottoAdditionNumberValidation lottoAdditionNumberValidation = new LottoAdditionNumberValidation();
    private EnterLottoAdditionNumbersDomainTest() {
        enterLottoWinningNumbersDomain = new EnterLottoWinningNumbersDomain();
    }

    @DisplayName("보너스 번호가 숫자로 변환할 수 없다면 에러가 발생한다.")
    @Test
    void createAdditionNumberConvertToInteger() {
        String invalidAdditionNumber = "1,3";
        assertThatThrownBy(() -> lottoAdditionNumberValidation.additionLottoWinningNumberValidation(invalidAdditionNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호가 1보다 작다면 에러가 발생한다.")
    @Test
    void createAdditionNumberUnderMin() {
        String invalidAdditionNumber = "-10";
        assertThatThrownBy(() -> lottoAdditionNumberValidation.additionLottoWinningNumberValidation(invalidAdditionNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호가 45보다 크다면 에러가 발생한다.")
    @Test
    void createAdditionNumberOverMax() {
        String invalidAdditionNumber = "66";
        assertThatThrownBy(() -> lottoAdditionNumberValidation.additionLottoWinningNumberValidation(invalidAdditionNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호가 당첨번호와 중복된다면 오류가 발생한다.")
    @Test
    void createAdditionNumberDuplicateInWinningNumbers() {

        String invalidAdditionNumber = "6";
        LottoAdditionNumberValidation lottoAdditionNumberValidation = new LottoAdditionNumberValidation();
        assertThatThrownBy(() -> lottoAdditionNumberValidation.additionLottoWinningNumberValidation(invalidAdditionNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
