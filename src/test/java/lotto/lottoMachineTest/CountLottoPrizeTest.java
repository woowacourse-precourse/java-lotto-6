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
import java.util.TreeMap;

import static lotto.enums.LottoPrize.*;

/*
public TreeMap<LottoPrize, Integer> countLottoPrize(List<LottoResult> lottoResults) {
    TreeMap<LottoPrize, Integer> count = new TreeMap<>();
    lottoResults.forEach(lottoResult -> {
        LottoPrize item = lottoResultToLottoPrize(lottoResult);
        count.put(item, count.getOrDefault(item, 0)+1);
    });
    return count;
}
*/
public class CountLottoPrizeTest {
    @Test
    public void LottoResult가_LottoPrize로_제대로_변환되나() {
        LottoMachine lottoMachine = new LottoMachine(new DecimalFormat("#.##"));
        List<LottoResult> lottoResults = new ArrayList<>();
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonus = 10;
        lottoResults.add(new LottoResult(Arrays.asList(2, 4, 6, 8, 10, 12), lotto, bonus));
        lottoResults.add(new LottoResult(Arrays.asList(1, 2, 3, 4, 5, 10), lotto, bonus));
        lottoResults.add(new LottoResult(Arrays.asList(1, 2, 3, 4, 5, 9), lotto, bonus));
        lottoResults.add(new LottoResult(Arrays.asList(1, 2, 3, 4, 5, 6), lotto, bonus));
        TreeMap count = lottoMachine.countLottoPrize(lottoResults);
        Assertions.assertThat(count.get(MATCH_3)).isEqualTo(1);
        Assertions.assertThat(count.get(MATCH_5_BONUS)).isEqualTo(1);
        Assertions.assertThat(count.get(MATCH_5)).isEqualTo(1);
        Assertions.assertThat(count.get(MATCH_6)).isEqualTo(1);
    }
}
