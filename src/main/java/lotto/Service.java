package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Service {
    //1. 로또 구입 금액 숫자인지 확인
    public static int isNumber(String howMuch) {
        int result = 0;
        try {
            result = Integer.parseInt(howMuch);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요");
        }
        return result;
    }

    //2. 로또 개수 계산
    public static int numberOfLottery(int howMuch) {
        if (howMuch%1000 == 0) {
            return howMuch/1000;
        }
        throw new IllegalArgumentException("[ERROR] 구입 금액은 1000의 배수여야 합니다.");
    }

    //2. 보너스 번호 입력받고 반환

}
