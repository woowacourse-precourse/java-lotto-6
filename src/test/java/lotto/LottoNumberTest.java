package lotto;

import lotto.Domain.LottoNumber;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @DisplayName("로또 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        AssertionsForClassTypes.assertThatThrownBy(() -> new LottoNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 빈칸이면 예외가 발생한다.")
    @Test
    void lottoIsEmpty() {
        Assertions.assertThatThrownBy(() -> new LottoNumber(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1 ~45 사이의 숫자가 아니라면 예외가 발생한다.")
    @Test
    void lottoIsBoundary() {
        Assertions.assertThatThrownBy(() -> new LottoNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
