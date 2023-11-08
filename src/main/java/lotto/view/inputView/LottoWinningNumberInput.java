package lotto.view.inputView;

import camp.nextstep.edu.missionutils.Console;

import static lotto.constant.ViewMessages.NUMBER_INPUT_REQUEST;


public class LottoWinningNumberInput {
    public String requestWinningNumbers() {
        System.out.println(NUMBER_INPUT_REQUEST);
        return Console.readLine();
    }
}