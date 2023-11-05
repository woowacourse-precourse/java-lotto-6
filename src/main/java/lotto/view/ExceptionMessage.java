package lotto.view;

public class ExceptionMessage {
    public static void numberException(){
        System.out.println("[ERROR] 금액은 숫자여야 합니다.");
    }
    public static void wrongNumberException(){
        System.out.println("[ERROR] 금액은 1000원 단위여야 합니다.");
    }
}
