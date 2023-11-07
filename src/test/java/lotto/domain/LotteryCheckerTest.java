package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class LotteryCheckerTest {
    private static final WinningNumber WINNING_NUMBER = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
    private static final BonusNumber BONUS_NUMBER = new BonusNumber(WINNING_NUMBER.getWinningNumber(), 7);

    @ParameterizedTest
    @CsvSource({"1,2,3,4,5,6,FIRST_RANK", "1,2,3,4,6,7,SECOND_RANK", "1,2,3,4,5,8,THIRD_RANK", "1,2,3,4,7,8,FORTH_RANK", "1,2,3,10,11,12,FIFTH_RANK", "10,11,12,13,14,15,NO_RANK"})
    @DisplayName("일치하는 번호 계산 테스트")
    void calculateMatchCount(int num1, int num2, int num3, int num4, int num5, int num6, String expected) {
        //given
        LottoMachine lottoMachine = new LottoMachine(5000);
        LotteryChecker lotteryChecker = new LotteryChecker(lottoMachine);
        Lotto lotto = new Lotto(Arrays.asList(num1, num2, num3, num4, num5, num6));

        //when
        LottoRank lottoRank = lotteryChecker.calculateMatchCount(lotto, WINNING_NUMBER, BONUS_NUMBER);

        //then
        assertThat(lottoRank.name()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"3,false,FIFTH_RANK", "5,true,SECOND_RANK", "2,true,NO_RANK", "6,false,FIRST_RANK"})
    @DisplayName("당첨 반환 테스트")
    void checkRank(int matchCount, boolean isMatchBonus, String expected) {
        //given
        LottoRank lottoRank = LotteryChecker.checkRank(matchCount, isMatchBonus);
        String name = lottoRank.name();

        Assertions.assertThat(name).isEqualTo(expected);
    }
}