package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int inputBudget() { // 기능 나누기 -> validator
        int intBudget;
        String budget = Console.readLine();
        try {
            intBudget = Integer.parseInt(budget);
            if (intBudget % 1000 != 0 && intBudget > 0) { // 하드코딩 제거
                throw new IllegalArgumentException("1000원 단위 정수로 입력해 주세요."); // 하드코딩 제거
            }
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("1000원 단위 정수로 입력해 주세요."); // 하드코딩 제거
        }
        return intBudget;
    }


}
