package lotto;


import lotto.Model.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @DisplayName("당첨번호가 숫자와 쉼표로만 구성되어 있는지 테스트")
    @Test
    void validateWinningLotto() {
        String invalidInput = "1,2,3,4,5, 30";

        Assertions.assertThatThrownBy(() -> new WinningLotto(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자와 쉼표로만 당첨 번호를 입력해 주세요.");


    }
}
