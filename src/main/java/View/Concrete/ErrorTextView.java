package View.Concrete;

import View.ErrorView;

public class ErrorTextView implements ErrorView {
    String defalut = "[ERROR]";
    @Override
    public void emptyStringAtInputMoney() {
        System.out.println(defalut + "아무것도 입력되지 않았습니다");
    }

    @Override
    public void notConvertedToInt(String str) {
        System.out.println(defalut + "문자열은 금액으로 인정되지 않습니다. 오류 문자:" + str);
    }

    @Override
    public void notMultipleOfThousand(Integer errorInt) {
        System.out.println(defalut + "금액은 로또 가격(1000)의 배수로 입력해 주십시오. 현재 입력:" + errorInt);
    }

    @Override
    public void zeroInserted() {
        System.out.println(defalut + "1000의 배수인 양수를 입력해 주십시오. 현재 입력:" + 0);
    }
}
