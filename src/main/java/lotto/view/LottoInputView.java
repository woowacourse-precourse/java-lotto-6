package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputView {
    public String getBuyingPrice() {
        return Console.readLine();
    }

    public String getLottoWinningNumbers() {
        return Console.readLine();
    }
}
