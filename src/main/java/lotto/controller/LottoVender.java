package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LottoChecker;
import lotto.domain.Lotto;
import lotto.domain.ProfitCalculator;
import lotto.domain.WinningPrize;
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
        try {
            buyLotto();
            setWinningNumber();
            showResult();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void buyLotto(){
        inputPrice = InputView.inputLottoPrice();
        payPrice(inputPrice);
        OutputView.showCount(lottoCount);
        boughtTickets = getLotto(lottoCount);
        OutputView.showLottoTickets(setLottoList(boughtTickets));
    }

    public void setWinningNumber(){
        winningNumber = InputView.inputLottoNum();
        bonusNumber = InputView.inputBonusNum();
    }

    public void showResult(){
        List<Integer> result = checkResult(boughtTickets, winningNumber, bonusNumber);
        int totalProfit = getTotalProfit(result);
        ProfitCalculator calculator = new ProfitCalculator(inputPrice,totalProfit);
        String profitPer = calculator.calculate();
        List<String> messageList = makeMessageList();
        OutputView.showLottoResult(result, profitPer, messageList);
    }

    public List<String> makeMessageList(){
        String[] matchArray = WinningPrize.matchArray;
        List<String> messageArray = new ArrayList<>();
        for(int i=0; i<5; i++){
            String message = WinningPrize.valueOf(matchArray[i]).getMessage();
            messageArray.add(message);
        }
        return messageArray;
    }

    public void payPrice(int inputPrice){
        lottoCount = inputPrice / LOTTO_PRICE;
    }

    public List<Lotto> getLotto(int buyLottoCount){
        List<Lotto> lottoticekts = new ArrayList<>();
        for(int i = 0; i<buyLottoCount; i++){
            //6개의 랜덤 로또 번호 생성해주는 numbers
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            //Randoms.pickUniqueNumbersInRange 메서드는 unmodifiableList를 반환해주기때문에 수정할 수 있도록 modifiablelist로 새로 만들어줌
            Collections.sort(numbers);
            lottoticekts.add(new Lotto(numbers));
        }
        return lottoticekts;
    }

    public List<String> setLottoList(List<Lotto> lottos){
        List<String> lottoList = new ArrayList<>();

        for(Lotto lotto : lottos){
            lottoList.add(lotto.toString());
        }

        return lottoList;
    }

    public List<Integer> checkResult(List<Lotto> lottos, String winningNumber, String bonusNumber){
        LottoChecker checker = new LottoChecker(lottos, winningNumber, bonusNumber);
        List<Integer> result = checker.checkResult();
        return result;
    }

    public int getTotalProfit(List<Integer> result){
        String[] matchArray = WinningPrize.matchArray;
        int totalProfit = 0;
        for(int i=0; i<5; i++){
            int price = WinningPrize.valueOf(matchArray[i]).getPrice();
            totalProfit += result.get(i) * price;
        }
        return totalProfit;
    }

}
