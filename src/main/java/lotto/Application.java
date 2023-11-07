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

        int lottoPurchaseMoney = purchaseLotto(user);
        issueLottos(global, lottoPurchaseMoney);
        List<Integer> winningLotto = getWinningLotto(user);
        getLottoRanking(global, winningLotto);
    }

    private static int purchaseLotto(User user) {
        String purchaseMoney = user.input("구입금액을 입력해 주세요.");
        return convertStringToInteger(purchaseMoney);
    }

    private static void issueLottos(Global global, int lottoPurchaseMoney) {
        int lottoCount = global.getLottoCount(lottoPurchaseMoney);
        global.getIssuedLottos(lottoCount);
        global.printIssuedLottoCountAndNumbers();
    }

    private static List<Integer> getWinningLotto(User user) {
        String winningNumber = user.input("\n당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = convertStringToIntegerList(winningNumber);
        String bonusNumber = user.input("\n보너스 번호를 입력해 주세요.");
        int bonusLotto = convertStringToInteger(bonusNumber);
        winningNumbers.add(bonusLotto);
        return winningNumbers;
    }

    private static void getLottoRanking(Global global, List<Integer> winningLotto) {
        global.calculateRanking(winningLotto);
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
