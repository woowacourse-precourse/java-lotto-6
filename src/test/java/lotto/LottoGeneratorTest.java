package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoGeneratorTest {

    @Test
    public void 생성된_수가_6개인가() {
        //given
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lotto = lottoGenerator.create();
        List<Integer> lottoNumbers = lotto.getNumbers();

        //then
        assertEquals(6, lottoNumbers.size());
    }

    @Test
    public void 중복되지_않은_수를_반환하는가() {
        //given
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lotto = lottoGenerator.create();
        List<Integer> lottoNumbers = lotto.getNumbers();

        //when
        int size = (int)lottoNumbers.stream()
                .distinct()
                .count();

        //then
        assertEquals(6, size);
    }
}
