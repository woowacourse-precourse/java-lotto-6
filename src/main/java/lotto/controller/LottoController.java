package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCalculate;
import lotto.domain.LottoGenerate;
import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        try{
            start();
        } catch (Exception e){
            OutputView.printError(e.getMessage());
        }
    }
    public void start(){
        int amount = getAmount();
        List<Lotto> lottoNumList = generateLottoNumbers(amount);
        OutputView.requestWinningNumbers();

        List<Integer> winning = InputView.getWinningNumber();
        OutputView.requestBonusNumber();

        int bonus = InputView.getBonusNumber(winning);
        LottoResult lottoResult = getResult(lottoNumList, winning, bonus);
        OutputView.printWinningResult(lottoResult);

        OutputView.printProfitRate(lottoResult, amount);
    }

    public int getAmount(){
        OutputView.requestMoney();
        String money = InputView.getInputNumber();
        return LottoCalculate.calcAmount(Integer.parseInt(money));
    }
    public List<Lotto> generateLottoNumbers(int amount){
        OutputView.printAmountLotto(amount);
        List<Lotto> lottoNumbersList = LottoGenerate.generateLottoNumbers(amount);
        OutputView.printLottoList(lottoNumbersList);
        return lottoNumbersList;
    }

    public LottoResult getResult(List<Lotto> generateList, List<Integer> winning, int bonus){
        LottoResult lottoResult = new LottoResult();
        lottoResult.calculate(generateList, winning, bonus);
        return lottoResult;
    }
}
