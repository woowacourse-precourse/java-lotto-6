package lotto.domain;

import lotto.exception.CustomException;
import lotto.exception.constant.ErrorCode;
import lotto.utils.Constant;

import java.util.List;

public class Lottos {
    private List<Lotto> lottos;
    private int lottoCnt;
    public Lottos(String purchase) {
        validateCnt(purchase);
        this.lottoCnt = convertLottoCnt(purchase);
        System.out.println(lottoCnt);
    }

    private int convertLottoCnt(String purchase) {
        return (Integer.parseInt(purchase) / 1000);
    }

    private void validateCnt(String purchase) {
        if (!purchase.matches(Constant.numberRegex)) {
            throw new CustomException(ErrorCode.INVALID_NUMBER_REGEX);
        }
        if ((Integer.parseInt(purchase) % 1000) != 0) {
            throw new CustomException(ErrorCode.INVALID_LOTTO_PURCHASE);
        }
    }
}
