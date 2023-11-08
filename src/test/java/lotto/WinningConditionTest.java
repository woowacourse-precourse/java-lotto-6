package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Buyer;
import lotto.model.Lotto;
import lotto.model.WinningCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.SystemData.*;
import static lotto.model.WinningCondition.RANK_5;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningConditionTest {
    @DisplayName("우승번호 일치 수와 보너스번호 일치 수에 따라 랭킹 없음을 반환한다.")
    @Test
    void check_winning_result_no_rank() {
        assertEquals(
                WinningCondition.NO_RANK,
                WinningCondition.valueOfLottoNumbers(0,0)
        );
        assertEquals(
                WinningCondition.NO_RANK,
                WinningCondition.valueOfLottoNumbers(0,1)
        );
        assertEquals(
                WinningCondition.NO_RANK,
                WinningCondition.valueOfLottoNumbers(1,0)
        );
        assertEquals(
                WinningCondition.NO_RANK,
                WinningCondition.valueOfLottoNumbers(1,1)
        );
        assertEquals(
                WinningCondition.NO_RANK,
                WinningCondition.valueOfLottoNumbers(2,0)
        );
        assertEquals(
                WinningCondition.NO_RANK,
                WinningCondition.valueOfLottoNumbers(2,1)
        );
    }

    @DisplayName("우승번호 일치 수와 보너스번호 일치 수에 따라 랭킹 5등을 반환한다.")
    @Test
    void check_winning_result_rank_5() {
        assertEquals(
                WinningCondition.RANK_5,
                WinningCondition.valueOfLottoNumbers(3,0)
        );
        assertEquals(
                WinningCondition.RANK_5,
                WinningCondition.valueOfLottoNumbers(3,1)
        );
    }

    @DisplayName("우승번호 일치 수와 보너스번호 일치 수에 따라 랭킹 4등을 반환한다.")
    @Test
    void check_winning_result_rank_4() {
        assertEquals(
                WinningCondition.RANK_4,
                WinningCondition.valueOfLottoNumbers(4,0)
        );
        assertEquals(
                WinningCondition.RANK_4,
                WinningCondition.valueOfLottoNumbers(4,1)
        );
    }

    @DisplayName("우승번호 일치 수와 보너스번호 일치 수에 따라 랭킹 3등을 반환한다.")
    @Test
    void check_winning_result_rank_3() {
        assertEquals(
                WinningCondition.RANK_3,
                WinningCondition.valueOfLottoNumbers(5,0)
        );
    }

    @DisplayName("우승번호 일치 수와 보너스번호 일치 수에 따라 랭킹 2등을 반환한다.")
    @Test
    void check_winning_result_rank_2() {
        assertEquals(
                WinningCondition.RANK_2,
                WinningCondition.valueOfLottoNumbers(5,1)
        );
    }

    @DisplayName("우승번호 일치 수와 보너스번호 일치 수에 따라 랭킹 1등을 반환한다.")
    @Test
    void check_winning_result_rank_1() {
        assertEquals(
                WinningCondition.RANK_1,
                WinningCondition.valueOfLottoNumbers(6,0)
        );
    }
}
