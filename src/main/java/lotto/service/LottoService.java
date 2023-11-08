package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.LottoFinalConsts;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoRank;
import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class LottoService implements LottoFinalConsts {

    private LottoException lottoException = new LottoException();

    public int getLottoCount(String lottoPurchase) {
        int lottoCount = VARIABLE_FORMAT;
        if (lottoException.isValidLottoPurchase(lottoPurchase)) {
            lottoCount = Integer.parseInt(lottoPurchase)/LOTTO_PURCHASE_DIVIDABLE;
        }
        return lottoCount;
    }

    public List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_RANDOM_RANGE_START, LOTTO_RANDOM_RANGE_END, LOTTO_RANDOM_COUNT);
    }

    public List<Lotto> getLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i=VARIABLE_FORMAT; i<lottoCount; i++) {
            Lotto lotto = new Lotto(getLottoNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    public LottoMachine createLottoMachine(String lottoPurchase, int lottoCount) {
        List<Lotto> lottos = getLottos(lottoCount);
        HashMap<LottoRank, Integer> lottoRanks = new HashMap<>();
        int lottoPurchased = VARIABLE_FORMAT;
        if (lottoException.isValidLottoPurchase(lottoPurchase)) {
            lottoPurchased = Integer.parseInt(lottoPurchase);
        }
        return new LottoMachine(lottoPurchased, lottos, lottoRanks);
    }

    public void saveWinningAndBonusNumbers(LottoMachine lottoMachine, String winningNumber, String bonusNumber){
        validateWinningSplited(winningNumber);
        String[] winning = winningNumber.split(LOTTO_WINNING_SPLIT);
        validateWinningSize(winning);
        for(String number:winning){
            lottoMachine.updateLottoWinningNumbers(Integer.parseInt(number));
        }
        lottoMachine.updateLottoBonusNumber(Integer.parseInt(bonusNumber));
    }

    public void validateWinningSplited(String winningNumbers){
        if (!winningNumbers.contains(",")) {
            throw new IllegalArgumentException(LOTTO_ERROR_MESSAGE+LOTTO_CANNOT_SPLIT_WINNING);
        }
    }

    public void validateWinningSize(String[] winning){
        if (winning.length!=LOTTO_RANDOM_COUNT){
            throw new ArrayIndexOutOfBoundsException(LOTTO_ERROR_MESSAGE+LOTTO_RANGE_OUT_OF_BOUNDS);
        }
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
        int count = VARIABLE_FORMAT;
        for (Integer winningNumber:winningNumbers){
            if (lottoNumbers.contains(winningNumber)){
                count+=ADD_COUNT_ONE;
            }
        }
        if (count==LOTTO_RANK_IS_SECOND_OR_THIRD){
            if (lottoNumbers.contains(bonusNumber)){
                return LOTTO_SECOND;
            }
        }
        String result = Integer.toString(count);

        return result;
    }

    public LottoRank getLottoRank(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        String correct = getCorrectCount(lottoNumbers, winningNumbers, bonusNumber);
        if (Integer.parseInt(correct)<LOTTO_LOSE_LIMIT) {
            return null;
        }

        return LottoRank.findByRank(correct);
    }

    public int getLottoReturn(Iterator<LottoRank> keys, HashMap<LottoRank, Integer> lottoRanks){
        int lottoReturn = VARIABLE_FORMAT;
        while (keys.hasNext()) {
            LottoRank lottoRank = keys.next();
            lottoReturn+=(lottoRank.getLottoReturn())*lottoRanks.get(lottoRank);
        }
        return lottoReturn;
    }

    public void computeLottoReturnRate(LottoMachine lottoMachine){
        HashMap<LottoRank, Integer> lottoRanks = lottoMachine.getLottoRanks();
        Iterator<LottoRank> keys = lottoRanks.keySet().iterator();
        int lottoReturn = getLottoReturn(keys, lottoRanks);
        int lottoPurchase = lottoMachine.getLottoPurchase();
        double returnRate = (double)lottoReturn/lottoPurchase*LOTTO_RETURN_PERCENTAGE_COMPUTE;
        lottoMachine.returnLottoReturnRate(String.format(LOTTO_RETURN_RATE_FORMAT, returnRate)+PERCENTAGE);
    }

}
