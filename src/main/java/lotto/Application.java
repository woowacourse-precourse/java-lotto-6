package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        startLotto();
    }

    private static void startLotto() {
        User user = new User();
        Global global = new Global();

        int money = user.inputAmountOfMoney();
        int lottoCount = global.getLottoCount(money);
        global.getIssuedLottoList(lottoCount);
        global.printIssuedLottoCountAndList();
        getWinningLotto(user);
    }

    private static void getWinningLotto(User user) {
        String winningNumbers = user.inputWinningNumbers();
        List<Integer> winningLotto = convertStringToIntegerList(winningNumbers);
        String bonusNumber = user.inputBonusNumbers();
        int bonusLotto = convertStringToInteger(bonusNumber);
    }

    private static List<Integer> convertStringToIntegerList(String input) {
        List<Integer> resultNumbers = new ArrayList<>();
        String[] inputNumbers = input.split(",");

        for (String inputNumber : inputNumbers) {
            int number = convertStringToInteger(inputNumber);
            resultNumbers.add(number);
        }
        return resultNumbers;
    }

    private static Integer convertStringToInteger(String number) {
        return Integer.parseInt(number);
    }
}
