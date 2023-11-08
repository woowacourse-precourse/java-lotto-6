package lotto;

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
        getRateOfReturn(global, lottoPurchaseMoney);
    }

    private static int purchaseLotto(User user) {
        int moneyNumber = 0;
        try {
            String purchaseMoney = user.input("구입금액을 입력해 주세요.");
            return user.getMoneyNumber(purchaseMoney);
        } catch (IllegalArgumentException e) {
            printError("구입 금액은 1,000원으로 나누어 떨어져야 합니다.\n");
            return purchaseLotto(user);
        }
    }

    private static void printError(String message) {
        System.out.println("[ERROR] " + message);
    }

    private static void issueLottos(Global global, int lottoPurchaseMoney) {
        int lottoCount = global.getLottoCount(lottoPurchaseMoney);
        global.getIssuedLottos(lottoCount);
        global.printIssuedLottoCountAndNumbers();
    }

    private static List<Integer> getWinningLotto(User user) {
        String winningNumber = user.input("\n당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = user.convertStringToIntegerList(winningNumber);
        String bonusNumber = user.input("\n보너스 번호를 입력해 주세요.");
        int bonusLotto = user.convertStringToInteger(bonusNumber);
        winningNumbers.add(bonusLotto);
        return winningNumbers;
    }

    private static void getLottoRanking(Global global, List<Integer> winningLotto) {
        global.calculateRanking(winningLotto);
        global.printRanking();
    }

    private static void getRateOfReturn(Global global, int lottoPurchaseMoney) {
        double rateOfReturn = global.calculateRateOfReturn(lottoPurchaseMoney);
        global.printRateOfReturn(rateOfReturn);
    }
}
