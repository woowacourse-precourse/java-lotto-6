package lotto.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.Model.Generator;
import lotto.Model.Lotto;

public class Process {
    private OutputView outputView;
    private InputView inputView;

    public Process(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void drawLotto(){
        ValidateInput validateInput = new ValidateInput();
        int cost = askCost(validateInput, 0);
        int count = new Calculate().getLottoCount(cost);
        outputView.printNumberPurchase(count);

        List<Lotto> lottos = generateLottos(count, new Generator());
        List<Integer> winningNums = askWinningNums(validateInput, new ArrayList<>());
        int bonus = askBonus(validateInput, winningNums, 0);
        outputView.printWinningStatistics();

        executeStatistics(lottos, winningNums, bonus, cost);
    }


    private int askCost(ValidateInput validateInput, int cost){
        boolean success = false;
        while (!success){
            try{
                inputView.askPurchaseAmount();
                cost = validateInput.validateCost(inputView.getLine());
                success = true;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage()+"\n");
            }
        }
        return cost;
    }


    private List<Integer> askWinningNums(ValidateInput validateInput, List<Integer> winningNums){
        boolean success = false;
        while (!success){
            try{
                inputView.askWinningNums();
                winningNums = validateInput.validateWinningNums(inputView.getLine());
                new Lotto(winningNums);
                success = true;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return winningNums;
    }


    private int askBonus(ValidateInput validateInput, List<Integer> winningNums, int bonus){
        boolean success = false;
        while (!success){
            try{
                inputView.askBonusNum();
                bonus = validateInput.validateBonus(inputView.getLine(), winningNums);
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
            outputView.printGeneratedNums(listToString(generateNums));
            lottos.add(lotto);
        }
        return lottos;
    }

    private String listToString(List<Integer> nums){
        return nums.stream().map(i -> i.toString()).collect(Collectors.joining(", ", "[", "]"));
    }


    private void executeStatistics(List<Lotto> lottos, List<Integer> winningNums, int bonus, int cost){
        Statistics statistics = new Statistics();
        statistics.updateResult(new Calculate(), lottos, winningNums, bonus);
        statistics.printStatistics(outputView, new Calculate(), cost);
        statistics.printProfit(outputView, new Calculate(), cost);
    }
}
