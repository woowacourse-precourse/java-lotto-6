package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    public LottoNumbers(){
    }

    private static final int MinNumber=1;
    private static final int LottoNumberCnt=6;
    private static final int MaxNumber=45;

    private static List<Integer> lottoNumberList;

    public static List<Integer> pickRandNumbers(){
        lottoNumberList = Randoms.pickUniqueNumbersInRange(MinNumber,MaxNumber,LottoNumberCnt);
        List<Integer> LottoTicket = new ArrayList<>(lottoNumberList);
        Collections.sort(lottoNumberList);
        return LottoTicket;
    }

}
