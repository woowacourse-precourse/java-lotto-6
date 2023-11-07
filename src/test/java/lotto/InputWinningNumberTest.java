package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.InputWinningNumberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputWinningNumberTest {
    @DisplayName("당첨 로또 리스트 설정")
    @ParameterizedTest
    @ValueSource(strings = "1,2,3,4,5,6")
    void setWinningNumbers(String input) {
        InputWinningNumberService inputWinningNumberService = new InputWinningNumberService();

        Lotto lotto = inputWinningNumberService.setWinningNum(input);

        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("보너스 번호 설정")
    @ParameterizedTest
    @ValueSource(strings = "7")
    void setBonusNum(String input) {
        InputWinningNumberService inputWinningNumberService = new InputWinningNumberService();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        inputWinningNumberService.setBonusNum(lotto, input);

        assertThat(lotto.getBonusNum()).isEqualTo(7);
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
