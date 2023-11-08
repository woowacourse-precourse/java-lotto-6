package lotto.domain;

import java.util.List;
import static lotto.enums.LottoWinningResult.*;

public class LottoStatistics {
    // lottoWinResult 에 당첨결과 넣어주기
    // winCheck 으로 몇개나 당첨됐는지 확인
    private final LottoBuy lottoBuy = new LottoBuy(); // 로또 산 금액
    private LottoWinCheck lottoWinCheck = new LottoWinCheck(); // 로또 산 사람의 당첨, 보너스 번호
    private final LottoWinResult lottoWinResult = new LottoWinResult();
    public LottoStatistics(LottoWinCheck lottoWinCheck){
        this.lottoWinCheck = lottoWinCheck;
    }
    public LottoStatistics(){}
    public void getLottoStatistics(List<Lotto> userLottos){
        for(Lotto lotto : userLottos){
            List<Integer> lottoNums = lotto.getNumbers();
            int matchCount = getMatchCount(lottoNums);
            addLottoResult(getBonusNumber(lottoNums, matchCount));
        }
    }
    private void addLottoResult(int matchCount){
        if(matchCount == THREE_WIN.getNumber()){
            lottoWinResult.addThreeWinCount();
        }
        if(matchCount == FOUR_WIN.getNumber()){
            lottoWinResult.addFourWinCount();
        }
        if(matchCount == FIVE_WIN.getNumber()){
            lottoWinResult.addFiveWinCount();
        }
        if(matchCount == FIVE_WITH_BONUS.getNumber()){
            lottoWinResult.addFiveWithBonusWinCount();
        }
        if(matchCount == SIX_WIN.getNumber()){
            lottoWinResult.addSixWinCount();
        }
    }
    public int getMatchCount(List<Integer> winningNums){
        return lottoWinCheck.winningCheck(winningNums);
    }
    public int getBonusNumber(List<Integer> userNums, int matchCount){
        if(matchCount == FIVE_WIN.getNumber() && userNums.contains(lottoWinCheck.getBonusNum())){
            return matchCount * 10;
        }
        return matchCount;
    }

}
