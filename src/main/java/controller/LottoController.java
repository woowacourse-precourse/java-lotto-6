package controller;

import java.util.LinkedList;
import java.util.List;
import lotto.Lotto;
import util.LottoNumber;
import view.InputView;
import view.OutputView;

public class LottoController {

    private static final int START_INDEX = 0;

    private List<Lotto> lottoList;

    public LottoController() {

    }

    public void initGame() {
        lottoList = new LinkedList<>();
        makeLottoList();
    }

    public void startGame() {
        while (true) {
            try {
                initGame();
                break;
            } catch (IllegalArgumentException errorMessage) {
                System.out.println(errorMessage.getMessage());
            }
        }
    }

    public void makeLottoList() {
        Integer purchasePrice = InputView.inputPurchasePrice();
        Integer totalPurchaseQuantity = purchasePrice / 1000;
        OutputView.outputTotalPurchaseQuantity(totalPurchaseQuantity);
        for (int i=START_INDEX;i<totalPurchaseQuantity;i++) {
            lottoList.add(new Lotto(LottoNumber.makeLottoNumbers()));
        }
        OutputView.outputLottoList(lottoList);
    }
}
