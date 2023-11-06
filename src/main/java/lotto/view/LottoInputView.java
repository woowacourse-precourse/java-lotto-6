package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public final class LottoInputView {

    private LottoInputView() {
    }

    public static String initPurchasePrice(){
        return Console.readLine();
    }

}
