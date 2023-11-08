package controller;

import common.Converter;
import dto.Purchase;
import model.Amount;
import model.Bonus;
import model.Lotto;
import service.LottoService;
import view.InputView;
import view.OutputView;

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
        lottoService.pick(lotto, bonus);
    }
}
