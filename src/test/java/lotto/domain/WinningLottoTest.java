package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @DisplayName("[Exception] 보너스 번호가 로또 번호와 중복되면 예외가 발생한다..")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 6})
    void budgetTest(int bonusNumber) {
        Lotto winningNumber = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThatThrownBy(()-> new WinningLotto(winningNumber,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
