package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @Test
    @DisplayName("보너스 번호가 당첨 번호에 포함되면 예외를 발생시킨다.")
    void bonusNumberInWinningNumbers() {
        Assertions.assertThatThrownBy(() -> {
                    new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 6);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }


}