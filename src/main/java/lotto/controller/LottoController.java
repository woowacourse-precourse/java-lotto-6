package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Parser;
import lotto.view.LottoView;

public class LottoController {

    private LottoView lottoView = new LottoView();
    private int purchaseAmount;
    public void startLotto(){
        purchaseAmount = getPurchaseAmount();
    }

    public int getPurchaseAmount(){
        lottoView.purchaseAmountView();
        return Parser.stringToInt(Console.readLine());
    }
}
