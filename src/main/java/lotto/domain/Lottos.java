package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import lotto.exception.CustomException;
import lotto.exception.constant.ErrorCode;
import lotto.utils.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;
    private int lottoCnt;
    public Lottos(String purchase) {
        validateCnt(purchase);
        this.lottoCnt = convertLottoCnt(purchase);
        this.lottos = drawLottos();
    }

    private List<Lotto> drawLottos() {
        lottos = new ArrayList<>();
        List<Lotto> drawResult = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            drawResult.add(new Lotto(Randoms.pickUniqueNumbersInRange(
                    Constant.START_INCLUSIVE,
                    Constant.END_ENCLUSIVE,
                    Constant.LOTTO_NUMBER)));
        }
        return drawResult;
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

    public int getLottoCnt() {
        return lottoCnt;
    }

    public void anounceLottos() {
        for (Lotto lotto : lottos) {
            System.out.println(Arrays.toString(lotto.convertArray()));
        }
    }
}
