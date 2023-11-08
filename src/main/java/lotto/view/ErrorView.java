package lotto.view;

public class ErrorView {
    private ErrorView(){}
    public static void errorNotInteger(){
        System.out.println("[ERROR] 구입 금액은 숫자여야 합니다.");
    }
    public static void errorNotThousand(){
        System.out.println("[ERROR] 1000원 단위로 입력해야 합니다.");
    }
}
