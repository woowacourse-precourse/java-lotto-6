package lotto.dto;

import lotto.exception.LottoGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @DisplayName("null값 입력시 예외가 발생")
    @Test
    void createBonusNumberByNull() {
        assertThatThrownBy(() -> BonusNumber.create(""))
                .isInstanceOf(LottoGameException.class);
    }

    @DisplayName("범위 밖 정수값 입력 시 예외 발생")
    @Test
    void createBonusNumberOverRange() {
        assertThatThrownBy(() -> BonusNumber.create("46"))
                .isInstanceOf(LottoGameException.class);
    }

    @DisplayName("정수가 아닌 값 입력 시 예외 발생")
    @Test
    void createNotInteger(){
        assertThatThrownBy(() -> BonusNumber.create("정수가 아님"))
                .isInstanceOf(LottoGameException.class);
    }
}
