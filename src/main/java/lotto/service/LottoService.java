package lotto.service;

import lotto.utils.Parser;
import lotto.view.InputView;

public class LottoService {

    private final InputView inputView = new InputView();
    private final Parser parser = new Parser();
    int lottoCount;

    public void setLottoCount(){
        lottoCount = parser.parseLottoCount(inputView.inputUserAmount());
    }
}
