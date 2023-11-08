package lotto.dto;

import lotto.domain.Lotto;
import lotto.exception.LottoGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {
    @DisplayName("정답 번호의 개수가 6개가 넘어가면 예외 발생.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> WinningNumber.create("1,2,3,4,5,6,7"))
                .isInstanceOf(LottoGameException.class);
    }

    @DisplayName("정답 번호에 중복된 숫자가 있으면 예외 발생.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> WinningNumber.create("1,1,3,4,5,6"))
                .isInstanceOf(LottoGameException.class);
    }

    @DisplayName("null값 입력시 예외 발생")
    @Test
    void createBonusNumberByNull() {
        assertThatThrownBy(() -> WinningNumber.create(""))
                .isInstanceOf(LottoGameException.class);
    }

    @DisplayName("범위 밖 정수값 입력 시 예외 발생")
    @Test
    void createBonusNumberOverRange() {
        assertThatThrownBy(() -> BonusNumber.create("46"))
                .isInstanceOf(LottoGameException.class);
    }
}
