package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {
    @DisplayName("보너스 넘버를 가져오는 로직 테스트")
    @Test
    void getBonusNumber() {
        List<Integer> lottoNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningLotto winningLotto = WinningLotto.create(lottoNumber, bonusNumber);

        assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);
    }
}