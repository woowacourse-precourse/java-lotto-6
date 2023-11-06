package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProcessLotto {
    private OutputView outputView;
    private InputView inputView;

    public ProcessLotto(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private int askCost(InputValidate inputValidate){
        int cost = 0;
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

    public void drawLotto(ValidateTools validateTools){
        InputValidate inputValidate = new InputValidate(validateTools);
        AmountProcessing amountProcessing = new AmountProcessing();
        Generator generator = new Generator();
        CalculateLotto calculateLotto = new CalculateLotto();

        int cost = askCost(inputValidate);
        int count = amountProcessing.getLottoCount(cost);
        outputView.printNumberPurchase(count);

        List<Lotto> lottos = new ArrayList<>();
        while (count > 0){
            count--;
            List<Integer> generateNums = generator.generate6Nums();
            Lotto lotto = new Lotto(generateNums);
            outputView.printGeneratedNums(generateNums);
            lottos.add(lotto);
        }

        List<Integer> winningNums = askWinningNums(inputValidate, new ArrayList<>());

        boolean success = false;
        outputView.askBonusNum();
        int bonusNum = 0;
        while (!success){
            try{
                bonusNum = inputValidate.validateBonus(inputView.getLine(), winningNums);
                success = true;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                outputView.askBonusNum();
            }
        }


        outputView.printWinningStatistics();

        HashMap<Integer, Integer> countMap = new HashMap<>();
        // TODO: 상수로 변환
        countMap.put(3, 0);
        countMap.put(4, 0);
        countMap.put(5, 0);
        countMap.put(55, 0);
        countMap.put(6, 0);

        // TODO: 클래스 만들기
        for (Lotto nums: lottos){
            if (calculateLotto.checkBonus(nums.getNumbers(), winningNums, bonusNum)){
                countMap.put(55, countMap.get(55)+1);
                continue;
            }
            int cnt = calculateLotto.checkMatch(nums.getNumbers(), winningNums);
            if (cnt > 2){
                countMap.put(cnt, countMap.get(cnt)+1);
            }
        }

        outputView.print3Matchs(countMap.get(3));
        outputView.print4Matchs(countMap.get(4));
        outputView.print5Matchs(countMap.get(5));
        outputView.print5MatchsWithBonus(countMap.get(55));
        outputView.print6Matchs(countMap.get(6));
        int profit = calculateLotto.getProfit(countMap);
        double profitRate = calculateLotto.roi(profit, cost);
        outputView.printProfit(profitRate);

    }


}
