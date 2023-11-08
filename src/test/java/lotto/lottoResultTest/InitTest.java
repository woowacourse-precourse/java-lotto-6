package lotto.lottoResultTest;

import lotto.Lotto;
import lotto.LottoResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class InitTest {
    @Test
    public void 초기화가_제대로_됐나_오류없음1() {
        List<Integer> myLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
        int bonus = 1;
        LottoResult lottoResult = new LottoResult(myLotto, lotto, bonus);
        Assertions.assertThat(lottoResult.getCount()).isEqualTo(3);
        Assertions.assertThat(lottoResult.getBonus()).isEqualTo(true);
    }

    @Test
    public void 초기화가_제대로_됐나_오류없음2() {
        List<Integer> myLotto = Arrays.asList(5, 4, 8, 7, 9, 6);
        Lotto lotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
        int bonus = 1;
        LottoResult lottoResult = new LottoResult(myLotto, lotto, bonus);
        Assertions.assertThat(lottoResult.getCount()).isEqualTo(6);
        Assertions.assertThat(lottoResult.getBonus()).isEqualTo(false);
    }
}
