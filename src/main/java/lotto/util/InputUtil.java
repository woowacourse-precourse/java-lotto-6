package lotto.util;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {

    private static final InputUtil instance = new InputUtil();
    private final Validator validator = new Validator();

    private InputUtil() {
    }

    public static InputUtil getInstance() {
        return instance;
    }

    //로또 금액 입력 메소드
    public int inputMoney() {
        System.out.println("입력하세요");
        String moneyInput = "";
        do {
            moneyInput = Console.readLine();
        } while (!validateMoneyInput(moneyInput));
        return Integer.parseInt(moneyInput);
    }

    private boolean validateMoneyInput(String moneyInput) {
        try {
            validator.validateMoney(moneyInput);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //로또 당첨번호 입력 메소드
    public int inputWinningNumbers() {
        String moneyInput = "";
        do {
            moneyInput = Console.readLine();
        } while (!validateWinningNumbers(moneyInput));
        return Integer.parseInt(moneyInput);
    }

    private boolean validateWinningNumbers(String moneyInput) {
        try {
            validator.validateLottoNumbers(moneyInput);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //로또 보너스 당첨번호 입력 메소드
    public int inputBonusNumber() {
        String moneyInput = "";
        do {
            moneyInput = Console.readLine();
        } while (!validateBonusNumber(moneyInput));
        return Integer.parseInt(moneyInput);
    }

    private boolean validateBonusNumber(String moneyInput) {
        try {
            validator.validateLottoBonusNumber(moneyInput);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


}
