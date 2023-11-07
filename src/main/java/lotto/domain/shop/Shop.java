package lotto.domain.shop;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.SaleLotto;
import lotto.domain.lottomachine.LottoMachine;

public class Shop {
    private static final long PRICE_OF_A_LOTTO = 1000L;
    private static final String PRICE_ERROR_MESSAGE = "구입 금액은 " + PRICE_OF_A_LOTTO + "원 단위 입니다.";
    private LottoMachine lottoMachine;

    public Shop(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public List<SaleLotto> sellLotto(long price) {
        validatePrice(price);
        long saleCount = calculateSaleCount(price);
        ArrayList<SaleLotto> saleLottos = new ArrayList<>();
        for (long i = 0; i < saleCount; i++) {
            List<Integer> generatedNumbers = lottoMachine.generate();
            saleLottos.add(new SaleLotto(generatedNumbers));
        }
        return saleLottos;
    }

    private static long calculateSaleCount(long price) {
        long lottoSalesCount = price / PRICE_OF_A_LOTTO;
        return lottoSalesCount;
    }

    private void validatePrice(long price) {
        if (price % PRICE_OF_A_LOTTO != 0) {
            throw new IllegalArgumentException(PRICE_ERROR_MESSAGE);
        }
    }
}
