package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.enums.ExceptionMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoResultManagerTest {
    LottoResultManager lottoResultManager;

    @BeforeEach
    void beforeEach() {
        lottoResultManager = new LottoResultManager();
    }

    @Test
    @DisplayName("입력받은 당첨 번호 유효성 체크 후 winningLotto 필드 할당")
    void setWinningLottoTest() {
        String winningNumbers = "1,5,10,15,20,25";
        List<Integer> expectedWinningNumbers = List.of(1, 5, 10, 15, 20, 25);
        lottoResultManager.setWinningLotto(winningNumbers);
        assertThat(lottoResultManager.getWinningLotto().getNumbers().equals(expectedWinningNumbers)).isEqualTo(true);
    }

    @ParameterizedTest(name = "{index}: {1}")
    @CsvSource(value = {"1,46,5,10,15,20:1~45범위 밖 숫자 입력", "1 5 10 15 20 25:(,)을 기준으로 구분하지 않은 형식 입력",
            "1,5,10,15:6개의 당첨 번호가 아닌 입력", "1,1,5,5,10,10:같은 숫자 중복 입력"}, delimiter = ':')
    void setWinningLottoTestByInvalidWinningNumbers(String input, String testName) {
        assertThatThrownBy(() -> lottoResultManager.setWinningLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessages.INVALID_LOTTO_NUMBERS.getMessage());
    }
}