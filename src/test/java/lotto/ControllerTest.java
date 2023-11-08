package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ControllerTest {

    Ui testUi = new Ui();
    Controller testController = new Controller(testUi);

    @Test
    public void testCalculateProfitRate(){

        testController.lottoResults.put(3, 1);
        testController.lottoResults.put(4, 2);
        testController.lottoResults.put(5, 1);
        testController.lottoResults.put(6, 0);
        testController.lottoResults.put(7, 0);

        testController.numOfLotto = 10;

        assertThat(testController.calculateProfitRate()).isEqualTo("16050.0");

        testController.lottoResults.put(3, 3);
        testController.lottoResults.put(4, 0);
        testController.lottoResults.put(5, 0);
        testController.lottoResults.put(6, 0);
        testController.lottoResults.put(7, 0);

        testController.numOfLotto = 80;

        assertThat(testController.calculateProfitRate()).isEqualTo("18.8");
    }
}
