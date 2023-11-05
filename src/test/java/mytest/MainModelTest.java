package mytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import lotto.Lotto;
import model.LottoGenerator;
import model.MainModel;
import model.Rank;
import org.junit.jupiter.api.Test;
import view.Mainview;

import static org.assertj.core.api.Assertions. *;

public class MainModelTest
{
    @Test
    void jdugeLoottoTest()
    {
        List<Lotto> testList = new ArrayList<>();
        Lotto[] testLottos = new Lotto[] {new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)),
        new Lotto(Arrays.asList(3, 5, 11, 41, 42, 43))};
        testList.add(testLottos[0]);
        testList.add(testLottos[1]);
        MainModel testModel =  new MainModel(testList);
        Lotto userLotto = LottoGenerator.generateLotto(new Integer[] {3,5,8,41,42,43});
        EnumMap<Rank, Integer> testMap = testModel.judgeLotto(userLotto,11);
        Integer[] testWinningCount = new Integer[] {0,1,0,1,0};

        Mainview view = new Mainview();
        view.printresult(testMap);
        int count = 0;
        for(Rank rank : Rank.values())
        {
            assertThat(testMap.getOrDefault(rank,0)).isEqualTo(testWinningCount[count]);
        }

    }
}
