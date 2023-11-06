package controller;

import java.util.LinkedList;
import java.util.List;
import lotto.Lotto;
import util.LottoNumber;
import view.InputView;
import view.OutputView;

public class LottoController {

    private static final int START_INDEX = 0;

    private List<Lotto> lottoList = new LinkedList<>();

    public LottoController() {
        initGame();
    }

    public void initGame() {
        Integer purchasePrice = InputView.inputPurchasePrice();
        Integer totalPurchaseQuantity = purchasePrice / 1000;
        OutputView.outputTotalPurchaseQuantity(totalPurchaseQuantity);
        makeLottoList(totalPurchaseQuantity);
        OutputView.outputLottoList(lottoList);
    }

    public void makeLottoList(Integer totalPurchaseQuantity) {
        for (int i=START_INDEX;i<totalPurchaseQuantity;i++) {
            lottoList.add(new Lotto(LottoNumber.makeLottoNumbers()));
        }
    }
}
