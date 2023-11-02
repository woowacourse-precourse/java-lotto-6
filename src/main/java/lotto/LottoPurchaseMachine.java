package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseMachine {

    private static final int LOTTO_PRICE = 1000;

    public ArrayList<Lotto> publishLottoTicket(int purchaseAmount) {

        int publishCount = calculatePublishCount(purchaseAmount);
        ArrayList<Lotto> lottoTickets = new ArrayList<>();
        while (publishCount-- > 0) {
            List<Integer> lottoNumbers = LottoNumbersGenerator.generateRandomNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }

    private static int calculatePublishCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
}
