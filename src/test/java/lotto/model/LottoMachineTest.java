package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.LottoStatistics.PrizeInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @DisplayName("구매 횟수만큼 로또 번호 조합 발행 기능 테스트")
    @Test
    void createLottoByPurchaseCount() {
        int purchaseCount = 5;

        ArrayList<Lotto> lottoTickets = lottoMachine.runLottoMachine(purchaseCount);

        assertThat(lottoTickets.size()).isEqualTo(purchaseCount);
    }

    @DisplayName("당첨 번호 설정 기능 테스트")
    @Test
    void testSetWinningNumbers() {
        lottoMachine.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lottoMachine.getWinningNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("보너스 번호 설정 기능 테스트")
    @Test
    void testSetBonusNumber() {
        int bonusNumber = 10;

        lottoMachine.setBonusNumber(bonusNumber);

        assertThat(lottoMachine.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createBonusNumberByOutRange() {
        int bonusNumber = 80;

        assertThatThrownBy(() -> lottoMachine.setBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusByDuplicatedNumber() {
        int bonusNumber = 5;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        lottoMachine.setWinningNumbers(winningNumbers);

        assertThatThrownBy(() -> lottoMachine.setBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 당첨 번호와 일치하는 갯수에 따라 당첨 판단")
    @Test
    void testCorrectPrizeAwardedForMatchingLottoNumbers() {
        int bonusNumber = 15;
        List<Integer> winningNumbers = List.of(1, 7, 14, 21, 35, 41);
        ArrayList<Lotto> testLotto = new ArrayList<>();
        Lotto testLottoNumber = new Lotto(Arrays.asList(1, 7, 15, 21, 35, 41));
        testLotto.add(testLottoNumber);

        lottoMachine.setWinningNumbers(winningNumbers);
        lottoMachine.setBonusNumber(bonusNumber);
        ArrayList<PrizeInformation> result = lottoMachine.determineLottoWinning(testLotto);

        assertThat(result.get(0)).isEqualTo(PrizeInformation.SECOND_PRIZE);
    }

}
