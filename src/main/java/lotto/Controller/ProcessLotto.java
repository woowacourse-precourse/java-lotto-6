package lotto.Controller;

import java.util.ArrayList;
import java.util.List;
import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.Model.Generator;
import lotto.Model.Lotto;
import lotto.Model.StaisticsResult;

public class ProcessLotto {
    private OutputView outputView;
    private InputView inputView;

    public ProcessLotto(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void drawLotto(ValidateTools validateTools){
        InputValidate inputValidate = new InputValidate(validateTools);

        int cost = askCost(inputValidate, 0);
        int count = new AmountProcessing().getLottoCount(cost);
        outputView.printNumberPurchase(count);

        List<Lotto> lottos = generateLottos(count, new Generator());
        List<Integer> winningNums = askWinningNums(inputValidate, new ArrayList<>());
        int bonus = askBonus(inputValidate, winningNums, 0);
        outputView.printWinningStatistics();

        statistics(lottos, winningNums, bonus, cost);
    }


    private int askCost(InputValidate inputValidate, int cost){
        boolean success = false;
        while (!success){
            try{
                inputView.askPurchaseAmount();
                cost = inputValidate.validateCost(inputView.getLine());
                success = true;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage()+"\n");
            }
        }
        return cost;
    }


    private List<Integer> askWinningNums(InputValidate inputValidate, List<Integer> winningNums){
        boolean success = false;
        while (!success){
            try{
                inputView.askWinningNums();
                winningNums = inputValidate.validateWinningNums(inputView.getLine());
                new Lotto(winningNums);
                success = true;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return winningNums;
    }


    private int askBonus(InputValidate inputValidate, List<Integer> winningNums, int bonus){
        boolean success = false;
        while (!success){
            try{
                inputView.askBonusNum();
                bonus = inputValidate.validateBonus(inputView.getLine(), winningNums);
                success = true;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return bonus;
    }


    private List<Lotto> generateLottos(int count, Generator generator){
        List<Lotto> lottos = new ArrayList<>();
        while (count > 0){
            count--;
            List<Integer> generateNums = generator.generate6Nums();
            Lotto lotto = new Lotto(generateNums);
            outputView.printGeneratedNums(generateNums);
            lottos.add(lotto);
        }
        return lottos;
    }


    private void statistics(List<Lotto> lottos, List<Integer> winningNums, int bonus, int cost){
        StaisticsResult staisticsResult = new StaisticsResult();
        staisticsResult.updateResult(new CalculateLotto(), lottos, winningNums, bonus);
        staisticsResult.printStatistics(outputView, new CalculateLotto(), cost);
    }
}
