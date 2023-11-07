package lotto.view.inputView;

import camp.nextstep.edu.missionutils.Console;



public class LottoWinningNumberInput {
    public String requestWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }
}