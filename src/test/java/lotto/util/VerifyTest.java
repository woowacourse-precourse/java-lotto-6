package lotto.util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.util.Verify.verifyBonusNumber;
import static lotto.util.Verify.verifyWinningNumbersStringToList;
import static lotto.util.Verify.verifyAmount;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

public class VerifyTest extends NsTest {
    private static final Integer CAN_BUY_VALUE = 14000;
    private static final String CAN_BUY = "14000";
    private static final Integer CAN_BUY_VALUE2 = 1000;
    private static final String CAN_BUY2 = "1000";
    private static final String CAN_NOT_BUY = "100";
    private static final String CAN_NOT_BUY2 = "999";

    @Test
    void verifyAmount_값이1000원이상일경우() {
        assertSimpleTest(() -> {
            assertThat(verifyAmount(CAN_BUY)).isEqualTo(CAN_BUY_VALUE);
        });
    }

    @Test
    void verifyAmount_값이1000원이상일경우2() {
        assertSimpleTest(() -> {
            assertThat(verifyAmount(CAN_BUY2)).isEqualTo(CAN_BUY_VALUE2);
        });
    }
    @Test
    void verifyAmount_값이1000원미만일경우() {
        assertThatThrownBy(() -> verifyAmount(CAN_NOT_BUY))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void verifyAmount_값이1000원미만일경우2() {
        assertThatThrownBy(() -> verifyAmount(CAN_NOT_BUY2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputVerifyToStringArray_쉼표정확히6개_0부터45까지의숫자_정상(){
        assertSimpleTest(
                ()-> {
                    assertThat(verifyWinningNumbersStringToList("1,2,3,4,5,6"))
                            .isEqualTo(List.of(1,2,3,4,5,6));
                }
        );
    }

    @Test
    void inputVerifyToStringArray_쉼표정확히6개_0부터45까지의숫자_쉼표사이공백처리_정상(){
        assertSimpleTest(
                ()-> {
                    assertThat(verifyWinningNumbersStringToList("1,2,3,4,  5,6"))
                            .isEqualTo(List.of(1,2,3,4,5,6));
                }
        );
    }

    @Test
    void inputVerifyToStringArray_쉼표정확히6개_범위숫자아닌경우() {
        assertThatThrownBy(() -> verifyWinningNumbersStringToList("1,2,3,4,55,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputVerifyToStringArray_숫자가아닌값이들어올경우() {
        assertThatThrownBy(() -> verifyWinningNumbersStringToList("1,2,r,4,sssss, 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void verifyBonusNumber_0부터45까지잘들어온_정상() {
        assertSimpleTest(
                ()-> {
                    assertThat(verifyBonusNumber("44"))
                            .isEqualTo(44);
                }
        );
    }
    @Test
    void verifyBonusNumber_쉼표정확히6개_범위숫자아닌경우() {
        assertThatThrownBy(() -> verifyBonusNumber("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void verifyBonusNumber_숫자가아닌값이들어올경우() {
        assertThatThrownBy(() -> verifyBonusNumber("10s"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        new Verify();
    }
}
