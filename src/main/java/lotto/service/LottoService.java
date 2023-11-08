package lotto.service;

import static lotto.config.RuleConfig.BASE_LOTTO_PRICE;
import static lotto.config.RuleConfig.DIGIT;
import static lotto.config.RuleConfig.MAX_LOTTO_NUM;
import static lotto.config.RuleConfig.MIN_LOTTO_NUM;
import static lotto.config.RuleConfig.NUMBERS_PER_LOTTO;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.RankGroup;
import lotto.model.WinningLotto;

public class LottoService {
    private final WinningLotto winningLotto;

    public LottoService(WinningLotto winningLotto){
        this.winningLotto = winningLotto;
    }

    public List<Lotto> generateLottos(final int trial){
        List<Lotto> myLotto = new ArrayList<>();
        for(int i = 0; i < trial; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, NUMBERS_PER_LOTTO);
            List<Integer> sortedNumbers = numbers.stream()
                    .sorted()
                    .collect(Collectors.toList());
            Lotto newLotto = new Lotto(sortedNumbers);
            myLotto.add(newLotto);
        }
        return myLotto;
    }

    public void aggregateLotto(List<Lotto> myLotto, Lotto winningLotto, int bonusNumber){
        for(Lotto lotto: myLotto){
            int matchedNumbers = (int) lotto.getLotto().stream()
                    .filter(winningLotto.getLotto()::contains)
                    .count();
            boolean haveBonusNumber = lotto.getLotto().contains(bonusNumber);

            Optional<RankGroup> rankGroup = RankGroup.findByLotto(haveBonusNumber, matchedNumbers);
            rankGroup.ifPresent(RankGroup::increaseResult);
        }
    }

    public Lotto pickWinningLotto(String numbersBeforeValidated){
        winningLotto.createWinningLotto(numbersBeforeValidated);
        return winningLotto.getWinningLotto();
    }

    public int pickBonusNumber(String bonusNumberBeforeValidated){
        winningLotto.createBonusNumber(bonusNumberBeforeValidated);
        return winningLotto.getBonusNumber();
    }

    public BigDecimal countProfitRate(final int trial){
        BigDecimal total = new BigDecimal(RankGroup.getTotalReward());
        BigDecimal baseLottoPrice = new BigDecimal(BASE_LOTTO_PRICE);
        BigDecimal totalCost = baseLottoPrice.multiply(new BigDecimal(trial));

        return total.divide(totalCost, DIGIT+2, RoundingMode.HALF_EVEN).multiply(new BigDecimal(100));
    }
}
