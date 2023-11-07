package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGameService {

    private List<Lotto> lottos = new ArrayList<>();
    private List<Integer> winningNumbers;

    public void buyLottosWithBudget(Integer budget) {
        for (int i = 0; i < calculatePurchaseQuantity(budget); i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers.stream().sorted().toList()));
        }
    }

    private Integer calculatePurchaseQuantity(Integer budget) {
        return budget / Lotto.PRICE;
    }

    public Integer getLottoCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setWinningNumbers(String winningNumberInput) {
        String[] numbers = winningNumberInput.split(",");

        winningNumbers = Arrays.stream(numbers)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
