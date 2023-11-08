package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoCheckerTest {
    private final List<Integer> WINNING_NUMBER = List.of(1, 2, 3, 4, 5, 45);
    private final int BONUS_NUMBER = 33;

    @DisplayName("투입한 모든 로또의 등수별 갯수를 저장")
    @Test
    void checkLottos() {
        //given
        LottoChecker lottoChecker = new LottoChecker(WINNING_NUMBER, BONUS_NUMBER);
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 45)),
                new Lotto(List.of(1, 2, 3, 4, 5, 33)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7))
        );
        lottoChecker.checkLottos(lottos);

        //when
        Map<Prize, Integer> result = lottoChecker.getResult();

        //then
        assertThat(result.get(Prize.FIRST)).isEqualTo(1);
        assertThat(result.get(Prize.SECOND)).isEqualTo(1);
        assertThat(result.get(Prize.THIRD)).isEqualTo(1);
        assertThat(result.get(Prize.FOURTH)).isEqualTo(0);
        assertThat(result.get(Prize.FIFTH)).isEqualTo(0);
        assertThat(result.get(Prize.NONE)).isEqualTo(0);
    }

    @DisplayName("당첨 번호와 일치하는 숫자 테스트")
    @Test
    void matchLottoByWinningNumber() {
        //given
        LottoChecker lottoChecker = new LottoChecker(WINNING_NUMBER, BONUS_NUMBER);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));

        //when
        long matches = lottoChecker.checkWinningNumber(lotto);

        //then
        assertThat(matches).isEqualTo(6L);
    }

    @DisplayName("보너스 번호 포함 여부")
    @Test
    void containBonusNumber() {
        //given
        LottoChecker lottoChecker = new LottoChecker(WINNING_NUMBER, BONUS_NUMBER);
        Lotto hasBonusLotto = new Lotto(List.of(1, 2, 3, 4, 5, 33));
        Lotto noBonusLotto = new Lotto(List.of(1, 2, 3, 4, 5, 9));

        //when
        boolean containBonus = lottoChecker.checkContainBonusNumber(hasBonusLotto);
        boolean notContainBonus = lottoChecker.checkContainBonusNumber(noBonusLotto);

        //then
        assertThat(containBonus).isTrue();
        assertThat(notContainBonus).isFalse();
    }

    @DisplayName("일치하는 번호 갯수, 보너스 번호 포함 여부로 등수 선정")
    @Test
    void getPrize() {
        //given
        LottoChecker lottoChecker = new LottoChecker(WINNING_NUMBER, BONUS_NUMBER);

        //when
        Prize first = lottoChecker.getPrize(6, false);
        Prize second = lottoChecker.getPrize(5, true);
        Prize third = lottoChecker.getPrize(5, false);
        Prize forth = lottoChecker.getPrize(4, false);
        Prize fifth = lottoChecker.getPrize(3, false);
        Prize none = lottoChecker.getPrize(2, false);

        //then
        assertThat(first).isEqualTo(Prize.FIRST);
        assertThat(second).isEqualTo(Prize.SECOND);
        assertThat(third).isEqualTo(Prize.THIRD);
        assertThat(forth).isEqualTo(Prize.FOURTH);
        assertThat(fifth).isEqualTo(Prize.FIFTH);
        assertThat(none).isEqualTo(Prize.NONE);
    }

    @DisplayName("총 당첨금 계산")
    @Test
    void calculateTotalPrize() {
        //given
        LottoChecker lottoChecker = new LottoChecker(WINNING_NUMBER, BONUS_NUMBER);
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 45)),
                new Lotto(List.of(1, 2, 3, 4, 5, 33)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 3, 4, 25, 31, 22))
        );

        //when
        lottoChecker.checkLottos(lottos);

        long totalPrize = lottoChecker.getTotalPrize();
        System.out.println(totalPrize);

        //then
        long expectedPrize = Prize.FIRST.money + Prize.SECOND.money + Prize.THIRD.money + Prize.FIFTH.money;
        assertThat(totalPrize).isEqualTo(expectedPrize);

    }

    @DisplayName("총 수익률 계산")
    @Test
    void calculateProfitRate() {
        //given
        LottoChecker lottoChecker = new LottoChecker(WINNING_NUMBER, BONUS_NUMBER);
        List<Lotto> lottos = List.of(
                new Lotto(List.of(10, 12, 13, 14, 15, 19)),
                new Lotto(List.of(10, 12, 13, 14, 15, 19)),
                new Lotto(List.of(10, 12, 13, 14, 15, 19)),
                new Lotto(List.of(10, 12, 13, 14, 15, 19)),
                new Lotto(List.of(10, 12, 13, 14, 15, 19)),
                new Lotto(List.of(10, 12, 13, 14, 15, 19)),
                new Lotto(List.of(10, 12, 13, 14, 15, 19)),
                new Lotto(List.of(1, 2, 3, 14, 15, 19))
        );

        //when
        lottoChecker.checkLottos(lottos);

        String profitRate = lottoChecker.getProfitRate();

        //then
        assertThat(profitRate).isEqualTo("62.5");
    }
}