package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class BonusNumberTest {

    @ParameterizedTest
    @DisplayName("보너스 번호가 1부터 45사이의 숫자가 아니라면 예외 발생")
    @ValueSource(ints = {66})
    void bonusNumberOutOfRange(int bonusNumber) {
        Assertions.assertThatThrownBy(() -> new BonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "로또 번호 : {1, 2, 3, 4, 5, 6}, 보너스 번호 : {1}")
    @DisplayName("보너스 번호가 당첨 로또 번호에 포함된다면 예외 발생")
    void bonusNumberContains(List<Integer> lottoNumber, int bonus) {
        Lotto lotto = new Lotto(lottoNumber);
        BonusNumber bonusNumber = new BonusNumber(bonus);

        Assertions.assertThatThrownBy(() -> bonusNumber.containsLotto(lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}