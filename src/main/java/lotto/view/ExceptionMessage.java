package lotto.view;

public class ExceptionMessage {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int AMOUNT_UNIT = 1000;
    public static void rangeException(){
        System.out.println("[ERROR] 로또 번호는 "+MIN_NUMBER+"부터 "+MAX_NUMBER+" 사이의 숫자여야 합니다.");
    }
    public static void duplicateException(){
        System.out.println("[ERROR] 중복된 숫자입니다.");
    }
    public static void overNumberException(){
        System.out.println("[ERROR] 숫자는 6개만 입력 가능합니다.");
    }
    public static void typeException(){
        System.out.println("[ERROR] 숫자만 입력하세요.");
    }
    public static void unitException(){
        System.out.println("[ERROR] 금액은 "+AMOUNT_UNIT+"단위로 입력 가능합니다.");
    }
    public static void naturalNumException(){
        System.out.println("[ERROR] 자연수가 아닙니다.");
    }


}
