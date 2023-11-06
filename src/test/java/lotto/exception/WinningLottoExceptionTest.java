package lotto.exception;

import java.util.List;
import lotto.domain.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoExceptionTest {

    @DisplayName("당첨 번호 로또 중 중복되는 숫자가 있는 경우 예외처리")
    @Test
    void lottoNumberDuplicationTest() {

        Assertions.assertThatThrownBy(
                () -> new WinningLotto(List.of("1", "1", "3", "4", "5", "6"), "10"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("당첨 번호들 중에 보너스 번호와 동일한 숫자가 있는 경우 예외처리")
    @Test
    void bonusNumberDuplicationTest() {

        Assertions.assertThatThrownBy(
                          () -> new WinningLotto(List.of("1", "2", "3", "4", "5", "6"), "1"))
                  .isInstanceOf(IllegalArgumentException.class);


    }

    @DisplayName("로또 번호들의 갯수가 6개가 아닌 경우 경우 예외처리")
    @Test
    void wrongLottoNumbersLengthExceptionTest() {

        Assertions.assertThatThrownBy(
                          () -> new WinningLotto(List.of("1", "2", "3", "4", "5", "6", "8"), "9"))
                  .isInstanceOf(IllegalArgumentException.class);
    }


}
