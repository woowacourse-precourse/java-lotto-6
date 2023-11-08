package lotto;

import lotto.entity.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("당첨 번호를 잘 체크하는지 확인한다.")
    void checkLottoScoreCorrectly() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = Arrays.asList(4, 5, 6, 7, 8, 9);

        Lotto lotto = new Lotto(lottoNumbers);
        int score = lotto.checkLottoScore(winningNumbers);

        assertEquals(3, score);
    }

    @Test
    @DisplayName("보너스 번호가 로또 번호에 포함되어 있는지 확인한다.")
    void checkLottoBonusNumberCorrectly() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        Lotto lotto = new Lotto(lottoNumbers);
        assertFalse(lotto.checkLottoBonus(bonusNumber));

        bonusNumber = 1;
        assertTrue(lotto.checkLottoBonus(bonusNumber));
    }
}