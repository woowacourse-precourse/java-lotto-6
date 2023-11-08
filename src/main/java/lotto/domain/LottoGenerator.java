package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public static final int LOTTO_PRICE = 1000;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_NUM_LENGTH = 6;

    public List<Lotto> makeTickets(int tickets){
        List<Lotto> allTickets = new ArrayList<>();
        for (int i = 0; i <tickets ; i++) {
            allTickets.add(generateTicket());
        }
        return allTickets;
    }

    public Lotto generateTicket(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUM_LENGTH));
    }

}