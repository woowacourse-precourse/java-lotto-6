package controller;

import domain.*;
import dto.WinningResultDto;
import service.WinningService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class WinningController {
    private final WinningService winningService;

    public WinningController(){
        winningService = new WinningService();
    }

    public void generateWinngingAndBonus(final Lottos lottos, final int purchaseAmount){
        WinningNumbers winningNumbers = generateWinngingNumbers();
        BonusNumber bonusNumber = generateBonusNumber();
        printWinningStaticsAndProfit(winningNumbers, bonusNumber, lottos, purchaseAmount);
    }

    private WinningNumbers generateWinngingNumbers(){
        try{
            List<Integer> winningNumbers = InputView.inputWinngingNumbers();
            return createWinngingNumbers(winningNumbers);
        } catch (IllegalArgumentException e){
            OutputView.printMessage(e.getMessage());
            return generateWinngingNumbers();
        }
    }

    private BonusNumber generateBonusNumber(){
        try{
            int number = InputView.inputBonusNumber();
            return createBonusNumber(number);
        } catch (IllegalArgumentException e){
            OutputView.printMessage(e.getMessage());
            return generateBonusNumber();
        }
    }

    private WinningNumbers createWinngingNumbers(final List<Integer> winningNumbers){
        return winningService.createWinningNumbers(winningNumbers);
    }

    private BonusNumber createBonusNumber(final int bonusNumber){
        return winningService.createBonusNumber(bonusNumber);
    }

    private void printWinningStaticsAndProfit(final WinningNumbers winningNumbers, final BonusNumber bonusNumber, final Lottos lottos, final int purchaseAmount){
        generateWinningResult(winningNumbers, bonusNumber);
        WinningResultDto winningResultDto = winningService.calculateProfitAndRateOfProfit(lottos.getLottos(), purchaseAmount);
        OutputView.printWinningStatics(winningResultDto);
    }

    private WinningResult generateWinningResult(final WinningNumbers winningNumbers, final BonusNumber bonusNumber){
        return winningService.createWinningResult(winningNumbers, bonusNumber);
    }
}
