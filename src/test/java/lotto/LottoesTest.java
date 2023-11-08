package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoesTest {

    @Test
    @DisplayName("숫자 여섯개가 다 맞으면 1등에 당첨된다.")
    void getFirst() {
        Lottoes lottoes = new Lottoes(new TestNumberGenerator(List.of(1, 2, 3, 4, 5, 6)), 1);
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7));
        lottoes.calculateRanking(winningLotto);

        LottoResult result = lottoes.getResult();
        String message = result.getResultScreen();

        assertThat(message).contains("6개 일치 (2,000,000,000원) - 1개");
    }

    @Test
    @DisplayName("숫자 다섯개가 맞고 보너스 번호가 맞으면 2등에 당첨된다.")
    void getSecond() {
        Lottoes lottoes = new Lottoes(new TestNumberGenerator(List.of(1, 2, 3, 4, 5, 6)), 1);
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 42)), new BonusNumber(6));
        lottoes.calculateRanking(winningLotto);

        LottoResult result = lottoes.getResult();
        String message = result.getResultScreen();

        assertThat(message).contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 1개");
    }

    @Test
    @DisplayName("숫자 다섯개가 맞고 보너스 번호가 맞지 않으면 2등에 당첨된다.")
    void getThird() {
        Lottoes lottoes = new Lottoes(new TestNumberGenerator(List.of(1, 2, 3, 4, 5, 6)), 1);
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 42)), new BonusNumber(45));
        lottoes.calculateRanking(winningLotto);

        LottoResult result = lottoes.getResult();
        String message = result.getResultScreen();

        assertThat(message).contains("5개 일치 (1,500,000원) - 1개");
    }

    @Test
    @DisplayName("'총 당첨 금액 / 티켓수'로 수익률을 계산한다.")
    void getProfit() {
        Lottoes lottoes = new Lottoes(new TestNumberGenerator(List.of(1, 2, 3, 4, 5, 6)), 1);
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(45));
        lottoes.calculateRanking(winningLotto);
        double totalPrize = 2000000000;
        int ticketCount = 1;

        LottoResult result = lottoes.getResult();

        assertThat(result.getTotalPrize()).isEqualTo((double) totalPrize / ticketCount);
    }

    static class TestNumberGenerator implements NumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public List<Integer> create() {
            return new ArrayList<>(numbers);
        }
    }
}
