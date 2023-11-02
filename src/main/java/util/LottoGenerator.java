package util;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoGenerator {
    private LottoGenerator() {
    }

    public static List<Lotto> generateLotto(int times)
    {
        List<Lotto> lotto = new ArrayList<>();

        for(int i = 0; i < times; i++)
        {
           lotto.add(NumberGenerator.generateNumbers());
        }
    }
}
