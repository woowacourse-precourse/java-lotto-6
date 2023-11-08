package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.exception.DuplicatedBonusBallException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerLottosTest {
    @Test
    @DisplayName("보너스 볼이 당첨 번호와 중복인 경우 예외가 발생한다.")
    void bonusBallSameLotto() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusBall bonusBall = new BonusBall(1);

        // when & then
        assertThatThrownBy(() -> new AnswerLottos(lotto, bonusBall))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("티켓과 비교한 결과를 반환한다.")
    void getResult() {
        // given
        Money money = new Money(1000);
        LottoMachine lottoMachine = new LottoMachine();
        LottoTicket lottoTicket = lottoMachine.buy(money, () -> new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusBall bonusBall = new BonusBall(7);
        AnswerLottos answerLottos = new AnswerLottos(lotto, bonusBall);

        // when
        List<Result> match = answerLottos.match(lottoTicket);

        // then
        assertAll(
                () -> assertEquals(1, match.size()),
                () -> assertEquals(5, match.get(0).getMatchCount()),
                () -> assertTrue(match.get(0).isMatchBonus())
        );
    }

    @Test
    @DisplayName("보너스 볼은 다른 정답 볼과 달라야 합니다.")
    void duplicatedBonusBall() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusBall bonusBall = new BonusBall(1);

        // when & then
        assertThatThrownBy(() -> new AnswerLottos(lotto, bonusBall))
                .isInstanceOf(DuplicatedBonusBallException.class);
    }
}