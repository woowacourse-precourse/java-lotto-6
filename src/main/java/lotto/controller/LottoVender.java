package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LottoChecker;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoVender {
    private final int LOTTO_PRICE = 1000;
    private int inputPrice;
    private int lottoCount;
    private List<Lotto> boughtTickets;
    private String winningNumber;
    private String bonusNumber;

    public int getLottoCount() {
        return lottoCount;
    }
    public int getInputPrice() {
        return inputPrice;
    }

    public void start(){
        buyLotto();
        setWinningNumber();
        showResult();
    }

    public void buyLotto(){
        inputPrice = InputView.inputLottoPrice();
        payPrice(inputPrice);
        OutputView.showCount(lottoCount);
        boughtTickets = getLotto(lottoCount);
        OutputView.showLottoTickets(boughtTickets);
    }

    public void setWinningNumber(){
        winningNumber = InputView.inputLottoNum();
        bonusNumber = InputView.inputBonusNum();
    }

    public void showResult(){
        List<Integer> result = checkResult(boughtTickets, winningNumber, bonusNumber);
        //OutputView.showLottoResult(result);
    }

    public void payPrice(int inputPrice){
        lottoCount = inputPrice / LOTTO_PRICE;
    }

    public List<Lotto> getLotto(int buyLottoCount){
        List<Lotto> lottoticekts = new ArrayList<>();
        for(int i = 0; i<buyLottoCount; i++){
            //6개의 랜덤 로또 번호 생성해주는 numbers
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottoticekts.add(new Lotto(numbers));
        }
        return lottoticekts;
    }

    public List<Integer> checkResult(List<Lotto> lottos, String winningNumber, String bonusNumber){
        LottoChecker checker = new LottoChecker(lottos, winningNumber, bonusNumber);
        List<Integer> result = checker.checkResult();
        return result;
    }

}
