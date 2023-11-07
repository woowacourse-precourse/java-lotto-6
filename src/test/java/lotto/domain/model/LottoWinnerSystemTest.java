package lotto.domain.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoWinnerSystemTest {

    private final int WINNER_NUMBER_COUNT = 6;
    private final int BONUS_NUMBER_COUNT = 1;
    LottoWinnerSystem lottoWinnerSystem = new LottoWinnerSystem();

    @Test
    void 발행번호_당첨번호_비교() {
        List<Integer> compareLotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winNumber = new ArrayList<>(List.of(1, 2, 3, 7, 8, 9));
        int matchCount = lottoWinnerSystem.getMatchNumberCount(compareLotto, winNumber);
        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    void 발행번호_보너스번호_비교() {
        List<Integer> compareLotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> bonusNumber = new ArrayList<>(List.of(13));
        boolean isContainBonus = lottoWinnerSystem.isContainBonusNumber(compareLotto, bonusNumber);
        assertThat(isContainBonus).isEqualTo(false);
    }


    @Test
    void 당첨번호_6개_아닐경우() {
        List<Integer> winNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        assertThrows(IllegalArgumentException.class, () -> {
            lottoWinnerSystem.isValidLength(winNumber, WINNER_NUMBER_COUNT);
        });
    }

    @Test
    void 당첨번호_중복번호_존재할경우() {
        List<Integer> winNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));

        assertThrows(IllegalArgumentException.class, () -> {
            lottoWinnerSystem.isDistinct(winNumber);
        });
    }

    @Test
    void 당첨번호_정상범위_아닐경우() {
        List<Integer> winNumber = new ArrayList<>(List.of(0, 2, 3, 4, 5, 6));

        assertThrows(IllegalArgumentException.class, () -> {
            lottoWinnerSystem.isValidRange(winNumber);
        });
    }


    @Test
    void 보너스번호_1개_아닐경우() {
        List<Integer> bonusNumber = new ArrayList<>(List.of(13, 14));

        assertThrows(IllegalArgumentException.class, () -> {
            lottoWinnerSystem.isValidLength(bonusNumber, BONUS_NUMBER_COUNT);
        });
    }

    @Test
    void 보너스번호_당첨번호와_중복되는경우() {
        List<Integer> winNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> bonusNumber = new ArrayList<>(List.of(3));

        assertThrows(IllegalArgumentException.class, () -> {
            lottoWinnerSystem.isContainWinNumbers(winNumber, bonusNumber);
        });
    }

    @Test
    void 보너스번호_정상범위_아닐경우() {
        List<Integer> bonusNumber = new ArrayList<>(List.of(-1));

        assertThrows(IllegalArgumentException.class, () -> {
            lottoWinnerSystem.isValidRange(bonusNumber);
        });
    }
}