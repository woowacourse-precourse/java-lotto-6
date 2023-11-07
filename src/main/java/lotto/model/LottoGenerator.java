package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.view.InputView;

public class LottoGenerator {

    public static final int LOTTO_PRICE = 1000;

    public static LottoBundle getLottoBundle() {
        Integer lottoMoney = InputView.getLottoMoney();

        Integer lottoCount = calculateLottoCount(lottoMoney);

        List<Lotto> lottoTickets = generateLottoTickets(lottoCount);
        return new LottoBundle(lottoTickets);
    }

    private static List<Lotto> generateLottoTickets(Integer lottoCount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = NumberGenerator.getLottoNumber();
            lottoTickets.add(new Lotto(lottoNumbers));
        }
        return lottoTickets;
    }

    private static Integer calculateLottoCount(Integer lottoMoney) {
        return lottoMoney / LOTTO_PRICE;
    }

}
