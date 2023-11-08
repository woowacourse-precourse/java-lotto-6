package lotto.view.inputView;

import camp.nextstep.edu.missionutils.Console;

import static lotto.constant.ViewMessages.Number_Input_Request;


public class LottoWinningNumberInput {
    public String requestWinningNumbers() {
        System.out.println(Number_Input_Request);
        return Console.readLine();
    }
}