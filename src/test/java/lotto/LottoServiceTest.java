package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoEnum;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    @DisplayName("금액을 입력하면 로또 개수가 계산된다.")
    @Test
    void setMoney() {
        LottoService lottoService = new LottoService();
        lottoService.setMoney(2000);
        assertThat(lottoService.getCount()).isEqualTo(2);
    }

    @DisplayName("금액을 1,000원 단위로 입력하지 않으면 예외가 발생한다.")
    @Test
    void setMoneyNotDividedByThousand() {
        LottoService lottoService = new LottoService();
        assertThatThrownBy(() -> lottoService.setMoney(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void setWinNumbersNotSix() {
        LottoService lottoService = new LottoService();
        assertThatThrownBy(() -> lottoService.setWinNumbers(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1부터 45 사이가 아니면 예외가 발생한다.")
    @Test
    void setWinNumbersNotBetweenOneAndFortyFive() {
        LottoService lottoService = new LottoService();
        assertThatThrownBy(() -> lottoService.setWinNumbers(List.of(1, 2, 3, 4, 46, 47)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 중복되면 예외가 발생한다.")
    @Test
    void setWinNumbersDuplicated() {
        LottoService lottoService = new LottoService();
        assertThatThrownBy(() -> lottoService.setWinNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void setBonusNumberDuplicated() {
        LottoService lottoService = new LottoService();
        lottoService.setWinNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lottoService.setBonusNumber(6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1부터 45 사이가 아니면 예외가 발생한다.")
    @Test
    void setBonusNumberNotBetweenOneAndFortyFive() {
        LottoService lottoService = new LottoService();
        lottoService.setWinNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lottoService.setBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 생성할 수 있다.")
    @Test
    void createLottos() {
        LottoService lottoService = new LottoService();
        lottoService.setMoney(20000);
        List<Lotto> lottos = lottoService.createLottos();
        assertThat(lottos).hasSize(20);
    }

    @DisplayName("로또의 숫자를 비교하여 당첨 결과를 확인할 수 있다.")
    @Test
    void compareLottos() {
        LottoService lottoService = new LottoService();
        lottoService.setMoney(100000000);
        List<Lotto> lottos = lottoService.createLottos();

        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        lottoService.setWinNumbers(winNumbers);
        lottoService.setBonusNumber(bonusNumber);

        List<LottoEnum> results = lottoService.compareLottos();

        for (LottoEnum result : results) {
            assertThat(LottoEnum.values()).contains(result);
        }
    }

    @DisplayName("로또 당첨 결과의 총 당첨금을 계산할 수 있다.")
    @Test
    void calcTotalWinningMoney() {
        LottoService lottoService = new LottoService();
        lottoService.setMoney(100000000);
        List<Lotto> lottos = lottoService.createLottos();

        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        lottoService.setWinNumbers(winNumbers);
        lottoService.setBonusNumber(bonusNumber);

        int totalWinningMoney = lottoService.calcTotalWinningMoney();

        int expectedTotalWinningMoney = 0;
        for (Lotto lotto : lottos) {
            LottoEnum ranking = lotto.getRanking(winNumbers, bonusNumber);
            expectedTotalWinningMoney += ranking.getWinningMoney();
        }

        assertThat(totalWinningMoney).isEqualTo(expectedTotalWinningMoney);
    }
}
