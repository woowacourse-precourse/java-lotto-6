package lotto.view;

public class ExceptionView {
    private ExceptionView(){}; //생성자로 인스턴스 생성 막기

    public static void printExceptionMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }
}
