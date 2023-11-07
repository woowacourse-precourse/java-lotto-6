package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Price;
import lotto.util.LottoUtil;

public class InputView {

    public static Price getPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int purchasePrice = LottoUtil.parseInteger(input);
        return new Price(purchasePrice);
    }

}
