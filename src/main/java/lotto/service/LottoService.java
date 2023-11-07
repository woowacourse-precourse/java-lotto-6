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

    /*
    TODO
    Service에서 로또 매칭결과 생성
    -> Rank별 결과 출력
    -> 수익통계 결과 출력
     */

    public void calculateLottoResults(Lottos userLottos, WinnerLotto winnerLotto) {
        Map<LottoRank, Integer> allRankResult = new LinkedHashMap<>();
        List<LottoRank> userLottoResults = getUserLottoResults(userLottos, winnerLotto);
        Arrays.stream(LottoRank.values())
                .filter(userLottoResults::contains)
                .forEach(rank -> allRankResult.put(rank, getWinningCount(rank, userLottoResults)));
        OutputView.outputAllRankMatchResults(allRankResult);
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
