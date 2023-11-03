package lotto.controller;

import lotto.model.LottoGameData;
import lotto.util.Status;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoGameData lottoGameData = new LottoGameData();

    public GameController() {
        setLottoGameData();
        showChances();
    }

    public void setLottoGameData() {
        Status status = Status.FAIL;

        while (status == Status.FAIL) {
            try {
                lottoGameData.setChance(inputView.inputMoney());
                status = Status.SUCCESS;
            }catch (IllegalArgumentException ignored){}
        }
    }

    public void showChances(){
        outputView.printChances(lottoGameData.getChance());
    }

}
