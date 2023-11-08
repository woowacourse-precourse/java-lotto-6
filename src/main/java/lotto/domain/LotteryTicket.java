package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryTicket {
    private static final int startnum = 1;
    private static final int finshnum = 45;
    private static final int choosenum = 6;

    private static List<Integer> Lotterynum;

    public static List<Integer> RandomLottoNum(){
        Lotterynum = Randoms.pickUniqueNumbersInRange(startnum,finshnum,choosenum);
        List<Integer> LotteryList = new ArrayList<>(Lotterynum);
        Collections.sort(LotteryList);
        return LotteryList;
    }



}
