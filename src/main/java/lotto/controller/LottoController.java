package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoPrize;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputController input;
    private OutputView output;
    private Lotto list;
    private int bonusNum;
    private LottoGenerator lottoGenerator;

    public LottoController() {
        input = new InputController(new InputView());
        output = new OutputView();
        lottoGenerator = new LottoGenerator(input.setCost());
        CostController();
        NumController();
        ResultController();
    }

    public void CostController() {
        output.lottoCountResult(lottoGenerator.getLottoGroup());
    }

    public void NumController() {
        list = input.setLottoNum();
        bonusNum = input.setBonusNum();
    }

    public void ResultController() {
        LottoPrize prize = new LottoPrize(lottoGenerator.getLottoGroup(), list.getNumbers(), bonusNum);
        prize.calculatePrizes();
    }
}
