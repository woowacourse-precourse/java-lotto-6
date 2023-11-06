package lotto.service;

import static lotto.RankGroup.increaseResult;
import static lotto.config.RuleConfig.BASE_LOTTO_PRICE;
import static lotto.config.RuleConfig.MAX_LOTTO_NUM;
import static lotto.config.RuleConfig.MIN_LOTTO_NUM;
import static lotto.config.RuleConfig.NUMBERS_PER_LOTTO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.RankGroup;
import lotto.WinningLotto;

public class LottoService {
    public List<Lotto> myLotto = new ArrayList<>();
    private static Lotto winningLotto;
    private int bonusNumber;

    public List<Lotto> getLottos(){
        return myLotto;
    }
    public void generateLottos(final int trial){
        for(int i = 0; i < trial; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, NUMBERS_PER_LOTTO);
            List<Integer> sortedNumbers = numbers.stream()
                    .sorted()
                    .collect(Collectors.toList());
            Lotto newLotto = new Lotto(sortedNumbers);
            myLotto.add(newLotto);
        }
    }
    public void aggregateLotto(){
        for(Lotto lotto: myLotto){
            Lotto finalPickedLotto = winningLotto;

            int matchedNumbers = (int) lotto.getLotto().stream()
                    .filter(finalPickedLotto.getLotto()::contains)
                    .count();
            boolean haveBonusNumber = finalPickedLotto.getLotto().contains(bonusNumber);

            Optional<RankGroup> rankGroup = RankGroup.findByLotto(haveBonusNumber, matchedNumbers);
            if(rankGroup.isPresent()){
                increaseResult(rankGroup.get());
            }
        }
    }
    public void pickWinningLotto(String numbersBeforeValidated){
        WinningLotto.getInstance().createWinningLotto(numbersBeforeValidated);
        winningLotto = WinningLotto.getInstance().getWinningLotto();
    }
    public void pickBonusNumber(String bonusNumberBeforeValidated){
        WinningLotto.getInstance().createBonusNumber(bonusNumberBeforeValidated);
        bonusNumber = WinningLotto.getInstance().getBonusNumber();
    }
    public float countProfitRate(final int trial){
        int total = RankGroup.getTotalReward();
        float profitRate = ((float) total / (float)(trial * BASE_LOTTO_PRICE)) * 100;
        return profitRate;
    }
}
