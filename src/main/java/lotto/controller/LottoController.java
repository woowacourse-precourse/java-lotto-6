package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoList;
import lotto.view.View;

public class LottoController {
    View view = new View();
    LottoList lottoList = new LottoList();

    public void start(){
        String s = view.inputBuyingMoney();
    }
}
