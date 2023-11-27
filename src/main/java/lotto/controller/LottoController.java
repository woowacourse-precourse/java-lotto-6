package lotto.controller;

import lotto.model.LottoNumberMaker;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

public class LottoController {
    private static final LottoNumberMaker lottoNumberMaker = new LottoNumberMaker();
    private static final LottoInput lottoInput = new LottoInput();
    private static final LottoOutput lottoOutput = new LottoOutput();
    public static void setPrice() {
        lottoNumberMaker.checkInt();
    }

    public static void setBuyLottoNumberPrint() {
        lottoOutput.buyLottoNumberPrint(lottoNumberMaker.getLottoNumber());
    }

    public String askPrice() {
        return lottoInput.askPrice();
    }
}
