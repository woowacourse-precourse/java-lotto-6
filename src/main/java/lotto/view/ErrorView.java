package lotto.view;

public class ErrorView {
    private static final String Not_Number_Message = "[ERROR] 구입 금액은 숫자로 입력해야 합니다.";
    private static final String Bigger_Zero_Message = "[ERROR] 구입 금액은 0원보다 커야 합니다.";
    private static final String Not_Multiple_1000 = "[ERROR] 구입 금액은 1000원 단위이여야 합니다.";
    public static void Not_Number_Error(){
        System.out.println(Not_Number_Message);
    }
    public static void Bigger_Zero_Error(){
        System.out.println(Bigger_Zero_Message);
    }
    public static void Not_Multiple_Error(){
        System.out.println(Not_Multiple_1000);
    }
}
