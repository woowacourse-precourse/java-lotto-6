package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.constant.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {
    @DisplayName("보유한 로또의 당첨 결과 반환 기능 테스트 - 1등, 3등")
    @Test
    void checkWinningResultFirstAndThird() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto thirdLotto = new Lotto(List.of(1, 2, 3, 4, 5, 9));

        Customer customer = new Customer(List.of(firstLotto, thirdLotto));
        Map<Prize, Integer> result = customer.checkWinningResult(winningNumbers);
        assertThat(result.get(Prize.FIRST)).isEqualTo(1);
        assertThat(result.get(Prize.THIRD)).isEqualTo(1);
        assertThat(result.get(Prize.SECOND)).isEqualTo(0);
        assertThat(result.get(Prize.FOURTH)).isEqualTo(0);
        assertThat(result.get(Prize.FIFTH)).isEqualTo(0);
        assertThat(result.get(Prize.NONE)).isEqualTo(0);
    }

    @DisplayName("보유한 로또의 당첨 결과 반환 기능 테스트 - 2등, 3등")
    @Test
    void checkWinningResultSecondAndThird() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
        Lotto secondLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto thirdLotto = new Lotto(List.of(1, 2, 3, 4, 5, 9));

        Customer customer = new Customer(List.of(secondLotto, thirdLotto));
        Map<Prize, Integer> result = customer.checkWinningResult(winningNumbers);
        assertThat(result.get(Prize.FIRST)).isEqualTo(0);
        assertThat(result.get(Prize.THIRD)).isEqualTo(1);
        assertThat(result.get(Prize.SECOND)).isEqualTo(1);
        assertThat(result.get(Prize.FOURTH)).isEqualTo(0);
        assertThat(result.get(Prize.FIFTH)).isEqualTo(0);
        assertThat(result.get(Prize.NONE)).isEqualTo(0);
    }
}