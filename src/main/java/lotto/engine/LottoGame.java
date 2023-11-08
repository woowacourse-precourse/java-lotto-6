package lotto.engine;

import static lotto.engine.LottoSystemConstant.LOTTO_MINIMUM_NUMBER_OF_WINNINGS;
import static lotto.engine.LottoSystemConstant.LOTTO_PRICE;

import java.util.List;
import java.util.stream.Collectors;
import lotto.engine.LottoSystemConstant.TextMessage.Pattern;
import lotto.engine.domain.Customer;
import lotto.engine.domain.Lotto;
import lotto.engine.dto.WinningResult;
import lotto.engine.manager.LottoFactory;
import lotto.view.LottoGameViewer;

public final class LottoGame {
    private final LottoGameViewer viewer;
    private final LottoFactory lottoFactory;

    public LottoGame(LottoGameViewer viewer, LottoFactory lottoFactory) {
        this.viewer = viewer;
        this.lottoFactory = lottoFactory;
    }

    public void start() {
        int money = viewer.interactForBuyLotto();
        int quantity = money / LOTTO_PRICE.value();
        viewer.printNewLine();

        viewer.println(() -> String.format(Pattern.BUY_RESULT.getMessage(), quantity));
        List<Lotto> lottos = lottoFactory.issueLotto(quantity);
        showTotalLotto(lottos);

        List<Integer> numbers = viewer.interactForWinningNumber();
        viewer.printNewLine();

        int bonus = viewer.interactForBonusNumber();
        viewer.printNewLine();

        Customer customer = new Customer(numbers, bonus);
        WinningResult winningResult = lottoFactory.aggregate(customer, lottos);
        viewer.println(() -> showAggregation(winningResult));
    }

    private String showAggregation(WinningResult winningResult) {

        return String.format(Pattern.AGGREGATION_RESULTS.getMessage(),
                winningResult.winningCriteria().get(LOTTO_MINIMUM_NUMBER_OF_WINNINGS.value()),
                winningResult.winningCriteria().get(4),
                winningResult.winningCriteria().get(5),
                winningResult.specailMatchCount(),
                winningResult.winningCriteria().get(LOTTO_MINIMUM_NUMBER_OF_WINNINGS.value()),
                winningResult.profit()
        );
    }

    private void showTotalLotto(List<Lotto> lottos) {
        String issuedTotalLotto = lottos.stream()
                .map(Lotto::showNumbers)
                .collect(Collectors.joining("\n"));

        viewer.println(() -> issuedTotalLotto);
        viewer.printNewLine();
    }

}
