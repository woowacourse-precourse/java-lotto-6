package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoInput {

    public int lottoPurchaseInput(){
        String lottoPurchasePrice = Console.readLine();
        return Integer.parseInt(lottoPurchasePrice);
    }
}
