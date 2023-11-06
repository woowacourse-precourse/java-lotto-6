package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    static final int LOTTO_PRICE= Integer.parseInt(Console.readLine());
    public static int getLottoPrice(){
        return LOTTO_PRICE;
    }
}
