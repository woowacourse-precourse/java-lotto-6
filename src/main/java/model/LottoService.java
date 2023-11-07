package model;

import java.util.ArrayList;
import java.util.List;
import util.NumberGenerator;
import view.InputView;
import view.OutputView;

public class LottoService {

    NumberGenerator numberGenerator = new NumberGenerator();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    ArrayList<List<Integer>> myLottoNumber = new ArrayList<>();


    private int lottoCost;
    private int lottoPaper;

    public void getLottoCost(){
        outputView.printRequirelottoCost();
        lottoCost = inputView.getLottoCostData();
    }

    public void buyLotto(){
        lottoPaper = lottoCost/1000;
    }

    public void createLottoNumber(){
        outputView.printNewLine();
        outputView.printPublishedLotto(lottoPaper);
        createMyLottoNumber();
        outputView.printMyLottoNumber(myLottoNumber);
    }

    public void createMyLottoNumber(){
        for(int i = 0; i<lottoPaper; i++){
            myLottoNumber.add(numberGenerator.generate());
        }
    }
}
