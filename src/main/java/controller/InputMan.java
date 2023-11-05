package controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import validation.ValidationMan;

public class InputMan {
    private ValidationMan validationMan;

    public InputMan(ValidationMan validationMan) {
        this.validationMan = validationMan;
    }

    int receiveMoney() throws IllegalArgumentException {
        String money = Console.readLine();
        if (!validationMan.validateMoney(money)) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야 하고 숫자만 입력해야 합니다.");
        }
        return Integer.parseInt(money);
    }

    Integer[] receiveNumbers() {
        String[] cutNumbers = cutNumbers(Console.readLine());
        if (!validationMan.validateNumbers(cutNumbers)) {
            throw new IllegalArgumentException("[ERROR] 제대로 된 값을 입력하세요.");
        }
        return arrayParseInt(cutNumbers);
    }

    private String[] cutNumbers(String userNumbers) {
        String[] cutNNumbers = userNumbers.split(",");
        for (int i = 0; i < cutNNumbers.length; i++) {
            cutNNumbers[i] = cutNNumbers[i].trim();
        }
        return cutNNumbers;
    }

    private Integer[] arrayParseInt(String[] cutNumbers) {
        Integer[] userNumbers = new Integer[cutNumbers.length];
        for (int i = 0; i < userNumbers.length; i++) {
            userNumbers[i] = Integer.parseInt(cutNumbers[i]);
        }
        return userNumbers;
    }

    int receiveBonusNumber(Lotto userLotto) throws IllegalArgumentException {
        String userBonusNumber = Console.readLine();
        if (!validationMan.valudateBonusNumber(userLotto, userBonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 제대로 된 값을 입력하세요.");
        }
        return Integer.parseInt(userBonusNumber);
    }
}
