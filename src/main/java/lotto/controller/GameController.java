package lotto.controller;

import lotto.model.LottoGameData;
import lotto.util.Status;
import lotto.view.InputView;

public class GameController {
    InputView inputView = new InputView();
    LottoGameData lottoGameData = new LottoGameData();

    public GameController() {
        setLottoGameData();
    }

    public void setLottoGameData() {
        Status status = Status.FAIL;

        while (status == Status.FAIL) {
            try {
                lottoGameData.setMoney(inputView.inputMoney());
                status = Status.SUCCESS;
            }catch (IllegalArgumentException ignored){}
        }
    }

}
