package lotto.domain;

import lotto.exception.LottoMoneyDivideException;
import lotto.exception.LottoMoneyLessException;

public class LottoMoney {
    private static final int LOTTO_MONEY_DIVIDE = 1000;
    private static int lottoMoney;

    private LottoMoney(int lottoMoney) {
        validate(lottoMoney);
        this.lottoMoney = lottoMoney;
    }

    public int getLottoMoney(){
        return lottoMoney;
    }

    public int changeToLottoCnt(){
        return lottoMoney / LOTTO_MONEY_DIVIDE;
    }

    private static void validate(int lottoMoney) {
        if (lottoMoney < LOTTO_MONEY_DIVIDE) {
            throw new LottoMoneyLessException();
        }
        if (lottoMoney % LOTTO_MONEY_DIVIDE != 0) {
            throw new LottoMoneyDivideException();
        }
    }
}
