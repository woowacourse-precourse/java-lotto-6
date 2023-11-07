package lotto;

import lotto.controller.LottoMachine;
import lotto.controller.PurchaseMachine;
import lotto.controller.ResultMachine;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class MachineTest {
    private final LottoMachine lottoMachine = new LottoMachine();
    private final PurchaseMachine purchaseMachine = new PurchaseMachine();
    private final ResultMachine resultMachine = new ResultMachine();

    @DisplayName("보너스 숫자가 당첨 로또 숫자 안에 포함될 경우 예외가 발생한다.")
    @Test
    void bonusNumberInLotto() {
        int bonusNumber = 5;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> lottoMachine.containsCheckBonusNumber(bonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("리스트가 오름차순으로 정렬되는지 확인한다.")
    @Test
    void numberInOneToFortyFive() {
        List<Integer> normal = List.of(4, 9, 37, 1, 39, 22);
        List<Integer> sorted = purchaseMachine.sortedByAsc(normal);

        assertThat(sorted).isEqualTo(List.of(1, 4, 9, 22, 37, 39));
    }

    @DisplayName("당첨 로또의 숫자 중 몇개의 숫자가 일치하는지 확인한다.")
    @Test
    void howManyHits() {
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 4, 5, 9, 11, 17));
        int hits = resultMachine.getRank(myLotto, winningLotto);

        assertThat(hits).isEqualTo(3);
    }
}
