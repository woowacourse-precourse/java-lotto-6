package lotto.service;

import lotto.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoAwardsTest {
    private final int WINNING_BONUS_NUMBER = 6;
    private final int LOSSING_BONUS_NUMBER = 45;

    @Test
    @DisplayName("하나도 당첨되지 않은 경우")
    void 하나도_당첨되지_않은_경우() throws Exception {
        //given
        Lotto lotto = generateLotto(List.of(1,2,3,4,5,6));
        WinningNumber winningNumber = getWinningNumber(List.of(8, 9, 10, 11, 12, 13), LOSSING_BONUS_NUMBER);

        //when
        Rank rank = LottoAwards.awards(lotto, winningNumber);
        //then
        assertThat(rank).isEqualTo(Rank.NO);
    }
    @Test
    @DisplayName("세개만 당첨된 경우")
    void 세개만_당첨된_경우() throws Exception {
        Lotto lotto = generateLotto(List.of(1,2,3,4,5,6));
        WinningNumber winningNumber = getWinningNumber(List.of(1, 2, 3, 11, 12, 13), LOSSING_BONUS_NUMBER);

        //when
        Rank rank = LottoAwards.awards(lotto, winningNumber);
        //then
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }
    @Test
    @DisplayName("네개만 당첨된 경우")
    void 네개만_당첨된_경우() throws Exception {
        Lotto lotto = generateLotto(List.of(1,2,3,4,5,6));
        WinningNumber winningNumber = getWinningNumber(List.of(1, 2, 3, 4, 12, 13), LOSSING_BONUS_NUMBER);

        //when
        Rank rank = LottoAwards.awards(lotto, winningNumber);
        //then
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }
    @Test
    @DisplayName("다섯개 당첨되고 보너스 번호는 실패한 경우")
    void 다섯개_당첨되고_보너스_번호는_실패한_경우() throws Exception {
        Lotto lotto = generateLotto(List.of(1,2,3,4,5,6));
        WinningNumber winningNumber = getWinningNumber(List.of(1, 2, 3, 4, 5, 13), LOSSING_BONUS_NUMBER);

        //when
        Rank rank = LottoAwards.awards(lotto, winningNumber);
        //then
        assertThat(rank).isEqualTo(Rank.THIRD);
    }
    @Test
    @DisplayName("다섯개 당첨되고 보너스 번호까지 성공한 경우")
    void 다섯개_당첨되고_보너스_번호까지_성공한_경우() throws Exception {
        Lotto lotto = generateLotto(List.of(1,2,3,4,5,6));
        WinningNumber winningNumber = getWinningNumber(List.of(1, 2, 3, 4, 5, 13), WINNING_BONUS_NUMBER);

        //when
        Rank rank = LottoAwards.awards(lotto, winningNumber);
        //then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }
    @Test
    @DisplayName("여섯개 모두 당첨되는 경우")
    void 여섯개_모두_당첨되는_경우() throws Exception {
        Lotto lotto = generateLotto(List.of(1,2,3,4,5,6));
        WinningNumber winningNumber = getWinningNumber(List.of(1, 2, 3, 4, 5, 6), LOSSING_BONUS_NUMBER);

        //when
        Rank rank = LottoAwards.awards(lotto, winningNumber);
        //then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }
    private static WinningNumber getWinningNumber(List<Integer> numbers,int bonus) {
        return new WinningNumber(generateLotto(numbers),bonus);
    }
    private static Lotto generateLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

}