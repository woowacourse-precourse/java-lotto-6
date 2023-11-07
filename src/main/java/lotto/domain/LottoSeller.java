package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoSeller {

    public static List<Lotto> createLottoTickets(int lottoQuantity) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i< lottoQuantity; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottoList.add(lotto);
        }
        return lottoList;
    }

    private static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static int exchangeTicketsForPurchaseAmount(int purchaseAmount) {
        return purchaseAmount/1000;
    }
}
