package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;


public class LottoController {
    private InputController input;
    private OutputView output;
    private int bonusNum;
    public LottoController() {
        input = new InputController(new InputView());
        output = new OutputView();
        CostController();
        Numcontroller();
    }
    public void CostController(){
        input.setCost();
        output.lottoCountResult(LottoGenerator.lottoGroup);
    }
    public void Numcontroller(){
        input.setLottoNum();
        bonusNum = input.setBonusNum();
    }
}
