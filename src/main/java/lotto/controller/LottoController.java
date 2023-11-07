package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private List<Lotto> lottoList;
    private int lottoCount;

    public void start() {
        InputPurchaseAmount();
        this.lottoList = generateLottoList();
        printLottoList();
    }

    public void InputPurchaseAmount() {
        try {
            OutputView.askPurchaseAmount();
            int purchaseAmount = InputView.getPurchaseAmount();
            this.lottoCount = calculateAttemptCount(purchaseAmount);
            this.lottoList = generateLottoList();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private int calculateAttemptCount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    public List<Lotto> generateLottoList() {
        List<Lotto> lottoList = new ArrayList<Lotto>();
        for (int i = 0; i < this.lottoCount; i++) {
            lottoList.add(generateLotto());
        }
        return lottoList;
    }

    public Lotto generateLotto() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lotto = new Lotto(lottoGenerator.generateLotto());
        return lotto;
    }

    private void printLottoList() {
        OutputView.printLottoList(lottoList);
    }

}
