package lotto.sevice;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class GameServiceTest extends NsTest{

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static int NUMBER_START_RANGE = 1;
    private static int NUMBER_END_RANGE = 45;

    private final Buyer buyer = new Buyer();
    private final WinningNumbers winningNumbers = new WinningNumbers();
    @DisplayName("구매 금액 입력이 제대로 이루어졌는지 확인")
    @Test
    void savePurchaseAmountTest() {

        String input = "8000";

        int money = Integer.parseInt(input);
        buyer.saveAmount(money);

        System.out.println(buyer.getAmount());
    }

    @DisplayName("구매한 로또 번호 제대로 생성 되는지 확인")
    @Test
    void savePurchaseNumbers() {

        int amount = 3;

        for(int i=0; i<amount; i++) {

            List<Integer> numbers = createNumbers();

            buyer.saveNumbers(numbers);
        }

        List<Lotto> numbersTest = buyer.getLottos();

        for(Lotto lotto : numbersTest){

            for(int i=0; i<6; i++){
               System.out.print(lotto.getNumbers().get(i)+" ");
            }

            System.out.println();
        }
    }

    private List<Integer> createNumbers() {

        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 6) {

            int number = Randoms.pickNumberInRange
                    (NUMBER_START_RANGE, NUMBER_END_RANGE);

            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }

        return numbers;
    }

    @DisplayName("당첨 번호, 보너스 번호 입력이 제대로 이루어졌는지 확인")
    @Test
    void saveWinningNumbersTest() {

        String input = "1,2,3,4,5,6";

        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt).toList();

        winningNumbers.saveWinningNumbers(numbers);

        int bonusNumber = 7;

        winningNumbers.saveBonusNumber(bonusNumber);

        List<Integer> numbersTest = winningNumbers.getNumbers();

        for(int num : numbersTest){

            System.out.print(num+" ");
        }

        System.out.println(winningNumbers.getBonusNumber());
    }

    @Override
    protected void runMain() {

    }
}
