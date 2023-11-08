package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.CorrectCount;
import lotto.domain.Lotto;
import lotto.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReturnRateCalculatorTest {

    Player player;

    @BeforeEach
    void beforeEach() {
        player = new Player(new CorrectLottoCalculator());
    }

    @Test
    @DisplayName("구매금액 대비 로또 수익률을 계산한다.")
    public void getReturnRateTest() {
        //given
        setLottos();
        int customerPrice = 8000;
        TotalStatCalculator totalStatCalculator = new TotalStatCalculator(player);
        Map<String, Integer> totalLottoStats = totalStatCalculator.getTotalLottoStats();
        //when
        String returnRate = ReturnRateCalculator.getReturnRate(totalLottoStats, customerPrice);
        //then
        assertThat(returnRate).isEqualTo("125.0");
    }

    private void setLottos() {
        setLotto(3,1);
        setLotto(3,0);
    }

    private void setLotto(int correctNumberCount, int correctBonusCount) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        CorrectCount correctCount = new CorrectCount(correctNumberCount, correctBonusCount);

        player.addLotto(lotto);
        player.setLottoCorrectCount(lotto, correctCount);
    }
}
