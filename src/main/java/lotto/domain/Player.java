package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.exception.LottoValidator;
import lotto.util.LottoValues;
import lotto.util.RankingMessage;

public class Player {

    Map<Lotto,CorrectCount> lottos;

    public Player() {
        lottos = new HashMap<>();
    }

    public void addLotto(Lotto lotto) {
        lottos.put(lotto, new CorrectCount(0,0));
    }

    public List<Lotto> getLottoPapers(){
        return lottos.keySet().stream().toList();
    }

    public List<CorrectCount> getCorrectLottoCounts(){
        return lottos.values().stream().toList();
    }

    public int getNumberOfLotto(){
        return lottos.size();
    }

    public void setLottoCorrectCount(Lotto lotto, CorrectCount correctCount){
        CorrectCount replace = lottos.replace(lotto, correctCount);
        LottoValidator.validate(replace);
    }

    public int getNumberCount(String message, int rankCount) {
        List<CorrectCount> correctLottoCounts = getCorrectLottoCounts();

        if(message.equals(RankingMessage.SECOND_RANK.toString())){
            return getCorrectSecondNumberCount(rankCount, correctLottoCounts).intValue();
        }
        if(message.equals(RankingMessage.THIRD_RANK.toString())){
            return getCorrectThirdNumberCount(rankCount, correctLottoCounts).intValue();
        }
        return getCorrectNumberCount(rankCount, correctLottoCounts).intValue();
    }

    private Long getCorrectNumberCount(int rankCount, List<CorrectCount> correctLottoCounts) {
        return correctLottoCounts.stream().filter(correctCount -> correctCount.getCorrectNumberCount() == rankCount).count();
    }

    private Long getCorrectSecondNumberCount(int rankCount, List<CorrectCount> correctLottoCounts) {
        return correctLottoCounts.stream().filter(correctCount ->
                (correctCount.getCorrectNumberCount() == rankCount) &&
                        (correctCount.getCorrectBonusNumberCount() == LottoValues.BONUS_NUMBER_COUNT)).count();
    }
    private Long getCorrectThirdNumberCount(int rankCount, List<CorrectCount> correctLottoCounts) {
        return correctLottoCounts.stream().filter(correctCount ->
                (correctCount.getCorrectNumberCount() == rankCount) &&
                        (correctCount.getCorrectBonusNumberCount() == 0)).count();
    }
}
