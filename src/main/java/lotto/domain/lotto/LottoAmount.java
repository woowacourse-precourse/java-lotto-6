package lotto.domain.lotto;

import lotto.exception.LottoMoneyDivideException;
import lotto.exception.LottoMoneyLessException;
import lotto.exception.LottoNumNotNumException;

public class LottoMoney {
    private static final int LOTTO_MONEY_DIVIDE = 1000;
    private static int lottoMoney;

    public LottoMoney(String lottoMoneyString) {
        int lottoMoney = validateNumber(lottoMoneyString);
        validate(lottoMoney);
        this.lottoMoney = lottoMoney;
    }

    public int changeToLottoCnt(){
        return lottoMoney / LOTTO_MONEY_DIVIDE;
    }

    private static void validate(int lottoMoney) {
        if (lottoMoney <= 0) {
            throw new IllegalArgumentException();
        }
        if (lottoMoney < LOTTO_MONEY_DIVIDE) {
            throw new LottoMoneyLessException();
        }
        if (lottoMoney % LOTTO_MONEY_DIVIDE != 0) {
            throw new LottoMoneyDivideException();
        }
    }

    private static int validateNumber(String lottoMoneyString) {
        try {
            return Integer.parseInt(lottoMoneyString);
        } catch (NumberFormatException e) {
            throw new LottoNumNotNumException();
        }
    }
}
