package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {

    private LottoCalculator lottoCalculator;

    @BeforeEach
    void setUp() {
        lottoCalculator = new LottoCalculator();
    }

    @Test
    @DisplayName("구입 로또, 당첨 번호, 보너스 번호를 비교해서 당첨 통계를 구한다.")
    void getMatchStatics() {
        // Given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42))
        );
        Lotto winningLotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        BonusNumber bonusNumber = new BonusNumber("11", winningLotto);

        // When
        Map<WinningType, Integer> result = lottoCalculator.getMatchStatics(lottos, winningLotto, bonusNumber);

        // Then
        assertThat(result).containsKeys(WinningType.NONE, WinningType.FIRST);
    }

}