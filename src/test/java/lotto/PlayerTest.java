package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.Model.Lotto;
import lotto.Model.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerTest {

    @DisplayName("보너스 숫자가 1 ~ 45의 범위인지 확인합니다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 49})
    void checkBonusProperRange(int target) {
        assertThatThrownBy(() -> new Player(new Lotto(List.of(1, 2, 3, 4, 5, 6)), target))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자가 6개의 로또 숫자와 중복되는지 확인합니다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 6})
    void checkBonusDuplicated(int target) {
        assertThatThrownBy(() -> new Player(new Lotto(List.of(1, 2, 3, 4, 5, 6)), target))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
