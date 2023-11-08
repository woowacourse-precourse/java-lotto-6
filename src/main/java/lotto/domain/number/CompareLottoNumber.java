package lotto.domain.number;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.result.LottoPrize;

public class CompareLottoNumber {

    private final Map<LottoPrize, Integer> determinePrizeMap = new HashMap<>();
    private final BonusNumber bonusNumber;
    private final static int LIMIT_NUMBER = 2;
    private final static int BONUS_CHECK_NUMBER = 5;
    private final static int ONE = 1;

    public CompareLottoNumber(
        LottoTicket lottoTicket,
        WinningLotto winningLotto,
        BonusNumber bonusNumber
    ){
        this.bonusNumber = bonusNumber;
        createDeterminePrize();
        compareLotto(lottoTicket, winningLotto);
    }

    public void createDeterminePrize() {
      for(LottoPrize lottoPrize : LottoPrize.values()){
          determinePrizeMap.put(lottoPrize, 0);
      }
    }

    private void compareLotto(LottoTicket lottoTicket, WinningLotto winningLotto){
        for (Lotto lotto : lottoTicket.getLottoTicket()){
            selectSetMap(lotto, winningLotto);
        }
    }

    public void setDeterminePrizeMap(int answerCount){
        if(LIMIT_NUMBER < answerCount){
            determinePrizeMap.put(LottoPrize.findByNumberOfMatches(answerCount),
            determinePrizeMap.get(LottoPrize.findByNumberOfMatches(answerCount))+ONE);
        }
    }

    public void updateIfContainBonusNumber(Lotto lotto){
        if(lotto.getNumbers().contains(bonusNumber.getBonusNumber())){
            determinePrizeMap.put(LottoPrize.FIVE_MATCH,
            determinePrizeMap.get(LottoPrize.FIVE_MATCH) - ONE);

            determinePrizeMap.put(LottoPrize.FIVE_MATCH_WITH_BONUS,
            determinePrizeMap.get(LottoPrize.FIVE_MATCH_WITH_BONUS) + ONE);
        }
    }

    public void selectSetMap(Lotto lotto, WinningLotto winningLotto){
        var count =  (int) lotto.getNumbers().stream()
            .filter(number -> winningLotto.getWinningLotto().isDuplicate(number))
            .count();

        setDeterminePrizeMap(count);

        if(count == BONUS_CHECK_NUMBER){
            updateIfContainBonusNumber(lotto);
        }
    }

    public Map<LottoPrize, Integer> getDeterminePrizeMap() {
        return determinePrizeMap;
    }
}