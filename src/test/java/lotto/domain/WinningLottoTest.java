package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    private WinningLotto winningLotto;

    @BeforeEach
    public void setUp() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    @Test
    @DisplayName("calculateStatistics 메서드가 올바른 LottoResult를 반환하는지 테스트")
    void calculateStatistics_ShouldReturnCorrectLottoResult() {
        List<Lotto> buyerLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 7, 8))
        );

        BuyerLotto buyerLotto = new BuyerLotto(buyerLottos);

        LottoResult result = winningLotto.calculateStatistics(buyerLotto);

        assertThat(result).isInstanceOf(LottoResult.class);
    }
}
