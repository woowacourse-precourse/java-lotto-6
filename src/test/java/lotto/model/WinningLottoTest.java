package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @DisplayName("보너스 넘버가 로또 번호에 중복된 숫자면 예외가 발생한다.")
    @Test
    void createBonusNumberWithContainsInNumbers() {
        List<Integer> lottoNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        assertThatThrownBy(() -> WinningLotto.create(lottoNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 넘버가 범위 안의 숫자가 아니면 예외가 발생한다..")
    @Test
    void createBonusNumberNotInRange() {
        List<Integer> lottoNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 47;

        assertThatThrownBy(() -> WinningLotto.create(lottoNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 넘버를 가져오는 로직 테스트")
    @Test
    void getBonusNumber() {
        List<Integer> lottoNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningLotto winningLotto = WinningLotto.create(lottoNumber, bonusNumber);

        assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);
    }
}