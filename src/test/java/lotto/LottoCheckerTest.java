package lotto;

import lotto.model.Lotto;
import lotto.model.LottoChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoCheckerTest {
    @DisplayName("당첨 번호에 포함된 로또 번호의 개수를 구한다.")
    @Test
    void compareLottoWithWinningLotto() {
        Lotto lotto = new Lotto(Arrays.asList(4,7,13,33,24,31)); // - 0
        Lotto lotto2 = new Lotto(Arrays.asList(30, 1, 37, 20, 29, 40));// - 4
        Lotto lotto3 = new Lotto(Arrays.asList(30, 38, 16, 37, 15, 40)); // - 5, 1

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);
        lottos.add(lotto2);
        lottos.add(lotto3);

        List<Integer> winningNumbers = Arrays.asList(40,30,37,38,16,20);

        int bonusNumber = 15;

        LottoChecker checker = new LottoChecker(lottos, winningNumbers, bonusNumber);
        checker.checkLottoWithWinningLotto();
        int[] result = checker.getSameNumberCount();
        int[] expectResult = {0, 1, 0, 1, 0};

        assertThat(result).isEqualTo(expectResult);
    }
}
