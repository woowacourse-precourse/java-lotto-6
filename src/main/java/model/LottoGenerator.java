package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        Set<Integer> forDuplication = new HashSet<>(Arrays.asList(userNumbers));
        return new Lotto(new ArrayList<>(forDuplication));
    }
}
