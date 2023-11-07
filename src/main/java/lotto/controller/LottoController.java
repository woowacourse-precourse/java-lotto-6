package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoPrize;
import lotto.view.InputView;
import lotto.view.OutputView;

import javax.xml.transform.Result;
import java.util.List;


public class LottoController {
    private InputController input;
    private OutputView output;
    private Lotto list;
    private int bonusNum;
    public LottoController() {
        input = new InputController(new InputView());
        output = new OutputView();
        CostController();
        Numcontroller();
        ResultController();
    }
    public void CostController(){
        input.setCost();
        output.lottoCountResult(LottoGenerator.lottoGroup);
    }
    public void Numcontroller(){
        list = input.setLottoNum();
        bonusNum = input.setBonusNum();
    }
    public void ResultController(){
        LottoPrize prize = new LottoPrize(LottoGenerator.lottoGroup, list.getNumbers() ,bonusNum);
        prize.calculatePrizes();
    }
}
