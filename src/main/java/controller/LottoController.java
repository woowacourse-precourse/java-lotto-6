package controller;

import common.Converter;
import dto.Purchase;
import model.Amount;
import model.Bonus;
import model.Lotto;
import model.Reward;
import service.LottoService;
import view.InputView;
import view.OutputView;

import java.util.EnumMap;
import java.util.List;

public class LottoController {
    private LottoService lottoService = LottoService.getInstance();

    public void run(){
        String inputAmount = InputView.purchaseAmount();
        Amount amount = new Amount(Converter.stringToInteger(inputAmount));
        Purchase purchase = lottoService.start(amount);
        OutputView.showBuying(purchase);

        List<Integer> numbers = Converter.stringToList(InputView.winningNumber());
        Lotto lotto = new Lotto(numbers);
        int bonusNum = Converter.stringToInteger(InputView.bonusNumber());
        Bonus bonus = new Bonus(numbers, bonusNum);
        EnumMap<Reward, Integer> reward = lottoService.pick(lotto, bonus);
        OutputView.showResult(reward);

        Double rateOfReturn = lottoService.calRateOfReturn(amount);
        OutputView.showRateOfReturn(rateOfReturn);
    }
}
