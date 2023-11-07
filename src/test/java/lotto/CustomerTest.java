package lotto;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class CustomerTest extends NsTest {
    @DisplayName("구매 금액 입력이 천단위가 아니거나 0이면 예외가 발생한다.")
    @Test
    void moneyIsNotThousands() {
        Integer inputMoney1 = 3000;
        Integer inputMoney2 = 1234;
        Integer inputMoney3 = 0;
        Integer result1 = Customer.moneyValidate(inputMoney1);

        assertThat(result1 == 3).isTrue();
        assertThatThrownBy(() -> Customer.moneyValidate(inputMoney2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Customer.moneyValidate(inputMoney3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void printPocketTest() {
        Customer tester = new Customer();
        tester.addPocket(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        tester.addPocket(new Lotto(Arrays.asList(11,12,13,14,15,16)));

        Assertions.assertSimpleTest(() -> {
            tester.printPocket();
            assertThat(output()).contains("[1, 2, 3, 4, 5, 6]" , "[11, 12, 13, 14, 15, 16]");
        });


    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
