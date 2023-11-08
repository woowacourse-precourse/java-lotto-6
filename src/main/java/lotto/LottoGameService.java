package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.constant.Prize;
import lotto.model.LottoResult;

public class LottoGameService {

    public List<Lotto> buyLottosWithBudget(Integer budget) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < calculatePurchaseQuantity(budget); i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers.stream().sorted().toList()));
        }

        return lottos;
    }

    private Integer calculatePurchaseQuantity(Integer budget) {
        return budget / Lotto.PRICE;
    }

    public LottoResult calculateTotalResult(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber) {

        LottoResult totalResult = new LottoResult();

        for (Lotto lotto : lottos) {
            LottoResult result = makeResult(lotto, winningNumbers, bonusNumber);
            totalResult.addResult(result);
        }

        return totalResult;
    }

    LottoResult makeResult(Lotto lotto, List<Integer> winningNumbers, Integer bonusNumber) {

        List<Integer> lottoNumbers = lotto.getNumbers();
        Integer matchCount = lottoNumbers.stream()
            .filter(old -> winningNumbers.stream()
                .anyMatch(Predicate.isEqual(old)))
            .toList()
            .size();

        if (matchCount == 5 && winningNumbers.contains(bonusNumber)) {
            return new LottoResult(Prize.SECOND);
        }

        Prize prize = Prize.getPrizeByMatchCount(matchCount);
        if (prize != null) {
            return new LottoResult(prize);
        }

        return new LottoResult();
    }

    public Double calculateReturnRate(Integer totalProfit, Integer budget) {
        return (totalProfit.doubleValue() / budget) * 100;
    }

}
