package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoManager;
import lotto.domain.LottoPrice;
import lotto.view.LottoView;

public class LottoController {
    private static int PRICE_OF_LOTTO = 1000;

    private final LottoView lottoView = new LottoView();
    private final LottoManager lottoManager = new LottoManager();

    public void init(){
        lottoView.startMessage();
        run();
    }
    public void run(){
        LottoPrice lottoPrice = new LottoPrice(userInput());

    }

    private String userInput(){
        return Console.readLine();
    }
}
