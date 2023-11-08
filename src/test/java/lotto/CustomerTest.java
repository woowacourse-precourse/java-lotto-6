package lotto;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
public class CustomerTest extends NsTest {
    @DisplayName("구매 금액 입력이 천단위가 아니거나 0이면 예외가 발생한다.")
    @Test
    void moneyIsNotThousands() {
        Integer inputMoney1 = 3000;
        Integer result1 = UserInterface.moneyValidate(inputMoney1);

        assertThat(result1 == 3).isTrue();
        assertSimpleTest(() -> {
            runException("1234");
            assertThat(output()).contains("[ERROR] 천원 단위의 금액만 입력가능합니다.");
        });
        assertSimpleTest(()-> {
            runException("0");
            assertThat(output()).contains("[ERROR] 0은 입력할 수 없습니다.");
        });
    }
    @DisplayName("구매한 로또의 내용을 잘 출력하는지 검사")
    @Test
    void printPocketTest() {
        Customer tester = new Customer();
        tester.addPocket(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        tester.addPocket(new Lotto(Arrays.asList(11,12,13,14,15,16)));

        assertSimpleTest(() -> {
            tester.printPocket();
            assertThat(output()).contains("[1, 2, 3, 4, 5, 6]" , "[11, 12, 13, 14, 15, 16]");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
