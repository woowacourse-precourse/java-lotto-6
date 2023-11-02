package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;

public class LottoGenerator {
    private LottoGenerator() {
    }

    private final static int USER_TIME = 1;

    public static List<Lotto> generateLotto(int times)
    {
        List<Lotto> lotto = new ArrayList<>();

        for(int i = 0; i < times; i++)
        {
           lotto.add(NumberGenerator.generateNumbers());
        }
        return lotto;
    }

    public static Lotto generateLotto(Integer[] userNumbers)
    {
        return new Lotto(Arrays.asList(userNumbers));
    }
}
