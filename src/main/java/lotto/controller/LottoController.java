package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoPrice;
import lotto.domain.Lottos;
import lotto.view.LottoView;

public class LottoController {
    private static int PRICE_OF_LOTTO = 1000;

    private final LottoView lottoView = new LottoView();
    private Lottos lottos;

    public void init(){
        lottoView.startMessage();
        run();
    }
    public void run(){
        LottoPrice lottoPrice = new LottoPrice(userInput());
        drawLottoNumbers(lottoPrice);
    }
    public void drawLottoNumbers(LottoPrice lottoPrice){
        int numberOfLotto = countLotto(lottoPrice);
        lottoView.buyMessage(numberOfLotto);
        lottos = new Lottos(numberOfLotto);

    }

    public int countLotto(LottoPrice lottoPrice){
        return lottoPrice.getLottoPrice()/PRICE_OF_LOTTO;
    }

    private String userInput(){
        return Console.readLine();
    }
}
