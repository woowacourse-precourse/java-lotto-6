package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.constant.NumberConstant.TEST_TICKET_NUM;
import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> Lotto.create(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> Lotto.create(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("파라미터로 주어진 수의 로또 객체를 생성한다")
    @Test
    void createRandomLottosForTicketNum() {
        int ticketNum = TEST_TICKET_NUM;

        List<Lotto> randomLottos = Lotto.createRandomLottos(ticketNum);
        assertThat(randomLottos.size()).isEqualTo(ticketNum);
    }

    @DisplayName("발행 로또에 대해 정답 로또와 비교하여 MatchResult를 반환한다")
    @Test
    void createMatchResultFromLottos() {
        Lotto randomLotto = Lotto.create(List.of(1, 2, 3, 4, 5, 6));
        Lotto winLotto = Lotto.create(List.of(1, 2, 3, 4, 5, 6));

        MatchResult matchResult = Lotto.match(randomLotto, winLotto, 99);
        assertThat(matchResult).isEqualTo(MatchResult.SIX);
    }

    @DisplayName("발행 로또에 대해 보너스 번호까지 고려하여 MatchResult를 반환한다")
    @Test
    void createMatchResultIncludingBonusNum() {
        Lotto randomLotto = Lotto.create(List.of(1, 2, 3, 4, 5, 6));
        Lotto winLotto = Lotto.create(List.of(1, 2, 3, 4, 5, 9));
        int bonusNum = 6;

        MatchResult matchResult = Lotto.match(randomLotto, winLotto, bonusNum);
        assertThat(matchResult).isEqualTo(MatchResult.BONUS);
    }
}