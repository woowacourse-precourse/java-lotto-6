package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    final static int START_NUMBER = 1;
    final static int END_NUMBER = 45;
    final static int COUNT_NUMBER = 6;
    static int lottoCnt;
    public static int issuanceLotto(int money){
        lottoCnt = money/1000;
        return lottoCnt;
    }

    public static List<List<Integer>> getLotto(){
        List<List<Integer>> tickets = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            tickets.add(getRandomNumbers());
        }
        for(List<Integer> ticket : tickets){
            System.out.println(ticket);
        }
        return tickets;
    }



    public static List<Integer> getRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(START_NUMBER,END_NUMBER,COUNT_NUMBER);
    }
}
