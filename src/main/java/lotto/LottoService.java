package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoShop lottoShop = new LottoShop();

    public void serviceStart() {
        int money = inputView.inputPurchaseAmount();
        int lottoCount = lottoShop.buyLotto(money);
        List<Lotto> lottoTickets = getLottoTickets(lottoCount);
    }

    public List<Lotto> getLottoTickets(int count) {
        List<Lotto> lottoSets = new ArrayList<>(); // 발행 목록 정의 -> !클래스 따로 만들 것인가 고민
        for (int i = 0; i < count; i++) { // 로또 발행
            // 로또 생성
            lottoSets.add(lottoShop.generateLottoTicket());
        }
        outputView.outputLottoTickets(lottoSets);
        return lottoSets;
    }
}

