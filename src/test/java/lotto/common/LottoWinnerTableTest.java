package lotto.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.EnumMap;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

public class LottoWinnerTableTest {
    @CsvSource({
            "3, false, 5000",
            "4, false, 50000",
            "5, false, 1500000",
            "6, true, 30000000",
            "6, false, 2000000000"
    })
    @ParameterizedTest
    void 번호를_맞추면_당첨_금액을_반환해야_함(int givenMatchCount, boolean givenIsBonusRequired, BigDecimal givenWinningMoney) {

        // when
        LottoWinnerTable winnerTable = LottoWinnerTable.findByGrade(givenMatchCount, givenIsBonusRequired);
        BigDecimal winningMoney = winnerTable.getWinningMoney();

        // then
        assertThat(winningMoney).isEqualTo(givenWinningMoney);
    }

    @CsvSource({
            "3, false, '5,000'",
            "4, false, '50,000'",
            "5, false, '1,500,000'",
            "6, true, '30,000,000'",
            "6, false, '2,000,000,000'"
    })
    @ParameterizedTest
    void 번호를_맞추면_당첨_금액_문자열을_반환해야_함(int givenMatchCount, boolean givenIsBonusRequired, String givenWinningMoney) {

        // when
        LottoWinnerTable winnerTable = LottoWinnerTable.findByGrade(givenMatchCount, givenIsBonusRequired);
        String winningMoney = winnerTable.getWinningStringMoney();

        // then
        assertThat(winningMoney).isEqualTo(givenWinningMoney);
    }

    @CsvSource({
            "3, false, '3개 일치'",
            "4, false, '4개 일치'",
            "5, false, '5개 일치'",
            "6, true, '5개 일치, 보너스 볼 일치'",
            "6, false, '6개 일치'"
    })
    @ParameterizedTest
    void 번호를_맞추면_당첨_조건을_반환해야_함(int givenMatchCount, boolean givenIsBonusRequired, String givenWinningCondition) {

        // when
        LottoWinnerTable winnerTable = LottoWinnerTable.findByGrade(givenMatchCount, givenIsBonusRequired);
        String winningCondition = winnerTable.getWinningCondition();

        // then
        assertThat(winningCondition).isEqualTo(givenWinningCondition);
    }

    @Test
    void 당첨_정보와_당첨개수를_샐_수_있는_Map_생성해야_함() {
        // when
        EnumMap<LottoWinnerTable,Integer> winnerCountMap = LottoWinnerTable.generateEnumMap();

        // then
        winnerCountMap
                .forEach((key, value) -> {
                        assertThat(key).isInstanceOf(LottoWinnerTable.class);
                        assertThat(value).isZero();});
    }
}
