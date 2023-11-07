package lotto.readUserInput;


import camp.nextstep.edu.missionutils.Console;
import lotto.validation.ErrorValidation;

public class BonusNumbers implements UserInput {
    public static int number;

    public void read() {
        number = singleTypeConversion(userInput());
    }

    public String userInput() {
        String readNumber = Console.readLine();
        try {
            ErrorValidation.isNumberVerify(readNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 보너스 번호는 숫자만 입력 가능 합니다.");
            readNumber = userInput();
        }
        return readNumber;
    }

    public int singleTypeConversion(String readSingleNumber) {
        int bonusNumber = Integer.parseInt(readSingleNumber);
        try {
            ErrorValidation.isNumberInRange(bonusNumber);
            ErrorValidation.isAlreadyReadNumber(WinningNumbers.numbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없고 1부터 45 사이의 숫자여야 합니다.");
            bonusNumber = Integer.parseInt(userInput());
        }
        return bonusNumber;
    }









}
