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

    public void drawLotto(){
        InputValidate inputValidate = new InputValidate();
        AmountProcessing amountProcessing = new AmountProcessing();
        Generator generator = new Generator();
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
        int bounsNum = inputValidate.validateNumber(inputView.getLine());

        outputView.printWinningStatistics();
        for (Lotto nums: lottos){
            //TODO: 보너스 볼 일치도 구해야됨

        }

    }


}
