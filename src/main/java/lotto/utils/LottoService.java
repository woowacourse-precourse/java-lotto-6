package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.global.constant.LottoConstant;
import lotto.view.InputValidator;

import java.util.List;

public class LottoService {

    public LottoService(){
    }

    public Lotto generateUserLotto(){
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                LottoConstant.LOTTO_NUMBER_RANGE_START, LottoConstant.LOTTO_NUMBER_RANGE_END,
                LottoConstant.LOTTO_NUMBER_COUNT);
        return new Lotto(randomNumbers);
    }

    public LottoResult makeLottoAsPurchaseAndAccumulate(LottoResult lottoResult){
        int count = countPurchasedLotto(lottoResult.getLottoPurchasePrice());
        for(int i = 0; i < count; i++){
            lottoResult.accumulateLotto(generateUserLotto());
        }
        return lottoResult;
    }

    public WinningLotto generateWinningLotto(){
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                LottoConstant.LOTTO_NUMBER_RANGE_START, LottoConstant.LOTTO_NUMBER_RANGE_END,
                LottoConstant.LOTTO_NUMBER_COUNT);
        int bonusNumber = Randoms.pickNumberInRange(LottoConstant.LOTTO_NUMBER_RANGE_START,
                LottoConstant.LOTTO_NUMBER_RANGE_END);
        return new WinningLotto(randomNumbers, bonusNumber);
    }

    public int countPurchasedLotto(int lottoPurchasePrice){
        InputValidator.purchasePriceCheck(lottoPurchasePrice);
        return lottoPurchasePrice / LottoConstant.LOTTO_PRICE;
    }

}
