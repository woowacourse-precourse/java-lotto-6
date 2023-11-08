package lotto.input;

import camp.nextstep.edu.missionutils.Console;

public class BonusNumberInPut {
    static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    static final String ERROR_BONUS_NUMBER_INPUT = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자 여야 합니다.";

    public static int bonusNumberResult(){
        return bonusNumberValidator();
    }
    public static int bonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        int bonusNumber = Integer.parseInt(input);
        System.out.println(bonusNumber);
        return bonusNumber;
    }

    public static int bonusNumberValidator() {
        int bonusNum = -1; //무한 반복 방지

        while (bonusNum < 1 || bonusNum > 45) {
            try {
                bonusNum = bonusNumber();

                if (bonusNum < 1 || bonusNum > 45) {
                    throw new IllegalArgumentException(ERROR_BONUS_NUMBER_INPUT);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNum;
    }
}
