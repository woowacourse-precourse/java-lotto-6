package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusTest {
    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아니면 예외가 발생한다")
    @Test
    void createBonusByOutOfRangeNumber() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);
        int invalidBonusNumber = 50;
        assertThatThrownBy(() -> new Bonus(invalidBonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호와 중복이면 예외가 발생한다")
    @Test
    void createBonusByDuplicatedNumber() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);
        int invalidBonusNumber = 4;
        assertThatThrownBy(() -> new Bonus(invalidBonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
