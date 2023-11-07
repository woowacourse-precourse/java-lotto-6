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

public class LottoGame {
    private final BuyPriceController buyPriceController = new BuyPriceController();
    private final LottoController lottoController = new LottoController();
    private final WinningNumberController winningNumberController = new WinningNumberController();
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
        int profit = calculateProfit(money);
        System.out.println(profit+"%");
    }

    private int calculateProfit(int money) {
        List<Integer> store = new ArrayList<>();
        int prize = 0;
        int profit = 0;
        for (Lotto lotto : this.lottos) {
            store.add(compareLottoIndex(lotto));
        }
        for(Integer number : store){
            decideRank(number);
        }
        for(Rank k : randIndex.keySet()){
            prize =+ randIndex.get(k)*k.getPrize();
        }
        profit = (prize/money)*100;
        profit =+ (prize%money)*100;
        return profit;
    }
    private int compareLottoIndex(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> count = numbers.stream().filter(n -> winningNumber.getWinNumber().stream()
                .anyMatch(Predicate.isEqual(n))).collect(Collectors.toList());

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
}
