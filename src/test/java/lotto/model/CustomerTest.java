package lotto.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CustomerTest extends NsTest {
    @DisplayName("Customer 객체 생성시 매개변수 값이 숫자가 아니면 안된다.")
    @Test
    void createCustomerByNotNumber() {
        assertThatThrownBy(() -> new Customer("w1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Customer 객체 생성시 매개변수 값이 음수이면 안된다.")
    @Test
    void createCustomerByNegativeNumber() {
        assertThatThrownBy(() -> new Customer("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Customer 객체 생성시 매개변수 값이 1000의 배수가 아니면 안된다. 안된다.")
    @Test
    void createCustomerByNotMultiple1000() {
        assertThatThrownBy(() -> new Customer("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매시 중복되는 숫자가 있으면 에러 출력 후 재발행한다.")
    @Test
    void reissueDuplicateLotto() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Customer customer = new Customer("2000");
                    customer.buyLotto();
                    customer.buyLotto();
                    List<Lotto> lottos = customer.getLottos();
                    for (Lotto lotto: lottos) {
                        System.out.println(lotto.getNumbers());
                    }
                    assertThat(output()).contains(
                            "[8, 21, 23, 41, 42, 43]",
                            "[ERROR] LOTTO NUMBERS MUST NOT CONTAINS DUPLICATE NUMBERS",
                            "[6, 43, 23, 41, 42, 35]"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(6, 43, 23, 41, 42, 43),
                List.of(6, 43, 23, 41, 42, 35)
        );
    }

    @DisplayName("throwLastLotto 메소드 실행시 마지막에 구매한 로또가 버려져야 한다.")
    @Test
    void throwLastLottoByCustomer() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Customer customer = new Customer("2000");
                    customer.buyLotto();
                    customer.buyLotto();
                    customer.throwLastLotto();
                    List<Lotto> lottos = customer.getLottos();

                    assertThat(lottos.size())
                            .isEqualTo(1);

                    assertThat(lottos.get(0).getNumbers().toString())
                            .contains("[6, 43, 23, 41, 42, 35]");
                    },
                List.of(6, 43, 23, 41, 42, 35),
                List.of(8, 21, 23, 41, 42, 43)

        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
