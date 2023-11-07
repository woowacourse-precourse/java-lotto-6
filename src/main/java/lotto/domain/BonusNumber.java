package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class BonusNumber {

    private int number;

    public BonusNumber(String number) {
        try {
            validateNumber(number);
            validateRange(number);
            this.number = Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            new BonusNumber(Console.readLine());
        }
    }

    public void validateNumber(String number){
        try {
            int num = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자가 아닙니다.");
        }
    }

    public void validateRange(String number) {
            if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
    }

    public int getNumber() {
        return number;
    }
}
