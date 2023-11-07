package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputPriceView {
    public String inputPrice() {
        printPrice();
        return Console.readLine();
    }

    public void printPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }
}
