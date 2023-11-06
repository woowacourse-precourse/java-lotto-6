package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_TEST_PURCHASE = 10000;

    public static void main(String[] args) {
        int numberOfPurchasedLottos = LOTTO_TEST_PURCHASE/LOTTO_PRICE;

        for (int i = 0; i < numberOfPurchasedLottos; i++){
            Lotto lotto = Lotto.generate();
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers);
        }
    }
}
