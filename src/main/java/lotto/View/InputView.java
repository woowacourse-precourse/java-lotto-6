package lotto.View;

import static lotto.Util.Constants.DELIMITER;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final InputValidator inputValidator;
    private final String BUY_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final InputView INSTANCE = new InputView(InputValidator.getInstance());

    private InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public static InputView getInstance() {
        return INSTANCE;
    }

    public String receiveBuyPrice() {
        System.out.println(BUY_PRICE_MESSAGE);
        String inputMoney = Console.readLine();
        inputValidator.validateInputMoney(inputMoney);
        return inputMoney;
    }

    public String[] receiveWinningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        String inputWinningNum = Console.readLine();
        inputValidator.validateInputWinningNumbers(inputWinningNum);
        return inputWinningNum.split(DELIMITER);
    }

    public String receiveBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        String inputBonusNum = Console.readLine();
        inputValidator.validateInputBonusNumber(inputBonusNum);
        return inputBonusNum;
    }

}
