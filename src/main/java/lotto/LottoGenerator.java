package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int NUMBERS_TO_PICK = 6;

    public static List<List<Integer>> buyLottoTickets(int lottoPurchaseAmount){
        List<List<Integer>> lottoTickets = new ArrayList<>();
        for(int i=0;i<lottoPurchaseAmount;i++){
            List<Integer> lottoNumber = generateLottoNumbers();
            lottoTickets.add(lottoNumber);
        }
        return lottoTickets;
    }

    public static List<Integer> generateLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_TO_PICK);
    }
}
