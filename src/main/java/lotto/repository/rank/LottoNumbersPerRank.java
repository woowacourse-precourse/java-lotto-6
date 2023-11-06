package lotto.repository.rank;

import java.util.HashMap;
import java.util.Map;
import lotto.settings.WinningAmount;

public class LottoNumbersPerRank {
    private static final Map<Integer, Integer> lottoPerRank = new HashMap<>();

    public static void create(){
        int size = WinningAmount.size(); // 몇등까지 있는지
        for(int i = 1; i<= size; i++){
            lottoPerRank.put(i,0);
        }
    }

    public static void plus(int rank) {
        lottoPerRank.merge(rank, 1, Integer::sum);
    }

    public static Integer getNumberBy(int rank){
        return lottoPerRank.get(rank);
    }
}
