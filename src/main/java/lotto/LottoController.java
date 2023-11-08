package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {

    private Buyer buyer;
    private LottoNumber lottoNumber;

    public void run() {
        String amount = getValidatedPurchaseAmount();
        buyer = new Buyer(amount);
        System.out.println();
        buyer.printBuyerLottoTickets();
        System.out.println();
        List<String> winningNumber = getValidatedWinningNumber();
        System.out.println();
        String bonusNumber = getValidatedBonusNumber(winningNumber);
        System.out.println();


        lottoNumber = new LottoNumber();
        lottoNumber.setWinningNumber(winningNumber);
        lottoNumber.setBonusNumber(bonusNumber);

        buyer.getLottoResult(lottoNumber.getWinningNumber(),lottoNumber.getBonusNumber());
        OutputView.printTitle();

        Map<WinningCondition,Integer> winningResult = buyer.getWinningStatistic();
        for (WinningCondition winningCondition : WinningCondition.values()){
            if (winningCondition == WinningCondition.NO_RANK){
                continue;
            }
            OutputView.printResult(winningCondition, winningResult.get(winningCondition));

        }
        float profitRate = buyer.getProfitRate();
        OutputView.printProfitRate(profitRate);


//        OutputView.printResult();





    }


    public String getValidatedPurchaseAmount() {
        String amount = null;

        while (true) {
            try {
                amount = InputView.inputPurchaseAmount();
                Validator.isValidAmount(amount);
                Validator.isAmountDivisibleBy1000(amount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return amount;


    }

    public List<String> getValidatedWinningNumber() {
        List<String> winningNumber;
        while (true) {
            try {
                winningNumber = InputView.inputWinningNumber();
                Validator.isWinningNumberSizeValid(winningNumber);
                Validator.isWinningNumberValid(winningNumber);
                Validator.isWinningNumberDistinct(winningNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
        return winningNumber;

    }

    public String getValidatedBonusNumber(List<String> winningNumber) {
        String bonusNumber;
        while (true) {
            try {
                bonusNumber = InputView.inputBonusNumber();
                Validator.isBonusNumberValid(bonusNumber);
                Validator.isBonusNumberDistinct(winningNumber, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;

    }

}
