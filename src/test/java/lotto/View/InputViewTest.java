package lotto.View;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.View.InputView.getHowMuchLottoWillYouBuy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class InputViewTest extends NsTest {
    private static final Integer CAN_BUY_VALUE = 14000;
    private static final String CAN_BUY = "14000";
    private static final Integer CAN_BUY_VALUE2 = 1000;
    private static final String CAN_BUY2 = "1000";
    private static final String CAN_NOT_BUY = "100";
    private static final String CAN_NOT_BUY2 = "999";

//    @Test
//    void 사용자가금액입력시값테스트하기(){
//        assertSimpleTest(
//                () -> {
//                    run(CAN_BUY);
//                    assertThat(getHowMuchLottoWillYouBuy()).isEqualTo(CAN_BUY_VALUE);
//                }
//        );
//    }
//
//    @Test
//    void 사용자가금액입력시값테스트하기_경계값테스트(){
//        assertSimpleTest(
//                () -> {
//                    run(CAN_BUY2);
//                    assertThat(getHowMuchLottoWillYouBuy()).isEqualTo(CAN_BUY_VALUE2);
//                }
//        );
//    }

//    @Test
//    void 값이1000원미만일경우1() {
//        assertSimpleTest(
//                () -> {
//                    runException(CAN_NOT_BUY);
//                    assertThat(output()).isInstanceOf(IllegalArgumentException.class);
//                }
//        );
//    }

//    @Test
//    void 값이1000원미만일경우2() {
//        assertSimpleTest(
//                () -> assertThatThrownBy(() -> runException(CAN_NOT_BUY))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }

    @Override
    public void runMain(){
        new InputView();
    }
}
