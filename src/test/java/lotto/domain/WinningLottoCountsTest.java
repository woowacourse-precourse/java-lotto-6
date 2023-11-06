package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoCountsTest {

    WinningLottoCounts winningLottoCounts;

    @BeforeEach
    void setUp() {
        List<Lotto> myLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6))        //1등
                , new Lotto(List.of(1, 2, 3, 4, 5, 7))      //2등
                , new Lotto(List.of(1, 2, 3, 4, 5, 10))     //3등
                , new Lotto(List.of(1, 2, 3, 4, 10, 11))    //4등
                , new Lotto(List.of(1, 2, 3, 10, 11, 12))   //5등
                , new Lotto(List.of(1, 2, 10, 11, 12, 13)));//none
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        winningLottoCounts = new WinningLottoCounts(myLottos, winningNumbers, bonusNumber);
    }

    @ParameterizedTest
    @DisplayName("등수별 당첨 수를 반환한다.")
    @CsvSource(value = {"0,1", "1,1", "2,1", "3,1", "4,1"})
    void getCountTest(int rankIndex, int count) {
        //given

        //when

        //then
        assertThat(winningLottoCounts.getCount(rankIndex)).isEqualTo(count);
    }

    @ParameterizedTest
    @DisplayName("등수별 당첨 수에 비례해 상금을 반환한다.")
    @CsvSource(value = {"FIRST,2000000000", "SECOND,30000000", "THIRD,1500000", "FOURTH,50000", "FIFTH,5000"})
    void getPrizeTest(Rank rank,double prize) {
        //given

        //when

        //then
        assertThat(winningLottoCounts.getPrize(rank)).isEqualTo(prize);
    }
}