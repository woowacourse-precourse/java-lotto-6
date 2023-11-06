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
        outputView.askWinningNums();
        List<Integer> winningNums = inputValidate.validateWinningNums(inputView.getLine());
        outputView.askBonusNum();
        int bonusNum = inputValidate.validateNumber(inputView.getLine());


        outputView.printWinningStatistics();

        HashMap<Integer, Integer> countMap = new HashMap<>();
        // TODO: 상수로 변환
        countMap.put(3, 0);
        countMap.put(4, 0);
        countMap.put(5, 0);
        countMap.put(55, 0);
        countMap.put(6, 0);
        
        int cnt = 0;
        for (Lotto nums: lottos){
            if (lottoCalculator.checkBonus(nums.getNumbers(), winningNums, bonusNum)){
                countMap.put(55, countMap.get(55)+1);
                continue;
            }
            cnt = lottoCalculator.checkMatch(nums.getNumbers(), winningNums);
            countMap.put(cnt, countMap.get(cnt)+1);

        }

    }


}
