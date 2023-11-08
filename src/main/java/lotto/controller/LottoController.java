package lotto.controller;

import lotto.domain.CostValidator;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoPrize;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;


public class LottoController {
    private InputController input;
    private OutputView output;

    private LottoGenerator lottoGenerator;
    private List<Lotto> lottoGroup;
    private int bonusNum;
    private Lotto list;

    public LottoController() {
        input = new InputController(new InputView());
        output = new OutputView();
        this.CostController();
        this.Numcontroller();
        this.ResultController();
    }

    public void CostController() {
        input.setCost();
        lottoGenerator = new LottoGenerator(CostValidator.lottoCount);
        lottoGroup = LottoGenerator.lottoGroup;
        output.lottoCountResult(lottoGroup);
    }

    public void Numcontroller() {
        list = input.setLottoNum();
        bonusNum = input.setBonusNum();
    }

    public void ResultController() {
        if (list == null) {
            return;
        }
        LottoPrize prize = new LottoPrize(lottoGroup, list.getNumbers(), bonusNum);
        prize.calculatePrizes();
    }
}