package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.util.Parser.stringToInt;

public class InputView {

    public int requestMoney() {
        System.out.println("구입금액을 입력해 주세요");
        return stringToInt(Console.readLine());
    }

    public String requestWinningNumbers() {
        return Console.readLine();
    }
}
