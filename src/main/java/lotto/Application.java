package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameMessage gameMessage = new GameMessage();
        UserInput userInput = new UserInput();
        LottoNumbersControl lottoNumbersControl = new LottoNumbersControl();
        Money money = new Money();

        gameMessage.priceInputRequestMessage();
        int price = userInput.priceInput();

        int lottoCount = lottoNumbersControl.getLottoCount(price);
        gameMessage.lottoCountMessage(lottoCount);

        lottoNumbersControl.getAllLottoNumbers();
        gameMessage.lottoNumbersPrintMessage(lottoNumbersControl.allLottoNumbers);

        gameMessage.lottoNumbersInputMessage();
        List<Integer> lottoNumbers = userInput.lottoNumbersInput();

        gameMessage.lottoBonusInputMessage();
        int bonusNumber = userInput.lottoBonusInput();

        Lotto lotto = new Lotto(lottoNumbers);

        for (int i = 0; i < lottoNumbersControl.allLottoNumbers.size(); i++) {
            int collectCount = lotto.countCollectNumbers(lottoNumbersControl.allLottoNumbers.get(i));
            int score = lotto.getFirst(collectCount, bonusNumber);
            money.saveScores(score);
        }

        int allReward = money.addAllReward();
        double revenue = money.calculateRevenue(price, allReward);

        gameMessage.statisticsPrintMessage(money.scores, revenue);
    }
}
