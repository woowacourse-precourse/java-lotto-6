package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {
    public Money putMoney() {
        return InputView.inputMoney();
    }

    public Lottos buyLottos(Money money) {
        int buyLottoCount = money.getBuyLottoCount();
        OutputView.outputBuyLottoCount(buyLottoCount);
        return makeLottos(buyLottoCount);
    }

    private Lottos makeLottos(int buyLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        while(buyLottoCount > 0) {
            lottos.add(makeLotto());
            buyLottoCount--;
        }
        return Lottos.from(lottos);
    }

    private Lotto makeLotto() {
        List<Integer> uniqueRandomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(uniqueRandomNumbers);
        OutputView.outputLottoNumbers(lotto);
        return lotto;
    }

    public WinnerLotto putWinnerLotto() {
        return InputView.inputWinnerLotto();
    }

    public void calculateLottoResults(Lottos userLottos, WinnerLotto winnerLotto) {
        Map<LottoRank, Integer> userLottoResultsRank = new LinkedHashMap<>();
        List<LottoRank> userLottoResults = getUserLottoResults(userLottos, winnerLotto);
        Arrays.stream(LottoRank.values())
                .filter(userLottoResults::contains)
                .forEach(rank -> userLottoResultsRank.put(rank, getWinningCount(rank, userLottoResults)));
        OutputView.outputAllRankMatchResults(userLottoResultsRank);
    }

    private List<LottoRank> getUserLottoResults(Lottos userLottos, WinnerLotto winnerLotto) {
        return userLottos.getLottos().stream()
                .map(winnerLotto::matchWinnerLotto)
                .filter(Objects::nonNull)
                .toList();
    }

    private int getWinningCount(LottoRank rank, List<LottoRank> userLottoResults) {
        return Long.valueOf(userLottoResults.stream()
                .filter(result -> rank.compareTo(result) == 0)
                .count()).intValue();
    }

}
