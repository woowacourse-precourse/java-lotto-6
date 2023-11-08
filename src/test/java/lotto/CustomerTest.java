package lotto;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

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

    @DisplayName("원하는 구매횟수 만큼 로또를 구매하는지 검사")
    @Test
    void buyLottosTest() {
        Customer tester = new Customer();
        tester.buyLottos(3);
        tester.printPocket();
        Integer factor1 = output().length();
        Integer factor2 = output().replace("[", "").length();
        assertThat(factor1 - factor2 == 3).isTrue();
    }
    @DisplayName("발행한 로또와 당첨번호를 비교하는 기능 검사")
    @Test
    void judgeSingleLottoTest() {
        Customer tester = new Customer();
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,8));
        tester.addPocket(lotto);
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        Integer bonus = 7;
        int index = 0;
        List<Integer> result = tester.judgeSingleLotto(winningNumbers, bonus, index);
        assertThat(result.get(0) == 5).isTrue();
        assertThat(result.get(1) == 0).isTrue();
    }
    @Test
    void calculatePrizeTest() {
        List<LottoResults> results = Arrays.asList(LottoResults.values());
        results.get(3).setCounts(1);
        results.get(4).setCounts(1);
        Integer prize = Customer.calculatePrize(results);
        assertThat(prize).isEqualTo(55000);
    }
    @Test
    void calculatePrizeRateTest() {
        Integer prize = 5000;
        Integer money = 8000;
        Double prizeRate = Customer.calculatePrizeRate(prize, money);
        assertThat(prizeRate).isEqualTo(62.5);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
