package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.domain.Rank;
import lotto.io.BonusNumberInputManager;
import lotto.io.PaymentInputManager;
import lotto.io.WinningNumberInputManager;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoService {
    private final WinningNumberInputManager winningNumberInputManager;
    private final PaymentInputManager paymentInputManager;
    private final BonusNumberInputManager bonusNumberInputManager;
    private Integer bonusNumber;
    private final Set<Rank> rankBoard = new HashSet<>();
    private static LottoService INSTANCE;

    private LottoService() {
        this.winningNumberInputManager = WinningNumberInputManager.getInstance();
        this.paymentInputManager = PaymentInputManager.getInstance();
        this.bonusNumberInputManager = BonusNumberInputManager.getInstance();
        this.bonusNumber = 0;
    }

    public static LottoService getInstance() {
        if (INSTANCE == null) INSTANCE = new LottoService();
        return INSTANCE;
    }

    /**
     * 구매한 로또들 반환
     */
    public List<Lotto> buyLottos() {
        Integer input = paymentInputManager.input();
        LottoShop lottoShop = new LottoShop(input);
        return lottoShop.getLottos();
    }

    /**
     * 당첨번호 반환
     */
    public Lotto chooseWinningLottos() {
        List<Integer> winningNumbers = winningNumberInputManager.input();
        // TODO: 2023-11-08 오전 1:38 출력
        bonusNumber = bonusNumberInputManager.input();
        // TODO: 2023-11-08 오전 1:38 출력
        return new Lotto(winningNumbers);
    }

    public void executeLotto() {
        List<Lotto> boughtLottos = buyLottos();
        Lotto winningLotto = chooseWinningLottos();
        for (Lotto boughtLotto : boughtLottos)
            decideRank(boughtLotto, winningLotto);
    }

    private void decideRank(Lotto boughtLotto, Lotto winningLotto) {
        Integer matchingCount = boughtLotto.countMatchingNumber(winningLotto,bonusNumber);
        Boolean isMatch = boughtLotto.checkMatchingNumber(bonusNumber);
        rankBoard.add(Rank.of(isMatch, matchingCount));
    }
    // TODO: 2023-11-08 오전 1:37 결과 출력
}
