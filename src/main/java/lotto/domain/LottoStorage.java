package lotto.domain;


import java.util.List;
import lotto.common.Constant;
import lotto.common.ErrorMessage;
import lotto.domain.dto.LottoNumberCompareResult;

public class LottoStorage {

    private final WinningLotto winningLotto;


    public LottoStorage(final WinningLotto winningLotto) {


        this.winningLotto = winningLotto;

    }

    public LottoNumberCompareResult compareToWinningLottoNumber(List<Integer> automaticLottoNumber) {
        int matchingCount = 0;
        boolean bonusIncluded = false;

        matchingCount = (int) automaticLottoNumber.stream().filter(winningLotto::isWinningNumber).count();

        if(automaticLottoNumber.stream().anyMatch(number -> number.equals(winningLotto.getBonusNumber()))) {
            matchingCount++;
            bonusIncluded = true;
        }

        return LottoNumberCompareResult.of(matchingCount, bonusIncluded);
    }


}
