package domain;

import util.MessageUtil;
import util.ValidationUtil;

import java.util.Arrays;
import java.util.List;

public class LottoResultCompute {
    private final ValidationUtil validationUtil = new ValidationUtil();
    private final MessageUtil messageUtil = new MessageUtil();
    private final LottoWinningNumber lottoWinningNumberInfo;
    private final LottoBonusNumber lottoBonusNumberInfo;
    public LottoResultCompute(LottoWinningNumber lottoWinningNumber, LottoBonusNumber lottoBonusNumber){
        this.lottoWinningNumberInfo = lottoWinningNumber;
        this.lottoBonusNumberInfo = lottoBonusNumber;
    }
    public void getLottoResultComputeInfo(List<Lotto> userLottos, int lottoAmount){
        messageUtil.printWinningStatistic();

        for(Lotto userLotto : userLottos){
            List<Integer> userLottoNumbers = userLotto.getLottoNumbers();
            int matchCount = getMatchNumbers(userLottoNumbers);
            System.out.println(matchCount);
        }
    }
    private int getMatchNumbers(List<Integer> userLottoNumbers){
        long count = userLottoNumbers.stream()
                .filter(lottoWinningNumberInfo.getLottoWinningNum()::contains)
                .count();
        return (int)count;

    }
}
