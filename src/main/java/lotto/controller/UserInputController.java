package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.MessageDisplay;

public class UserInputController {

    public static int getLottoBuyingPrice() {
        MessageDisplay.enterBuyingPrice();
        int buyingPrice = Integer.parseInt(Console.readLine());
        // 답이 유효한지 확인하는 부분 추후에 추가
        return buyingPrice;
    }
}
