package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;
import lotto.message.ErrorMessage;
import lotto.view.OutputView;

public class LottoIssuer {

    private static final int lottoPrice = 1000;
    private static final int minimumLottoNum = 1;
    private static final int maximumLottoNum = 45;
    private static final int lottoNumbersCount = 6;

    public List<Lotto> buy(int price) {
        if (!hasCorrectUnit(price)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PRICE_VALUE.getMessage());
        }
        if (!isPositive(price)) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_PRICE_VALUE.getMessage());
        }
        int quantity = calculateQuantity(price);
        List<Lotto> lottos = issueLottos(quantity);
        printLottos(lottos);
        return lottos;
    }

    private void printLottos(List<Lotto> lottos) {
        OutputView.printIssueResults(lottos);
    }

    private int calculateQuantity(int price) {
        return price / lottoPrice;
    }

    private List<Lotto> issueLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = createLottoNumbers();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private List<Integer> createLottoNumbers() {
        return pickUniqueNumbersInRange(minimumLottoNum, maximumLottoNum, lottoNumbersCount);
    }

    private boolean hasCorrectUnit(int price) {
        return price % lottoPrice == 0;
    }

    private boolean isPositive(int price) {
        return price > 0;
    }
}
