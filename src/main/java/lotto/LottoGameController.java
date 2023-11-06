package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGameController {

    private static final int UNIT = 1000;

    private LottoGame lottoGame;

    public void gameInit() {
        String userInput;
        do {
            System.out.println("구매금액을 입력해주세요.");
            userInput = receiveUserInput();
        } while(isInvalidUserInput(userInput));

        int numOfPurchase = Integer.parseInt(userInput)/UNIT;
        System.out.println(numOfPurchase + "개를 구매했습니다.");
        this.lottoGame = new LottoGame(numOfPurchase);
    }

    public void runGame() {
        gameInit();
        Lottos lottos = lottoGame.issueLottos();
        System.out.println(lottos);
    }

    public static boolean isInvalidUserInput(String userInput) {
        return !(isValidInputIsNumber(userInput) && isValidAmountUnit(Integer.parseInt(userInput)));
    }

    private static String receiveUserInput() {
        String userInput = Console.readLine();
        return userInput;
    }

    private static boolean isValidInputIsNumber(String userInput) {
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
}
