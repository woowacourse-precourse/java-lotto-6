package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;


public class myTest extends NsTest {

    @DisplayName("문자열 정수 변환 매소드 테스트")
    @Test
    void myParseIntTest() {
        // given
        final Application myApp = new Application();
        final String price = "1000";
    
        // when
        final int money = myApp.myParseInt(price);
    
        // then
        assertThat(money).isEqualTo(1000);
    }
    
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
