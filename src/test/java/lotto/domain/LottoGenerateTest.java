package lotto.domain;

import lotto.util.Constants;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LottoGenerateTest {

    @Test
    public void generateTest() {
        LottoGenerator lottoGenerator = new LottoGenerator(1);
        System.out.println(lottoGenerator.getMyLotto().get(0).getNumbers());
    }

    @Test
    public void printLotto() {
        LottoGenerator lottoGenerator = new LottoGenerator(5);
        for (Lotto lotto : lottoGenerator.getMyLotto()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
