package lotto.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest extends NsTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 생성 시 형식을 지키지 않으면 예외 발생.")
    @Test
    void createLottoByIllegalFormat() {
        assertThatThrownBy(() -> new Lotto("1, 2, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 발행한 로또 번호 중 같은 번호 개수를 테스트.")
    @Test
    void countMatchTest() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6))
                .countMatch(new Lotto(List.of(1, 2, 3, 4, 5, 6)))
        ).isEqualTo(6);
    }

    @DisplayName("보너스 번호 체크 테스트")
    @Test
    void testBonusChecking() {
        // given
        BonusNumber bonusNumber = new BonusNumber("43");
        Lotto lotto = new Lotto("1,2,3,4,5,43");

        // when, then
        assertThat(lotto.isBonus(bonusNumber)).isTrue();
    }

    @DisplayName("로또 당첨 등수 체크")
    @Test
    void checkRankingTest() {
        // given
        Lotto targetTicket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumbersFourMatches = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        Lotto winningNumbersFiveMatches = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        BonusNumber bonusNumberMatch = new BonusNumber("6");
        BonusNumber bonusNumberNotMatch = new BonusNumber("9");

        // when
        Ranking rankingFirst = targetTicket.checkRanking(winningNumbersFiveMatches, bonusNumberMatch);
        Ranking rankingSecond = targetTicket.checkRanking(winningNumbersFiveMatches, bonusNumberNotMatch);
        Ranking rankingThird = targetTicket.checkRanking(winningNumbersFourMatches, bonusNumberMatch);
        Ranking rankingFourth = targetTicket.checkRanking(winningNumbersFourMatches, bonusNumberNotMatch);

        // then
        assertThat(rankingFirst == Ranking.FIRST).isTrue();
        assertThat(rankingSecond == Ranking.SECOND).isTrue();
        assertThat(rankingThird == Ranking.THIRD).isTrue();
        assertThat(rankingFourth == Ranking.FOURTH).isTrue();
    }

    @Override
    protected void runMain() {Application.main(new String[]{});}
}
