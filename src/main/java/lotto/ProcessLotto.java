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

    public void drawLotto(){
        InputValidate inputValidate = new InputValidate();
        AmountProcessing amountProcessing = new AmountProcessing();
        Generator generator = new Generator();
        LottoCalculator lottoCalculator = new LottoCalculator();
        outputView.askPurchaseAmount();
        int cost = inputValidate.validateNumber(inputView.getLine());
        boolean success = false;
        while (!success){
            try{
                amountProcessing.isDivided(cost);
                success = true;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                outputView.askPurchaseAmount();
                cost = inputValidate.validateNumber(inputView.getLine());
            }
        }

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
        success = false;
        List<Integer> winningNums = new ArrayList<>();
        outputView.askWinningNums();
        while (!success){
            try{
                winningNums = inputValidate.validateWinningNums(inputView.getLine());
                success = true;
            }
            catch (IllegalArgumentException e){
                outputView.askWinningNums();
            }
        }

        success = false;
        outputView.askBonusNum();
        int bonusNum = 0;
        while (!success){
            try{
                bonusNum = inputValidate.validateNumber(inputView.getLine());
                success = false;
            }catch (IllegalArgumentException e){
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
        int cnt = 0;
        for (Lotto nums: lottos){
            if (lottoCalculator.checkBonus(nums.getNumbers(), winningNums, bonusNum)){
                countMap.put(55, countMap.get(55)+1);
                continue;
            }
            cnt = lottoCalculator.checkMatch(nums.getNumbers(), winningNums);
            if (cnt > 2){
                countMap.put(cnt, countMap.get(cnt)+1);
            }

        }

        outputView.print3Matchs(countMap.get(3));
        outputView.print4Matchs(countMap.get(4));
        outputView.print5Matchs(countMap.get(5));
        outputView.print5MatchsWithBonus(countMap.get(55));
        outputView.print6Matchs(countMap.get(6));
        int profit = lottoCalculator.getProfit(countMap);
        double profitRate = lottoCalculator.roi(profit, cost);
        outputView.printProfit(profitRate);

    }


}
