package lotto.inputAction;

import camp.nextstep.edu.missionutils.Console;

public class InputBonusNumber {
    public int inputBonusNumber() {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                return readAndValidateBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int readAndValidateBonusNumber() {
        try {
            int bonusNumber = Integer.parseInt(Console.readLine().trim());
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식의 데이터를 입력해 주세요.");
        }
    }
}
