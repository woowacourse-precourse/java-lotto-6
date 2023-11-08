package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {

    @DisplayName("값이 유효하면 객체를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {7, 10, 23, 32, 35, 37, 44, 45})
    void should_createBonusNumber_When_Valid(int value) {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(value, winningNumbers);
        assertThat(bonusNumber.getValue()).isEqualTo(value);
    }

    @DisplayName("보너스번호가 당첨번호와 중복될시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void should_ThrowExceptionWhenDuplicatedWithWinningNumber(int value) {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new BonusNumber(value, winningNumbers))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining("[ERROR] 보너스번호는 당첨번호와 중복될 수 없습니다");
    }

    @DisplayName("보너스번호가 범위 이외의 수일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 49, 50, 100, 1000})
    void should_ThrowExceptionWhenBonusNumberIsOutOfRange(int value) {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new BonusNumber(value, winningNumbers))
                .isInstanceOf(LottoException.class).hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

}
