package lotto.domain.entity.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.domain.config.ValidatorConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningLottoTest {
    private static final String ERROR_MESSAGE = ValidatorConfig.ERROR_MESSAGE.getMessage();
    private static final List<Integer> NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6);

    @DisplayName("보너스 번호 예외 상황")
    @ParameterizedTest
    @CsvSource({
            "0, 보너스 번호는 1부터 45 사이의 숫자여야 합니다.",
            "46,보너스 번호는 1부터 45 사이의 숫자여야 합니다.",
            "1, 보너스 번호가 다른 당첨 번호와 중복됩니다."
    })
    void createWinningLotto_예외_처리(int bonusNumber, String expectedMessage) {
        assertThatThrownBy(() -> new WinningLotto(NUMBERS, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + expectedMessage);
    }

    @DisplayName("보너스 번호 받아오기")
    @Test
    void getBonusNumber_보너스_번호는_7() {
        final Integer bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(NUMBERS, bonusNumber);

        Integer result = winningLotto.getBonusNumber();

        assertThat(result).isEqualTo(bonusNumber);
    }
}