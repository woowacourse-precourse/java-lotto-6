package lotto.model.user;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.lotto.Bonus;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoRank;
import lotto.model.lotto.WinningNumbers;
import lotto.util.generator.NumberGenerator;
import lotto.util.generator.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserLottoRankTest {
    NumberGenerator numberGenerator;
    Lotto lotto;
    Bonus bonus;
    WinningNumbers winningNumbers;
    long amount;

    @BeforeEach
    void setUp() {
        numberGenerator = new RandomNumberGenerator();
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonus = new Bonus(7);
        winningNumbers = new WinningNumbers(lotto, bonus);
        amount = 2L;
    }

    @Test
    void 로또_수만큼_로또_당첨_결과를_생성한다() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    UserLotto userLotto = new UserLotto(amount, numberGenerator);
                    UserLottoRank userLottoRank = new UserLottoRank(userLotto, winningNumbers);
                    assertThat(userLottoRank.getLottoRanks().size()).isEqualTo(amount);
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 14, 15, 16)
        );
    }

    @Test
    void 사용자의_로또_당첨_결과를_계산한다() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    UserLotto userLotto = new UserLotto(amount, numberGenerator);
                    UserLottoRank userLottoRank = new UserLottoRank(userLotto, winningNumbers);
                    assertThat(userLottoRank.getLottoRanks().get(0)).isEqualTo(LottoRank.FIRST);
                    assertThat(userLottoRank.getLottoRanks().get(1)).isEqualTo(LottoRank.FIFTH);
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 14, 15, 16)
        );
    }

    @Test
    void 총_당첨_금액을_계산한다() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    UserLotto userLotto = new UserLotto(amount, numberGenerator);
                    UserLottoRank userLottoRank = new UserLottoRank(userLotto, winningNumbers);
                    long expected = LottoRank.FIRST.getPrize() + LottoRank.FIFTH.getPrize();
                    assertThat(userLottoRank.getRevenue()).isEqualTo(expected);
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 14, 15, 16)
        );
    }
}