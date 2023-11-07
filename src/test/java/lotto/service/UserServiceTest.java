package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class UserServiceTest {
    UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @DisplayName("로또 번호는 중복포함하지 않은 6개의 숫자로 구성된다.")
    @Test
    void createLotto() {
        int count = 5;

        ArrayList<Lotto> lottos = userService.createLotto(5);

        for(Lotto lotto : lottos){
            Set<Integer> numSet = new HashSet<>(lotto.getNumbers());
            assertThat(lotto.getNumbers().size()).isEqualTo(6);
            assertThat(numSet.size()).isEqualTo(6);
        }
    }

    @DisplayName("두 리스트 사이의 공통 요소의 개수를 카운트 한다.")
    @Test
    void compareLotto() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8));

        int count = userService.compareLotto(lotto, winningLotto);

        List<Integer> lottoNumbers = new ArrayList<>(lotto.getNumbers());
        List<Integer> winningNumbers = winningLotto.getNumbers();
        lottoNumbers.retainAll(winningNumbers);

        assertThat(count).isEqualTo(lottoNumbers.size());
    }

    @DisplayName("당첨 등수의 카운트 값에 따라 상금을 계산한다.")
    @Test
    void calculateWinnerMoney() {
        ArrayList<Integer> winningCount = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 1));

        int winningMoney = userService.calculateWinnerMoney(winningCount);

        assertThat(winningMoney).isEqualTo(5000);
    }

    @DisplayName("상금 / 투자비용 * 100으로 수익율을 계산한다.")
    @Test
    void calculateRateMoney() {
        int payMoney = 8000;
        int winningMoney = 5000;

        String rate = userService.calculateRateMoney(payMoney, winningMoney);

        assertThat(rate).isEqualTo("62.5");
    }
}