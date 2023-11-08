package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {
    LottoBuyer lottoBuyer;
    Lottos lottos;
    LottoNumberGenerator lottoNumberGenerator;

    @BeforeEach
    public void setUp() {
        lottoBuyer = new LottoBuyer();
        lottoNumberGenerator = () -> List.of(1, 2, 3, 4, 5, 6);
        lottos = new Lottos(1, lottoNumberGenerator);
    }

    @DisplayName("로또번호와 당첨번호가 6개 모두 같을 때 1등")
    @Test
    void 로또_1등_성공() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int inputBonusNumber = 7;

        lottos.compareWithWinningNumbers(lottoBuyer, winningNumbers, inputBonusNumber);

        assertThat(1)
                .isEqualTo(lottoBuyer.getWinCount(WinningRank.FIRST));
    }

    @DisplayName("로또번호와 당첨번호가 5개, 보너스 볼이 같을 때 2등")
    @Test
    void 로또_2등_성공() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        int inputBonusNumber = 6;

        lottos.compareWithWinningNumbers(lottoBuyer, winningNumbers, inputBonusNumber);

        assertThat(1)
                .isEqualTo(lottoBuyer.getWinCount(WinningRank.SECOND));
    }

    @DisplayName("로또번호와 당첨번호가 5개가 같을 때 3등")
    @Test
    void 로또_3등_성공() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        int inputBonusNumber = 15;

        lottos.compareWithWinningNumbers(lottoBuyer, winningNumbers, inputBonusNumber);

        assertThat(1)
                .isEqualTo(lottoBuyer.getWinCount(WinningRank.THIRD));
    }

    @DisplayName("로또번호와 당첨번호가 4개가 같을 때 4등")
    @Test
    void 로또_4등_성공() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 44, 45));
        int inputBonusNumber = 15;

        lottos.compareWithWinningNumbers(lottoBuyer, winningNumbers, inputBonusNumber);

        assertThat(1)
                .isEqualTo(lottoBuyer.getWinCount(WinningRank.FOURTH));
    }

    @DisplayName("로또번호와 당첨번호가 3개가 같을 때 5등")
    @Test
    void 로또_5등_성공() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 43, 44, 45));
        int inputBonusNumber = 15;

        lottos.compareWithWinningNumbers(lottoBuyer, winningNumbers, inputBonusNumber);

        assertThat(1)
                .isEqualTo(lottoBuyer.getWinCount(WinningRank.FIFTH));
    }

}
