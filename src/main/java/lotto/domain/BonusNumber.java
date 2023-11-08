package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class BonusNumber {

    private int number;


    /**
     * 1. 생성자에서 예외 상황 검증 후 저장
     * 2. 예외 발생할 경우, 재입력 요청
     */
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


    /**
     * 숫자로 입력했는지 검증
     */
    public void validateNumber(String number){
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자가 아닙니다.");
        }
    }

    /**
     * 로또 번호 범위 (1~45) 내의 숫자인지 검증
     */
    public void validateRange(String number) {
            if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
    }

    public int getNumber() {
        return number;
    }
}
