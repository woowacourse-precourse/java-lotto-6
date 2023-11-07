package model;

import java.util.ArrayList;
import util.NumberGenerator;
import view.InputView;
import view.OutputView;

public class LottoService {

    NumberGenerator numberGenerator = new NumberGenerator();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    private ArrayList<Lotto> myLotto;

    private int lottoCost;
    private int lottoPaper;

    public int buyLotto(){
        getLottoCost();
        getLottoPaper();
        return lottoPaper;
    }

    public void getLottoNumber(){
        createLottoNumber();
        showMyLottoNumber();
    }

    public void getLottoCost(){
        lottoCost = inputView.getLottoCostData();
    }

    public void getLottoPaper(){
        lottoPaper = lottoCost/1000;
    }

    public void createLottoNumber(){
        myLotto = new ArrayList<>();
        for(int i = 0; i<lottoPaper; i++){
            myLotto.add(new Lotto(numberGenerator.generateLottoNumber()));
        }
    }

    public void showMyLottoNumber(){
        for (Lotto lotto : myLotto) {
            outputView.printMyLottoNumber(lotto.getNumber());
        }
    }
}
