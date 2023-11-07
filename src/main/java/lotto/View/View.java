package lotto.View;

import camp.nextstep.edu.missionutils.Console;


public class View {

    public Integer getPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }
}
