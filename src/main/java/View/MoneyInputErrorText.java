package View;

public class MoneyInputErrorText {
    static String defalut = "[ERROR]";
    public static String emptyString() {
        return defalut + "아무것도 입력되지 않았습니다";
    }

    public static String notConvertedToInt(String str) {
        return defalut + "문자열은 금액으로 인정되지 않습니다. 오류 문자:" + str;
    }

    public static String notMultipleOfThousand() {
        return defalut + "금액은 로또 가격(1000)의 배수로 입력해 주십시오. 현재 입력:";
    }
    public static String zeroInserted() {
        return defalut + "1000의 배수인 양수를 입력해 주십시오.";
    }

    public static String nullInserted(){
        return defalut + "금액 입력시 null값이 들어갔습니다.";
    }
}
