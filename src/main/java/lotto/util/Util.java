package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputView;

public class Util {
    private Util(){}    // 생성자 생성 방지
    public static String inputPrice(){
        String price;
        InputView.priceInputView();
        price = Console.readLine();

        return price;
    }
}
