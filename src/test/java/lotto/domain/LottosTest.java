package lotto.domain;

import static lotto.support.fixture.LottoFixtures.로또_1_부터_6;
import static lotto.support.fixture.LottoFixtures.로또_4_부터_9;
import static lotto.support.fixture.LottoFixtures.로또_7_부터_12;
import static lotto.support.fixture.WinnerNumbersFixtures.당첨번호_1_부터_6_보너스_7;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("로또 결과를 반환한다.")
    @Test
    void getResult() {
        // given
        final List<Lotto> lotto = List.of(로또_1_부터_6.생성(), 로또_4_부터_9.생성(), 로또_7_부터_12.생성());
        final WinnerNumbers winnerNumbers = 당첨번호_1_부터_6_보너스_7.생성();
        final Result expected = new Result(lotto.stream().map((l) -> l.getPrize(winnerNumbers)).toList());
        final Lottos lottos = new Lottos(lotto);

        // when
        final Result actual = lottos.getResult(winnerNumbers);

        // then
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @DisplayName("로또의 개수를 반환한다.")
    @Test
    void getLottoCount() {
        // given
        final List<Lotto> lotto = List.of(로또_1_부터_6.생성(), 로또_1_부터_6.생성(), 로또_1_부터_6.생성());
        final Lottos lottos = new Lottos(lotto);

        // when
        final int actual = lottos.getLottoCount();

        // then
        assertThat(actual).isEqualTo(lotto.size());
    }

    @DisplayName("로또 문자열 목록을 반환한다.")
    @Test
    void getNumberStrings() {
        // given
        final List<Lotto> lotto = List.of(로또_1_부터_6.생성(), 로또_1_부터_6.생성(), 로또_1_부터_6.생성());
        final List<String> expected = lotto.stream().map(Lotto::getNumberString).toList();
        final Lottos lottos = new Lottos(lotto);

        // when
        final List<String> actual = lottos.getNumberStrings();

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }
}