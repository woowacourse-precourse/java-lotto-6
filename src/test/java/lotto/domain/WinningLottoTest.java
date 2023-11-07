package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningLottoTest {

    @DisplayName("당첨번호와 보너스번호가 중복이면 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    void 당첨번호와_보너스번호가_중복이면_예외처리_테스트(int bonusNumber) {
        List<Integer> winningLottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningLotto(winningLottoNumbers, bonusNumber)).isInstanceOf(
                IllegalArgumentException.class);
    }

}
