package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class IssuedLottosTest {
    @Test
    void 당첨등수_결정하기() {
        // given
        IssuedLottos 발행된_로또 = new IssuedLottos(로또_생성하기());
        Lotto 당첨로또 = new Lotto(List.of(1, 3, 4, 18, 2, 5));
        BonusNumber 보너스번호 = new BonusNumber(33);

        // when
        WinningRanks 등수결과 = 발행된_로또.determineRanks(당첨로또, 보너스번호);

        // then
        List<String> 당첨결과 = 등수결과.convertToResponse().createdMessage();
        assertThat(당첨결과).contains("4개 일치 (50,000원) - 1개");
    }

    private List<Lotto> 로또_생성하기() {
        return List.of(
            new Lotto(List.of(1, 3, 4, 18, 20, 33)),
            new Lotto(List.of(7, 15, 23, 27, 37, 38)),
            new Lotto(List.of(2, 5, 19, 24, 28, 29)),
            new Lotto(List.of(9, 32, 37, 41, 44, 45)),
            new Lotto(List.of(6, 15, 36, 39, 40, 41)),
            new Lotto(List.of(16, 21, 27, 30, 36, 37)),
            new Lotto(List.of(11, 14, 30, 34, 41, 42)),
            new Lotto(List.of(2, 3, 13, 20, 29, 34))
        );
    }
}