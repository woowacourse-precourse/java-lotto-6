package util;

import camp.nextstep.edu.missionutils.Console;
import view.InputView;

public class Util {
    private Util(){}    // 생성자 생성 방지
    public static int inputPrice(){
        String price;
        InputView.priceInputView();
        price = Console.readLine();

        return Integer.parseInt(price);
    }
}
