package model;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import util.NumberGenerator;
import view.InputView;
import view.OutputView;

public class LottoService {

    NumberGenerator numberGenerator = new NumberGenerator();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    private Lotto[] myLotto;

    private int lottoCost;
    private int lottoPaper;

    public void buyLotto(){
        getLottoCost();
        getLottoPaper();
        createLottoNumber();
        showMyLottoNumber();
    }

    public void getLottoCost(){
        outputView.printRequirelottoCost();
        lottoCost = inputView.getLottoCostData();
    }

    public void getLottoPaper(){
        lottoPaper = lottoCost/1000;
    }

    public void createLottoNumber(){
        outputView.printNewLine();
        outputView.printPublishedLotto(lottoPaper);
        createMyLottoNumber();
    }

    public void createMyLottoNumber(){
        myLotto = new Lotto[lottoPaper];
        for(int i = 0; i<myLotto.length; i++){
            myLotto[i] = new Lotto(numberGenerator.generate());
        }
    }

    public void showMyLottoNumber(){
        for (Lotto lotto : myLotto) {
            outputView.printMyLottoNumber(lotto.getNumber());
        }
    }
}
