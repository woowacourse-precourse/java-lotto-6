package mytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import lotto.Lotto;
import model.LottoGenerator;
import model.MainModel;
import model.Rank;

public class TestEnumMap {
    static EnumMap<Rank,Integer> generateEnumMap()
    {
        List<Lotto> testList = new ArrayList<>();
        Lotto[] testLottos = new Lotto[] {new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)),
                new Lotto(Arrays.asList(3, 5, 11, 41, 42, 43))};
        testList.add(testLottos[0]);
        testList.add(testLottos[1]);
        MainModel testModel =  new MainModel(testList);
        Lotto userLotto = LottoGenerator.generateLotto(new Integer[] {3,5,8,41,42,43});
        return testModel.judgeLotto(userLotto,11);
    }
}
