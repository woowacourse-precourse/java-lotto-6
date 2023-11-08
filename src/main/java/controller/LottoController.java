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

    private static Amount amount;
    private static Lotto lotto;
    private static Bonus bonus;

    private LottoService lottoService = LottoService.getInstance();

    public void run(){
        inputAmount();
        Purchase purchase = lottoService.start(amount);
        OutputView.showBuying(purchase);

        inputWinning();
        inputBonus();
        EnumMap<Reward, Integer> reward = lottoService.pick(lotto, bonus);
        OutputView.showResult(reward);

        Double rateOfReturn = lottoService.calRateOfReturn(amount);
        OutputView.showRateOfReturn(rateOfReturn);
    }

    private void inputAmount(){
        try{
            String inputAmount = InputView.purchaseAmount();
            amount = new Amount(Converter.stringToInteger(inputAmount));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            inputAmount();
        }
    }

    private void inputWinning(){
        try{
            List<Integer> numbers = Converter.stringToList(InputView.winningNumber());
            lotto = new Lotto(numbers);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            inputWinning();
        }
    }

    private void inputBonus(){
        try{
            int bonusNum = Converter.stringToInteger(InputView.bonusNumber());
            bonus = new Bonus(lotto.getNumbers(), bonusNum);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            inputBonus();
        }
    }
}
