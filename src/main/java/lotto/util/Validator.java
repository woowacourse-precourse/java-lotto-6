package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    //1,000으로 나누어 떨어지지 않는 경우
    public static void notSeparatedBy1000(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액에 1,000보다 작은 단위가 있습니다.");
        }
    }

    //숫자가 아닌 경우
    public static int isDigit(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력하신 값은 숫자가 아닙니다.");
        }
    }

    //숫자가 아닌 경우-리스트 버전
    public static List<Integer> isDigit(List<String> numbers) {
        try {
            List<Integer> intNumbers = new ArrayList<>();
            for (String number : numbers) {
                intNumbers.add(Integer.parseInt(number));
            }

            return intNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호 중 숫자가 아닌 입력이 있습니다.");
        }
    }

    //1 ~ 45 범위를 초과하는 경우
    public static void outOfRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("입력하신 보너스 번호가 범위(1 ~ 45)를 초과합니다.");
        }
    }

    //1 ~ 45 범위를 초과하는 경우-리스트 버전
    public static void outOfRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("입력하신 로또 번호 중 범위(1 ~ 45)를 초과하는 입력이 있습니다.");
            }
        }
    }

    //중복된 숫자가 포함된 경우 - 보너스
    public static void duplicateNumber(List<Integer> numbers,  int number){
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException("로또 번호와 중복된 숫자가 있습니다.");
        }
    }

    public static void duplicateNumber(List<Integer> numbers){
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException("로또 번호 중 서로 중복된 숫자가 있습니다.");
        }
    }
}
