package service;

import model.MyLotto;
import util.NumberGenerator;
import view.InputView;
import view.OutputView;

public class InputService {

    NumberGenerator numberGenerator = new NumberGenerator();
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
        outputView.printNewLine();
        outputView.printPublishedLotto(lottoPaper);
    }

    public void createLottoNumber(){
        myLotto.createMyLottoNumber(lottoPaper);
        outputView.printMyLottoNumber(myLotto.getMyLottoNumber());
    }
}
