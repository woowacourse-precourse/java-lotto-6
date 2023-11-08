package lotto;

import java.util.List;

public class Service {

    private static final int UPPERBOUND = 45;
    private static final int LOWERBOUND = 1;


    //1. 입력한 것이 숫자인지 확인
    public static int isNumber(String input) {
        int result = 0;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력하세요");
            throw new IllegalArgumentException();
        }
        return result;
    }

    //2. 로또 개수 계산
    public static int numberOfLottery(int howMuch) {
        if (howMuch%1000 == 0) {
            return howMuch/1000;
        }
        System.out.println("[ERROR] 구입 금액은 1000의 배수여야 합니다.");
        throw new IllegalArgumentException();
    }

    //3. 보너스 번호가 1~45 숫자인지 확인
    public static void rangeValidation(int number) {
        if (LOWERBOUND <= number && number <= UPPERBOUND) {
            return;
        }
        System.out.println("[ERROR] 1과 45 사이의 정수만 입력할 수 있습니다");
        throw new IllegalArgumentException();
    }

    //4. 보너스 번호가 당첨 번호 리스트에 있는지 확인
    public static void bonusRedundancyCheck(List<Integer> numbers, int bonus) {
        if (!numbers.contains(bonus)) {
            return;
        }
        System.out.println("[ERROR] 당첨 번호로 입력했던 숫자는 보너스 번호가 될 수 없습니다");
        throw new IllegalArgumentException();
    }

}
