package lotto.domain;

import org.junit.jupiter.api.Test;

public class LottoGenerateTest {

    @Test
    public void generateTest(){
        LottoGenerator lottoGenerator = new LottoGenerator(1);
        System.out.println(lottoGenerator.getMyLotto().get(0).getNumbers());
    }
}
