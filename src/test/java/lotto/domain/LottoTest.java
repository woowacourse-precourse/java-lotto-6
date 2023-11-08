package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    // create()
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        // GIVEN, WHEN, THEN
        assertThatThrownBy(() -> Lotto.create(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // GIVEN, WHEN, THEN
        assertThatThrownBy(() -> Lotto.create(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정해진 범위에 있지 않은 로또 번호 값에 대해 예외가 발생한다")
    @Test
    void createLottoByNotInRange() {
        // GIVEN, WHEN, THEN
        assertThatThrownBy(() -> Lotto.create(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    // createRandomLottos()
    @DisplayName("파라미터로 주어진 수만큼 정렬된 랜덤 로또 객체를 생성한다")
    @Test
    void createRandomLottosForTicketNum() {
        // GIVEN
        int ticketNum = 5;

        // WHEN
        List<Lotto> randomLottos = Lotto.createRandomLottos(ticketNum);

        // THEN
        assertThat(randomLottos.size()).isEqualTo(ticketNum);
        randomLottos.forEach(lotto -> assertThat(lotto.getNumbers()).isSorted());
    }


    // match()
    @DisplayName("발행 로또에 대해 정답 로또와 비교한 결과에 해당하는 MatchResult를 반환한다")
    @Test
    void matchResultFromLottos() {
        Lotto randomLotto = Lotto.create(List.of(1, 2, 3, 4, 5, 6));
        Lotto winLotto1 = Lotto.create(List.of(1, 2, 3, 4, 5, 6));
        Lotto winLotto2 = Lotto.create(List.of(1, 2, 3, 4, 5, 7));

        MatchResult matchResult1 = Lotto.match(randomLotto, winLotto1, 99);
        assertThat(matchResult1).isEqualTo(MatchResult.SIX);

        MatchResult matchResult2 = Lotto.match(randomLotto, winLotto2, 99);
        assertThat(matchResult2).isEqualTo(MatchResult.FIVE);
    }

    @DisplayName("발행 로또에 대해 보너스 번호까지 고려하여 MatchResult를 반환한다")
    @Test
    void matchResultIncludingBonusNum() {
        Lotto randomLotto = Lotto.create(List.of(1, 2, 3, 4, 5, 6));
        Lotto winLotto = Lotto.create(List.of(1, 2, 3, 4, 5, 9));
        int bonusNum = randomLotto.getNumbers().get(5);

        MatchResult matchResult = Lotto.match(randomLotto, winLotto, bonusNum);
        assertThat(matchResult).isEqualTo(MatchResult.BONUS);
    }
}