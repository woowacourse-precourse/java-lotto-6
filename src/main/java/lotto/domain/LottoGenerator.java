package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public static final int LOTTO_PRICE = 1000;

    public List<Lotto> getTickets(int money){
        List<Lotto> allTickets = new ArrayList<>();
        int tickets = money/1000;
        for (int i = 0; i <tickets ; i++) {
            allTickets.add(generateTicket());
        }
        return allTickets;
    }

    public Lotto generateTicket(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

}
