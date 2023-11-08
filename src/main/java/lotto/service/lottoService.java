package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import lotto.model.Cash;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningLotto;

public class lottoService {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static List<Lotto> lottos;
    private static LinkedHashMap<Rank, Integer> lottoHashMap;
     public lottoService(){
        lottos = new ArrayList<>();
         lottoHashMap = new LinkedHashMap<>();
    }

    public static List<Lotto> publishLottos(int ticketCount){
         for(int i=0;i<ticketCount;i++){
             createLottos();
         }
        return lottos;
    }

    public static List<Lotto> getLottos(){ return lottos; }

    public static void compareLottos(WinningLotto winningNumber){
        initHash();
         for(int i=0;i<lottos.size();i++){
             Rank result = lottos.get(i).compare(winningNumber);
             lottoHashMap.put(result, lottoHashMap.get(result) + 1);
         }
    }

    public static LinkedHashMap<Rank, Integer> getLottoHashMap(){
         return lottoHashMap;
    }

    private static void initHash() {
        for (Rank rank : Rank.values()) {
            lottoHashMap.put(rank, 0);
        }
    }

    public static double getProfitRate(){
        double profitAmount = getProfitAmount();
        double cashAmount = Cash.getAmount();

        return profitAmount / cashAmount * 100;
    }

    private static double getProfitAmount(){
        double amount = 0;
        for(Entry<Rank,Integer> hash : lottoHashMap.entrySet()){
            if(hash.getKey().equals(Rank.NONE)){ continue; }
            amount += hash.getKey().getPrice() * hash.getValue();
        }
        return amount;
    }

    private static void createLottos(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LOWER_BOUND,
                UPPER_BOUND,
                LOTTO_NUMBER_COUNT);
        lottos.add(new Lotto(numbers));
    }

}
