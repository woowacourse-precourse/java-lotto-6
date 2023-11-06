package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
        lottoChecker.insertLottos(lottos);
        lottoChecker.saveLottosResult();

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
        Prize first = lottoChecker.getPrize(6L, false);
        Prize second = lottoChecker.getPrize(5L, true);
        Prize third = lottoChecker.getPrize(5L, false);
        Prize forth = lottoChecker.getPrize(4L, false);
        Prize fifth = lottoChecker.getPrize(3L, false);
        Prize none = lottoChecker.getPrize(2L, false);

        //then
        assertThat(first).isEqualTo(Prize.FIRST);
        assertThat(second).isEqualTo(Prize.SECOND);
        assertThat(third).isEqualTo(Prize.THIRD);
        assertThat(forth).isEqualTo(Prize.FOURTH);
        assertThat(fifth).isEqualTo(Prize.FIFTH);
        assertThat(none).isEqualTo(Prize.NONE);
    }
}