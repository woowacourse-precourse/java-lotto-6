package lotto.controller;

import java.util.List;
import lotto.domain.LottoCalculate;
import lotto.domain.LottoGenerate;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        try{
            start();
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] "+e.getMessage());
        }
    }
    public void start(){
        int amount = getAmount();
        List<List<Integer>> lottoNumList = generateLottoNumbers(amount);

    }

    public int getAmount(){
        OutputView.requestMoney();
        String money = InputView.getInputNumber();
        return LottoCalculate.calcAmount(Integer.parseInt(money));
    }
    public List<List<Integer>> generateLottoNumbers(int amount){
        OutputView.printAmountLotto(amount);
        List<List<Integer>> lottoNumbersList = LottoGenerate.generateLottoNumbers(amount);
        OutputView.printLottoList(lottoNumbersList);
        return lottoNumbersList;
    }
}
