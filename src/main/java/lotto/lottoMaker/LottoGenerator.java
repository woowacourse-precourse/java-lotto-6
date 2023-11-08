package lotto.lottoMaker;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public static void generate(List<Lotto> lottoTicket, int numOfTicket) {
        for(int i=0; i<numOfTicket; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoTicket.add(new Lotto(numbers));
        }
    }

    public static void printLottoTicket(List<Lotto> lottoTicket) {
        for(Lotto lo : lottoTicket) {
            System.out.println(lo.getNumbers());
        }
    }
}
