package lotto;

import java.util.ArrayList;
import java.util.List;

public class ProcessLotto {
    private OutputView outputView;
    private InputView inputView;

    public ProcessLotto(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void drawLotto(ValidateTools validateTools){
        InputValidate inputValidate = new InputValidate(validateTools);
        AmountProcessing amountProcessing = new AmountProcessing();

        int cost = askCost(inputValidate, 0);
        int count = amountProcessing.getLottoCount(cost);
        outputView.printNumberPurchase(count);

        List<Lotto> lottos = generateLottos(count, new Generator());
        List<Integer> winningNums = askWinningNums(inputValidate, new ArrayList<>());
        int bonus = askBonus(inputValidate, winningNums, 0);
        outputView.printWinningStatistics();

        StaisticsResult staisticsResult = new StaisticsResult();
        staisticsResult.updateResult(new CalculateLotto(), lottos, winningNums, bonus);
        staisticsResult.printStatistics(outputView, new CalculateLotto(), cost);
    }

    private int askCost(InputValidate inputValidate, int cost){
        boolean success = false;
        while (!success){
            try{
                outputView.askPurchaseAmount();
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
                outputView.askWinningNums();
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
                outputView.askBonusNum();
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



}
