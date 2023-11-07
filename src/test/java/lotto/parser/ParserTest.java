package lotto.parser;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParserTest {
    @DisplayName("정수를 입력하지 않으면 예외가 발생한다.")
    @Test
    void inputPurchaseAmount() {
        assertThatThrownBy(() -> Parser.parsePurchaseAmount("4.1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해주세요.");
    }

    @DisplayName("1~45 사이 정수 6개를 입력하지 않으면 예외가 발생한다.")
    @Test
    void inputWinningNumbers() {
        assertThatThrownBy(() -> Parser.parseWinningNumbers("1, 2, 3, 4, 3 5, 6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해주세요.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void inputBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> Parser.parseBonusNumber("3", lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 당첨 번호와 다른 숫자여야 합니다.");
    }
}
