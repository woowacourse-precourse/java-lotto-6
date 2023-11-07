package lotto.model;

import java.util.List;
import lotto.Lotto;
import lotto.utils.NumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    @Test
    void 입력된_금액에_맞게_로또가_만들어지나() {
        //given
        int buyPrice = 12000;
        LottoGenerator lottoGenerator = new LottoGenerator();
        NumberGenerator numberGenerator = new LottoNumberGenerator();
        //when
        List<Lotto> lottoList = lottoGenerator.generate(buyPrice, numberGenerator);
        //then
        Assertions.assertEquals(12, lottoList.size());
    }
}
