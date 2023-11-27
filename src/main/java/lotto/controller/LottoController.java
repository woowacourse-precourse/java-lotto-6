package lotto.controller;

import lotto.model.LottoNumberMaker;
import lotto.view.LottoInput;

public class LottoController {
    private static final LottoNumberMaker lottoNumberMaker = new LottoNumberMaker();
    private static final LottoInput lottoInput = new LottoInput();
    public static void setPrice() {
        lottoNumberMaker.checkInt();
    }



    public String askPrice() {
        return lottoInput.askPrice();
    }
}
