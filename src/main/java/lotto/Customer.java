package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.event.ListDataListener;

public class Customer {
    private final List<Lotto> pocket;

    Customer () {
        this.pocket = new ArrayList<Lotto>();
    }
    Customer (List<Lotto> pocket) {
        this.pocket = pocket;
    }

    public void addPocket(Lotto lotto){
        this.pocket.add(lotto);
    }
    public List<Lotto> getPocket(){return this.pocket;}
    public void printPocket() {
        List<Lotto> pocket = this.getPocket();
        for(int i=0; i<pocket.size(); i++){
            String lotto = pocket.get(i).getNumbers().toString();
            System.out.println(lotto);
        }
    }
    public void buyLottos(Integer lottoamount){
            for(int i=0; i<lottoamount; i++){
                Lotto singleLotto = Lotto.makingSingleLotto();
                this.addPocket(singleLotto);
            }
    }

    public void judgment(List<Integer> winningNumbers, Integer bonus, List<LottoResults> results){
        for(int i=0; i<this.getPocket().size(); i++) {
            List<Integer> result = judgeSingleLotto(winningNumbers,bonus,i);

            if(result.get(0) == 6) {results.get(0).addCounts();}
            if(result.get(0) == 5 && result.get(1) == 1) {results.get(1).addCounts();}
            if(result.get(0) == 5 && result.get(1) == 0) {results.get(2).addCounts();}
            if(result.get(0) == 4) {results.get(3).addCounts();}
            if(result.get(0) == 3) {results.get(4).addCounts();}
        }
    }
    public List<Integer> judgeSingleLotto(List<Integer> winningNumbers, Integer bonus, int index){
        Integer count = 0;
        Integer bonusCount = 0;
        for (int j = 0; j < 6; j++) {
            if (this.getPocket().get(index).getNumbers().contains(winningNumbers.get(j))){
                count += 1;
            }
            if(this.getPocket().get(index).getNumbers().contains(bonus)){
                bonusCount += 1;
            }
        }
        return Arrays.asList(count, bonusCount);
    }

    public static Integer calculatePrize(List<LottoResults> results){
        Integer prize = 0;
        prize += (results.get(0).getCounts() * 2000000000);
        prize += (results.get(1).getCounts() * 30000000);
        prize += (results.get(2).getCounts() * 1500000);
        prize += (results.get(3).getCounts() * 50000);
        prize += (results.get(4).getCounts() * 5000);
        return prize;
    }
    public static Double calculatePrizeRate(Integer prize, Integer money){
        Double prizeRate = Double.valueOf(prize) / Double.valueOf(money);
        Double result = ((prizeRate * 100.0) * 10.0) / 10.0;

        return result;
    }
}
