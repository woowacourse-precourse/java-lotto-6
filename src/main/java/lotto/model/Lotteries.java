package lotto.model;

import java.util.*;
import lotto.MatchNumber;
import lotto.util.Constants;

public class Lotteries {

    private final int purchaseNumber;
    public static List<Lotto> lottos = new ArrayList<>();


    public Lotteries(int purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public List<Lotto> purchaseLotto() {
        for (int i = 0; i < purchaseNumber / Constants.TICKET_MINIMUN_PRICE; i++) {
            lottos.add(Lotto.createLotto());
        }
        return lottos;
    }

    public static MatchNumber compareLottoNumber(List<Integer> winningNumber, List<Integer> lottoNumber,
                                                 int bonusNumber) {
        int matchCount = 0;
        boolean bonusMatch = false;
        for (int number : lottoNumber) {
            if (winningNumber.contains(number)) {
                matchCount++;
            }
            if (number == bonusNumber) {
                bonusMatch = true;
            }
        }
        return MatchNumber.valueOf(matchCount, bonusMatch);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
