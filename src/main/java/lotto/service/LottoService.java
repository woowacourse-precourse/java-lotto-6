package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.LottoFinalConsts;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoRank;
import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoService implements LottoFinalConsts {

    private LottoException lottoException = new LottoException();

    public int getLottoCount(String lottoPurchase) {
        int lottoCount = 0;
        if (lottoException.isValidLottoPurchase(lottoPurchase)) {
            lottoCount = Integer.parseInt(lottoPurchase)/1000;
        }
        return lottoCount;
    }

    public List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> getLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i<lottoCount; i++) {
            Lotto lotto = new Lotto(getLottoNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    public LottoMachine createLottoMachine(int lottoCount) {
        List<Lotto> lottos = getLottos(lottoCount);
        HashMap<LottoRank, Integer> lottoRanks = new HashMap<>();
        return new LottoMachine(lottoCount, lottos, lottoRanks);
    }

    public void saveWinningAndBonusNumbers(LottoMachine lottoMachine, String winningNumber, String bonusNumber){
        String[] winning = winningNumber.split(",");
        for(String number:winning){
            lottoMachine.updateLottoWinningNumbers(Integer.parseInt(number));
        }
        lottoMachine.updateLottoBonusNumber(Integer.parseInt(bonusNumber));
    }

    public void saveRankCount(LottoMachine lottoMachine){
        List<Integer> winningNumbers = lottoMachine.getLottoWinningNumbers();
        int bonusNumber = lottoMachine.getLottoBonusNumber();
        List<Lotto> lottos = lottoMachine.getLottos();
        for (Lotto lotto:lottos){
            List<Integer> lottoNumbers = lotto.getNumbers();
            LottoRank lottoRank = getLottoRank(lottoNumbers, winningNumbers, bonusNumber);
            if (lottoRank!=null){
                lottoMachine.updateLottoRanks(lottoRank);
            }
        }
    }

    public String getCorrectCount(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber){
        int count = 0;
        for (Integer winningNumber:winningNumbers){
            if (lottoNumbers.contains(winningNumber)){
                count+=1;
            }
        }
        if (count==5){
            if (lottoNumbers.contains(bonusNumber)){
                return LOTTO_SECOND;
            }
        }
        String result = Integer.toString(count);

        return result;
    }

    public LottoRank getLottoRank(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        String correct = getCorrectCount(lottoNumbers, winningNumbers, bonusNumber);
        if (Integer.parseInt(correct)<3) {
            return null;
        }

        return LottoRank.findByRank(correct);
    }

}
