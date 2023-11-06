package service;

import model.MyLotto;
import view.InputView;
import view.OutputView;

public class InputService {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    MyLotto myLotto = new MyLotto();

    private int lottoCost;
    private int lottoPaper;
    public void getLottoCost(){
        outputView.printRequirelottoCost();
        lottoCost = inputView.getLottoCostData();
        myLotto.buyLotto(lottoCost);
        lottoPaper = myLotto.getLottoPaper();
        outputView.printPublishedLotto(lottoPaper);
    }

    public void getLottoNumber(){

    }
}
