package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class inputView {
    private final String INPUT_BUYING_COST_MESSAGE = "구입금액을 입력해 주세요.";

    public String inputBuyingCost(){
        System.out.println(INPUT_BUYING_COST_MESSAGE);

        return Console.readLine();
    }
}
