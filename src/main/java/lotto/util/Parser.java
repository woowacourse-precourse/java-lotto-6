package lotto.util;

public class Parser {
    public static int stringToInt(String message) {
        try{
            return Integer.parseInt(message);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[예외처리] 정수가 아닙니다.");
        }
    }
}
