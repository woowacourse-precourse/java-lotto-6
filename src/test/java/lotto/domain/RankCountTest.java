package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import domain.BonusNumber;
import domain.Lotto;
import domain.Lottos;
import domain.RankCount;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankCountTest {
    @DisplayName("RankCount 객체가 정상적으로 생성된다.")
    @Test
    void createRankCount() {
        assertThatCode(() -> new RankCount())
                .doesNotThrowAnyException();
    }

    @DisplayName("RankCount 객체가 당첨 횟수를 계산한다.")
    @Test
    void createRankCountMatch() {
        RankCount rankCount = new RankCount();
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(winningNumbers, "7");
        Lottos lottos = new Lottos(10000);

        assertThatCode(() -> {
            rankCount.calculateRankCount(lottos, winningNumbers, bonusNumber);
        }).doesNotThrowAnyException();
    }

}
