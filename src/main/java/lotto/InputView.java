package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    int inputLottoPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validInput(input);
        return Integer.parseInt(input);
    }
}
