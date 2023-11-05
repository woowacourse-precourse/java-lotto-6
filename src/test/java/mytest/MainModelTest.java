package mytest;


import java.util.EnumMap;
import model.Rank;
import org.junit.jupiter.api.Test;
import view.Mainview;

import static org.assertj.core.api.Assertions. *;

public class MainModelTest
{
    @Test
    void jdugeLoottoTest()
    {
       EnumMap<Rank,Integer> testMap = TestEnumMap.generateEnumMap();
        Integer[] testWinningCount = new Integer[] {0,1,0,1,0};

        Mainview view = new Mainview();
        view.printresult(testMap);
        int count = 0;
        for(Rank rank : Rank.values())
        {
            assertThat(testMap.getOrDefault(rank,0)).isEqualTo(testWinningCount[count++]);
        }

    }
}
