package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import lotto.config.LottoConfig;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatchCountCheckerTest {
    HashMap<Integer, Lotto> lottoNumbers = new HashMap<>() {{
        put(0, new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        put(1, new Lotto(List.of(45, 44, 43, 42, 41, 40)));
        put(2, new Lotto(List.of(1, 2, 3, 4, 5, 40)));
    }};
    WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
    BonusNumber bonusNumber = new BonusNumber(winningNumber, 40);
    MatchCountChecker matchCountChecker = new MatchCountChecker();

    @DisplayName("로또별 당첨 번호, 보너스 번호 일치 개수 확인")
    @Test
    public void checkWinningAndBonusNumberByLotto() {
        HashMap<Integer, List<Integer>> result = new HashMap<>(){{
            put(0, List.of(6, 0));
            put(1, List.of(0, 1));
            put(2, List.of(5, 1));
        }};

        assertThat(matchCountChecker.compareLottoToNumber(lottoNumbers, winningNumber, bonusNumber))
                .isEqualTo(result);

    }

    @DisplayName("상금 액수별 로또 개수 확인")
    @Test
    public void checkLottoByReward() {
        HashMap<String, Integer> result = new HashMap<>(){{
           put(LottoConfig.FIRST_PRIZE_REWARD, 1);
           put(LottoConfig.SECOND_PRIZE_REWARD, 1);
           put(LottoConfig.THIRD_PRIZE_REWARD, 0);
           put(LottoConfig.FOURTH_PRIZE_REWARD, 0);
           put(LottoConfig.FIFTH_PRIZE_REWARD, 0);
        }};

        HashMap<Integer, List<Integer>> matchNumberByLotto =
                matchCountChecker.compareLottoToNumber(lottoNumbers, winningNumber, bonusNumber);

        assertThat(matchCountChecker.countLottoByPrize(matchNumberByLotto)).isEqualTo(result);
    }
}