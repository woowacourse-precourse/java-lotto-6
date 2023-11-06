package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoView {
    public  LottoView(){

    }

    public int askPrice() {
            System.out.println("구입 금액을 입력해 주세요.");
            String input = Console.readLine();
            return Integer.parseInt(input);

    }
}
