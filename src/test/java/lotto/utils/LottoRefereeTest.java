package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.global.constant.LottoConstant;
import lotto.global.constant.LottoRankAndPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoRefereeTest {

    LottoReferee lottoReferee = new LottoReferee();

    @DisplayName("로또 번호 일치하는 개수 반환하는 함수 테스트")
    @Test
    public void testDetermineLottoRank() {
        // 테스트할 로또 및 당첨 로또 번호를 생성합니다.
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Lotto lotto = new Lotto(lottoNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        LottoRankAndPrize result = lottoReferee.determineLottoRank(lotto, winningLotto);

        int expectedPrize = LottoConstant.SECOND_PRIZE; // 예시로 1등 상금을 가정합니다.

        assertEquals(expectedPrize, result.getPrize());
    }

    @Test
    public void testIsBonusMatch() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        int bonusNumber = 7; // 보너스 번호

        boolean result = lottoReferee.isBonusMatch(numbers, bonusNumber);

        assertTrue(result);
    }
}
