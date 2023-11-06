package lotto.utils;

public class NumberOrNot {
    public static boolean isNumber(String input){
        try {
            Integer.parseInt(input);
            return true; // 문자열을 정수로 변환 가능하면 true 반환
        } catch (NumberFormatException e) {
            return false; // 변환할 수 없으면 false 반환
        }
    }
}
