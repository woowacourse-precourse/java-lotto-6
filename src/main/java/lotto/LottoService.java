package lotto;

import lotto.util.InputHandler;

import java.util.List;

public class LottoService {
    private final static int lottoPrice = 1000;
    private final static String totalPriceMessage = "구입금액을 입력해 주세요.";
    public List<Lotto> createLotto() {
        int totalPrice = Integer.parseInt(InputHandler.printMessageAndReceiveInput(totalPriceMessage));
        int lottoCount = calculateLottoCount(totalPrice);
        return LottoFactory.createLotto(lottoCount);
    }

    private int calculateLottoCount(int totalPrice) {
        return totalPrice / lottoPrice;
    }
}
