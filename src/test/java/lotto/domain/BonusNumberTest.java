package lotto.domain;

import static lotto.global.exception.ErrorMessage.DUPLICATED_NUMBER_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    private WinningNumbers winningNumbers;

    @BeforeEach
    public void setUp() {
        winningNumbers = WinningNumbers.from(Lotto.from(List.of(
                Number.valueOf(1),
                Number.valueOf(2),
                Number.valueOf(3),
                Number.valueOf(4),
                Number.valueOf(5),
                Number.valueOf(6)
        )));
    }

    @Test
    @DisplayName("올바른 보너스 번호를 입력하고 객체 생성에 성공한다.")
    public void 보너스_번호_입력으로_객체를_생성한다() {
        Number bonusNumber = Number.valueOf(7);

        BonusNumber result = BonusNumber.of(winningNumbers, bonusNumber);

        assertThat(result).isNotNull();
    }

    @Test
    @DisplayName("중복되는 보너스 번호의 입력으로 객체 생성에 실패한다.")
    public void 중복된_보너스_번호의_입력_시_예외를_반환한다() {
        Number bonusNumber = Number.valueOf(6);

        assertThatThrownBy(() -> BonusNumber.of(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_NUMBER_ERROR.getMessage());
    }

    @Test
    @DisplayName("리스트의 숫자에 보너스 번호가 포함된 경우 true를 반환한다")
    public void 보너스_포함_여부를_확인한다() {
        Number bonusNumber = Number.valueOf(7);
        BonusNumber bonus = BonusNumber.of(winningNumbers, bonusNumber);

        List<Number> numbers = Arrays.asList(Number.valueOf(7), Number.valueOf(8), Number.valueOf(9));

        assertThat(bonus.contains(numbers)).isTrue();
    }
}
