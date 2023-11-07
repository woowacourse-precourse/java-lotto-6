package lotto;

import lotto.model.dto.Lotto;
import lotto.model.dto.LottoBonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBonusTest {

    private static LottoBonus Lotto;
    @DisplayName("로또 번호의 개수가 1개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1)))
          .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
          .isInstanceOf(IllegalArgumentException.class);
    }

}
