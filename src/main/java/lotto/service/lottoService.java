package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Rank;

public class lottoService {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static List<Lotto> lottos;
    private LinkedHashMap<Rank, Integer> stats;
     public lottoService(){
        lottos = new ArrayList<>();
        stats = new LinkedHashMap<>();
    }

    public static List<Lotto> publishLottos(int ticketCount){
         for(int i=0;i<ticketCount;i++){
             createLottos();
         }
        return lottos;
    }

    public static List<Lotto> getLottos(){ return lottos; }

    private static void createLottos(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LOWER_BOUND,
                UPPER_BOUND,
                LOTTO_NUMBER_COUNT);
        lottos.add(new Lotto(numbers));
    }
}
