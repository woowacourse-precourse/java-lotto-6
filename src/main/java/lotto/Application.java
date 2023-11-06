package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println("당첨 번호를 쉼표로 구분하여 입력하세요.");
        String winningLottoNumbersInput = Console.readLine();
        List<Integer> winningNumbers = new ArrayList<>();
        for (String s : winningLottoNumbersInput.split(",")) {
            String trim = s.trim();
            Integer parseInt = Integer.parseInt(trim);
            winningNumbers.add(parseInt);
        }
        System.out.println("입력된 당첨 번호: " + winningNumbers);
    }

}
