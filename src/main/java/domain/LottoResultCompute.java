package domain;

import util.MessageUtil;
import util.ValidationUtil;

import java.util.Arrays;
import java.util.List;

public class LottoResultCompute {
    private final ValidationUtil validationUtil = new ValidationUtil();
    private final MessageUtil messageUtil = new MessageUtil();
    private final LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();
    public void getLottoResultComputeInfo(List<Lotto> userLottos, int lottoAmount){
        messageUtil.printWinningStatistic();

        for(Lotto userLotto : userLottos){
            List<Integer> userLottoNumbers = userLotto.getLottoNumbers();

        }
    }
    private int getMatchNumbers(List<Integer> userLottoNumbers){

    }
}
