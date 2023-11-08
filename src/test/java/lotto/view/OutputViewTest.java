package lotto.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest extends NsTest {

    @DisplayName("수익률 출력 시 3자릿수마다 쉼표(,)를 출력한다.")
    @Test
    void getRateOfReturnWithThousandsComma() {
        assertSimpleTest(() -> {
            OutputView.printRateOfReturn(123456.7);
            assertThat(output()).contains("123,456.7");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
