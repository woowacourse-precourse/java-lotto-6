package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningNumber;
import lotto.view.UserOutput;

public class LottoGame {
    private final BuyPriceController buyPriceController = new BuyPriceController();
    private final LottoController lottoController = new LottoController();
    private final WinningNumberController winningNumberController = new WinningNumberController();
    private UserOutput userOutput =new UserOutput();
    private List<Lotto> lottos;
    private WinningNumber winningNumber;
    private Map<Rank, Integer> randIndex = new HashMap<>();

    public LottoGame() {
        for(Rank r : Rank.values()){
            randIndex.put(r,0);
        }
    }

    public void game() {
        int money = buyPriceController.setBuyPrice();
        this.lottos = lottoController.lottoIndexGenerate(money);

        this.winningNumber = winningNumberController.setWinningNumber();
        float profit = calculateProfit(money);
        userOutput.outputResult(randIndex);
        System.out.println("총 수익률은 "+profit+"%입니다.");
    }

    private float calculateProfit(float money) {
        List<Integer> store = new ArrayList<>();
        float prize = 0;
        float profit = 0;
        for (Lotto lotto : this.lottos) {
            store.add(compareLottoIndex(lotto));
        }
        for(Integer number : store){
            decideRank(number);
        }
        for(Rank k : randIndex.keySet()){
            prize += randIndex.get(k)*k.getPrize();
        }
        profit = (prize/money)*100;
        return profit;
    }
    public int compareLottoIndex(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> count = numbers.stream().filter(n -> winningNumber.getWinNumber().stream()
                .anyMatch(Predicate.isEqual(n))).collect(Collectors.toList());
        if(count.size()==5){
            return bonusNumberCheck(numbers);
        }

        return count.size();
    }
    private void decideRank(Integer match){

        for(Rank r : Rank.values()){
            pushRankIndex(r,r.include(match));
        }
    }
    private void pushRankIndex(Rank r,boolean include){
        if(!include){
            return;
        }
        randIndex.put(r, randIndex.get(r)+1);
    }
    private int bonusNumberCheck(List<Integer> numbers){
        if(numbers.contains(winningNumber.getBonusNumber())){
            return 7;
        }
        return 5;
    }
}
