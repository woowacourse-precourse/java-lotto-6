package lotto.controller;


import lotto.model.*;
import lotto.view.Input;
import lotto.view.Output;
import java.util.List;

public class GameStart {
    private Input input = new Input();
    private Output output = new Output();
    private PurchaseAmount purchaseAmount = new PurchaseAmount();

    public void start() {
        String money = input.inputPurchaseAmount();
        int games = purchaseAmount.convertAmountToGames(money);
        output.outputBoughtTicket(games);

        List<List<Integer>> lottoNumbers = createLottoNumbers(games); // 로또 번호 생성 및 출력
        String winningNumber = input.inputWinningNumber();
        String bonusNumber = input.inputBonusNumber();

        WinningStatistics winningStatistics = new WinningStatistics(lottoNumbers, winningNumber, bonusNumber);
        int[] value = winningStatistics.calculate();
        output.outputStatistic(value);

        ProfitRate profitRate = new ProfitRate(value, money);
        output.outputProfitRate(profitRate.calculate());
    }

    public List<List<Integer>> createLottoNumbers(int games) {
        RandomLottoNumbers randomLottoNumbers = new RandomLottoNumbers();
        List<List<Integer>> lottoNumbers = randomLottoNumbers.createAutoLotto(games);

        int i = 0;
        for (List<Integer> lottoNumber : lottoNumbers) {
            Lotto lotto = new Lotto(lottoNumber);
            lottoNumbers.set(i, lotto.getNumbers());
            System.out.println(lottoNumbers.get(i++).toString());
        }
        return lottoNumbers;
    }
}
