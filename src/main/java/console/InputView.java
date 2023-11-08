package console;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String NOT_NUMBER = "[ERROR] 유효한 숫자를 입력하세요.";
    private static final String INVALID_MONEY = "[ERROR] 입력한 금액은 1000원 단위로 입력해야 합니다.";
    private static final String INVALID_BOUND = "[ERROR] 숫자는 1~45 사이여야 합니다.";
    private static final String BONUS_NUMBER_DUPLICATED = "[ERROR] 입력하신 숫자는 이미 로또에 존재합니다.";
    private static final String DELIMITER = ",";
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int MONEY_UNIT = 1000; // 돈의 단위 숫자

    private InputView() {
        throw new UnsupportedOperationException();
    }

    public static Integer getMoney() {
        Integer money = null;
        boolean validInput = false;
        while (!validInput) {
            try {
                money = parseStringToMoney();
                validInput = true;
            } catch (NumberFormatException e) {
                OutputView.printError(NOT_NUMBER);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
        return money;
    }

    public static Lotto getLottoInput() {
        Lotto lotto = null;
        boolean validInput = false;
        while (!validInput) {
            try {
                lotto = convertStringInputToLotto();
                validInput = true;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
        return lotto;
    }

    public static Integer getBonusNumberByUser(Lotto lotto) {
        Integer bonusNumber = null;
        boolean validInput = false;
        while (!validInput) {
            try {
                bonusNumber = getBonusNumber(lotto);
                validInput = true;
            } catch (NumberFormatException e) {
                OutputView.printError(NOT_NUMBER);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
        return bonusNumber;
    }

    private static int getBonusNumber(Lotto lotto) {
        int bonusNumber = -1;
        boolean validInput = false;
        while (!validInput) {
            String userInput = Console.readLine();
            bonusNumber = getIntegerInput(userInput);
            if (lotto.containsBonusNumber(bonusNumber)) {
                OutputView.printError(BONUS_NUMBER_DUPLICATED);
            } else {
                validInput = true;
            }
        }
        return bonusNumber;
    }

    public static Lotto convertStringInputToLotto() {
        Lotto lotto = null;
        boolean validInput = false;
        while (!validInput) {
            try {
                String userInput = Console.readLine();
                String[] split = userInput.split(DELIMITER);
                List<Integer> lottoNumberList = Arrays.stream(split)
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList();
                lotto = new Lotto(lottoNumberList);
                validInput = true;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
        return lotto;
    }

    private static int getIntegerInput(String userInput) {
        int bonusNumber = Integer.parseInt(userInput);
        if (bonusNumber > MAX_NUMBER || bonusNumber < MIN_NUMBER) {
            throw new IllegalArgumentException(INVALID_BOUND);
        }
        return bonusNumber;
    }

    private static int parseStringToMoney() {
        int money = Integer.parseInt(Console.readLine());
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_MONEY);
        }
        return money;
    }
}
