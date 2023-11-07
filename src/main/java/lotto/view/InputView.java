package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    //굳이 final과 static을 같이 써야 하나?
    private final static String inputPriceMent = "구입금액을 입력해 주세요.";
    private final static String inputWinningNumbersMent = "당첨 번호를 입력해 주세요.";
    private final static String inputBonusNumberMent = "보너스 번호를 입력해 주세요.";

    public int getPrice() {
        System.out.println(inputPriceMent);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            ExceptionOutputView.printInputIntegerError();
            throw new IllegalArgumentException();
        }
    }

    public String getWinningNumbers() {
        System.out.println(inputWinningNumbersMent);
        return Console.readLine();
    }

    public int getBonusNumber() {
        System.out.println(inputBonusNumberMent);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            ExceptionOutputView.printInputIntegerError();
            throw new IllegalArgumentException();
        }
    }


}
