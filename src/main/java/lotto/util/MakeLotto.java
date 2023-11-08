package lotto.util;

import lotto.domain.Lotto;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MakeLotto {

    public List<Lotto> makeLottoList(int lottoTickets) {
        OutputView.ticketCountMessage(lottoTickets);
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoTickets; i++) {
            Lotto lotto = new Lotto(MakeRandomNumbers.getRandomNumbers());
            System.out.println(lotto.getLottoNumbers());
            lottoList.add(lotto);
        }
        return lottoList;
    }
}
