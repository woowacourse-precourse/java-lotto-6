package lotto.domain;

import static lotto.domain.Numbers.createNumbersList;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("WinningLotto 클래스")
class WinningLottoTest {

    @DisplayName("당첨 번호와 보너스 번호가 중복된다면 예외를 발생한다.")
    @Test
    void createWinningLottoByDuplicatedBonusNumber() {
        List<Number> winningNumbers = Numbers.createNumbersList(List.of(1, 2, 3, 4, 5, 6));
        Number bonusNumber = new Number(6);
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }
}