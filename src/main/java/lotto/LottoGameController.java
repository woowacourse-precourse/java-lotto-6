package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGameController {

    private static final int UNIT = 1000;

    private LottoGame lottoGame;

    public void purchaseLotto() {
        int numOfPurchase = calcNumOfPurchase();
        System.out.println(numOfPurchase + "개를 구매했습니다.");
        this.lottoGame = new LottoGame(numOfPurchase);
        System.out.println(lottoGame.issueLottos());
    }

    private static int calcNumOfPurchase() {
        int amount = processAmount();
        int numOfPurchase = amount / UNIT;
        return numOfPurchase;
    }

    private static int processAmount() {
        String userInput;
        do {
            System.out.println("구매금액을 입력해주세요.");
            userInput = receiveAmount();
        } while (isInvalidAmount(userInput));
        return Integer.parseInt(userInput);
    }


    public void setWinningNumbers() {

    }

    public void runGame() {
        purchaseLotto();

    }

    public static boolean isInvalidAmount(String userInput) {
        return !(isNumber(userInput)
                && isValidAmountUnit(Integer.parseInt(userInput))
                && isNaturalNumber(Integer.parseInt(userInput)));
    }

    private static String receiveAmount() {
        String userInput = Console.readLine();
        return userInput;
    }

    private static boolean isNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            ExceptionHandler.handleException("구입 금액으로 숫자를 입력해주세요.");
            return ExceptionHandler.EXCEPTION_OCCURED;
        }
        return ExceptionHandler.NO_EXCEPTION;
    }

    private static boolean isValidAmountUnit(int amount) {
        if ((amount % UNIT) != 0) {
            ExceptionHandler.handleException("구입 금액을 1,000원 단위로 입력해주세요.");
            return ExceptionHandler.EXCEPTION_OCCURED;
        }
        return ExceptionHandler.NO_EXCEPTION;
    }

    private static boolean isNaturalNumber(int amount) {
        if (amount <= 0) {
            ExceptionHandler.handleException("구입 금액을 자연수로 입력해주세요.");
            return ExceptionHandler.EXCEPTION_OCCURED;
        }
        return ExceptionHandler.NO_EXCEPTION;
    }
}
