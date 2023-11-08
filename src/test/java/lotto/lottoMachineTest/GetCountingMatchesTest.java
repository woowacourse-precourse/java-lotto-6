package lotto.lottoMachineTest;

import lotto.Lotto;
import lotto.LottoMachine;
import lotto.LottoResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
public List<LottoResult> getCountingMatches(Lotto lotto, int bonus, List<List<Integer>> myLottos) {
    List<LottoResult> count = new ArrayList<>();
    myLottos.forEach(i -> {
        count.add(new LottoResult(i, lotto, bonus));
    });
    return count;
}
*/
public class GetCountingMatchesTest {
    @Test
    public void myLottos에_있는_정보를_LottoResult로_바꾸기() {
        LottoMachine lottoMachine = new LottoMachine(new DecimalFormat("#.##"));
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonus = 10;
        List<List<Integer>> myLotto = new ArrayList<>();
        myLotto.add(Arrays.asList(2, 3, 4, 5, 6, 7));
        myLotto.add(Arrays.asList(7, 8, 9, 10, 11, 12));
        myLotto.add(Arrays.asList(2, 4, 6, 8, 10, 12));
        List<LottoResult> ret = lottoMachine.getCountingMatches(lotto, bonus, myLotto);
        List<LottoResult> expected = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            expected.add(new LottoResult(myLotto.get(i), lotto, bonus));
        }
        for (int i = 0; i < 3; i++) {
            Assertions.assertThat(ret.get(i).getCount()).isEqualTo(expected.get(i).getCount());
            Assertions.assertThat(ret.get(i).getBonus()).isEqualTo(expected.get(i).getBonus());
        }
    }
}
