package mytest;

import java.util.EnumMap;
import model.ProfitCalculator;
import model.Rank;
import org.junit.jupiter.api.Test;
import view.MainView;

import static org.assertj.core.api.Assertions. *;

public class ProfiCalculatorTest {

    @Test
    void calculateRateOfProfit()
    {
        assertThat(new ProfitCalculator().calculateRateOfProfit("8000",5000)).
                isEqualTo("62.5");
    }
    @Test
    void calculateProfit()
    {
        MainView view = new MainView();
        EnumMap<Rank, Integer> testMap = TestEnumMap.generateEnumMap();
        view.printresult(testMap);
        assertThat(new ProfitCalculator().calculateProfit(testMap)).isEqualTo(30050000);
    }
}
