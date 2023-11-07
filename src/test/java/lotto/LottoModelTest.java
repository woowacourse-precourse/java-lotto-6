package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoModelTest {
    @Test
    void 로또가격만큼_로또번호생성_테스트() {
        List<Lotto> randomNumbers = LottoModel.generateLottos(7000);
        assertThat(new HashSet<>(randomNumbers)).hasSize(7);
    }

    @Test
    void 맞는로또개수_테스트() {
        Lotto boughtLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        int num = LottoModel.checkWonNumber(boughtLotto, winningLotto);
        assertThat(num).isEqualTo(3);
    }

    @Test
    void 보너스_번호_포함_테스트() {
        Lotto boughtLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 4;
        boolean tf = LottoModel.checkBonusNumber(boughtLotto, bonusNumber);
        assertThat(tf).isEqualTo(true);

        bonusNumber = 7;
        tf = LottoModel.checkBonusNumber(boughtLotto, bonusNumber);
        assertThat(tf).isEqualTo(false);
    }

    @Test
    void 이윤률_계산_테스트() {
        int profit = 100000;
        int bought = 2005000;
        double result = LottoModel.calcProfitPercentage(profit, bought);
        assertThat(result).isEqualTo(5);
        profit = 128000;
        bought = 3048000;
        result = LottoModel.calcProfitPercentage(profit, bought);
        assertThat(result).isEqualTo(4.2);
    }
}

