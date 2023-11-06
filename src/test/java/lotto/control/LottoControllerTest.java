package lotto.control;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {
    @DisplayName("로또를 생성한다.")
    @Test
    void createLotto() {
        LottoController lottoController = new LottoController();
        int purchaseAmount = 5;

        List<Lotto> lottos = lottoController.createLotto(purchaseAmount);

        assertThat(lottos.size()).isEqualTo(purchaseAmount);
    }

    @DisplayName("당첨 번호, 보너스 번호와 일치하는 개수만큼 점수를 받는다.")
    @Test
    void compareWithWinningNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(2);

        int bonusNumber = 3;
        LottoController lottoController = new LottoController();
        lottoController.drawNumber(winningNumbers, bonusNumber);

        int score = lottoController.compareWithWinningNumbers(numbers)
                + lottoController.compareWithBonusNumbers(numbers);
        assertThat(score).isEqualTo(15);
    }
}