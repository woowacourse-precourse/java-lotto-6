package lotto.service;

import lotto.model.ClientInform;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private Lottos lottos;
    private WinningLotto winningLotto;
    private LottoNumberGenerator lottoNumberGenerator;
    private ClientInform clientInform;
    private static LottoService instance;

    private LottoService() {
        lottoNumberGenerator = LottoNumberGenerator.getInstance();
    }

    public static LottoService getInstance() {
        if(instance == null) {
            instance = new LottoService();
        }
        return instance;
    }

    public void makeLottoByPurchaseAmount(String purchaseAmount) {
        int purchase = Integer.parseInt(purchaseAmount);
        // 1. ClientInform 만들기
        clientInform = ClientInform.getInstance(purchase);
        // 2. 로또 객체 만들기 (구매 금액만큼 로또를 만들어야함)
        List<Lotto> newLottos = new ArrayList<>();
        int lottoNum = clientInform.getLottoNum();
        while(lottoNum --> 0) {
            newLottos.add(new Lotto(lottoNumberGenerator.makeLottoNumbers()));
        }
        // 3. List<Lotto>로 Lottos객체 만들기
        lottos = Lottos.getInstance(newLottos);
    }

    public String getLottoNumbers() {
        return lottos.getLottos();
    }
}
