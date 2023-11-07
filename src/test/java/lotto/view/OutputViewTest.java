package lotto.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest extends NsTest {

    @DisplayName("소수점 둘째자리에서 반올림될 때 소수점 첫째자리가 변경되는 경우의 수익률을 정확하게 출력할 수 있다.")
    @Test
    void 수익률_소수점_첫째자리_변경_케이스_출력_성공_테스트() {
        assertSimpleTest(() -> {
            OutputView.printProfitRate(71.48142);
            assertThat(output()).isEqualTo("총 수익률은 71.5%입니다.");
        });
    }

    @DisplayName("소수점 둘째자리에서 반올림될 때 소수점 첫째자리가 변경되지 않는 경우의 수익률을 정확하게 출력할 수 있다.")
    @Test
    void 수익률_소수점_첫째자리_그대로_케이스_출력_성공_테스트() {
        assertSimpleTest(() -> {
            OutputView.printProfitRate(62.5289876);
            assertThat(output()).isEqualTo("총 수익률은 62.5%입니다.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}