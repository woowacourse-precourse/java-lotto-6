package lotto.service;

import java.util.List;
import lotto.utils.UserNumbersUtils;

public class LottoService {
    // 서비스와 관련된 기능 구현 (로또 티켓 구매, 로또 티켓 출력, 로또 번호 입력, 로또 번호 예외 처리, 로또 결과 출력)
    private int money;

    public static void userInputMoney(String userInput) {
        MoneyValidator.validate(userInput);
    }

    public static void userInputNumbers(String userInput) {
        UserNumbersValidator.preValidate(userInput);
        List<Integer> numbers = UserNumbersUtils.convert(userInput);
        UserNumbersValidator.postValidate(numbers);
        List<Integer> sortedNumbers = UserNumbersUtils.sort(numbers);
    }
}
