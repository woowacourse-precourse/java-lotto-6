package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoDrawTest {
    private Lotto winningLotto;
    private Bonus winningBonus;
    private LottoDraw lottoDraw;

    @BeforeEach
    void setUp() {
        // 가상의 당첨 로또 번호와 보너스 번호를 생성
        winningLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        winningBonus = Bonus.createWithValidate(7, winningLotto);
        lottoDraw = LottoDraw.of(winningLotto, winningBonus);
    }

    @DisplayName("당첨 번호 비교시 정상적인 값을 얻을 수 있다.")
    @Test
    void countMatchingNumbersWithWinnings() {
        // 당첨 번호와 모두 일치하는 로또
        Lotto matchingLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        int matchingNumbers = lottoDraw.countMatchingNumbersWith(matchingLotto);
        assertThat(matchingNumbers).isEqualTo(6);
    }

    @DisplayName("보너스 번호 비교시 정상적인 값을 얻을 수 있다.")
    @Test
    void hasMatchingBonusNumber() {
        // 보너스 번호와 일치하는 로또
        Lotto lottoWithMatchingBonus = Lotto.from(List.of(1, 2, 3, 4, 5, 7));
        boolean hasMatchingBonus = lottoDraw.hasMatchingBonusNumberWith(lottoWithMatchingBonus);
        assertThat(hasMatchingBonus).isTrue();

        // 보너스 번호와 일치하지 않는 로또
        Lotto lottoWithoutMatchingBonus = Lotto.from(List.of(1, 2, 3, 4, 5, 8));
        boolean hasNoMatchingBonus = lottoDraw.hasMatchingBonusNumberWith(lottoWithoutMatchingBonus);
        assertThat(hasNoMatchingBonus).isFalse();
    }
}