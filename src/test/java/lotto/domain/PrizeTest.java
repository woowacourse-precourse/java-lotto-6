package lotto.domain;

import lotto.constant.PrizeConstant;
import lotto.domain.lotto.enums.LottoRank;
import lotto.domain.prize.Prize;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;

public class PrizeTest {
    @Test
    @DisplayName("로또 결과과 종합된 보드를 통해 당첨금을 계산해 Prize를 생성 한다.")
    void createPrizeByLottoResult() {
        EnumMap<LottoRank, Integer> resultBoard = new EnumMap<>(LottoRank.class);
        resultBoard.put(LottoRank.FIRST, 3);
        var prize = Prize.of(resultBoard);
        Assertions.assertEquals(prize.getClass(), Prize.class);
    }

    @Test
    @DisplayName("1등이 세번 당첨되면 2_000_000_000 * 3 의 당첨금을 받는다.")
    void calculateTotalAmountWithThreeFirstWin() {
        EnumMap<LottoRank, Integer> resultBoard = new EnumMap<>(LottoRank.class);
        resultBoard.put(LottoRank.FIRST, 3);
        var prize = Prize.of(resultBoard);
        var expectedAmount = PrizeConstant.FIRST_PRIZE * 3;
        Assertions.assertEquals(expectedAmount, prize.amount());
    }

    @Test
    @DisplayName("3등 두번 , 4등 두번 당첨되면 1_500_000 *2 50_000*2 의 당첨금을 받는다.")
    void calculateTotalAmountWithComplicate() {
        EnumMap<LottoRank, Integer> resultBoard = new EnumMap<>(LottoRank.class);
        resultBoard.put(LottoRank.THIRD, 2);
        resultBoard.put(LottoRank.FOURTH, 2);

        var prize = Prize.of(resultBoard);
        var expectedAmount = PrizeConstant.FOURTH_PRIZE * 2 + PrizeConstant.THIRD_PRIZE * 2;
        Assertions.assertEquals(expectedAmount, prize.amount());
    }
}
