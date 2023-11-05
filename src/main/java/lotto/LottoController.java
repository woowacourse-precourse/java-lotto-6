package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoController {

    public static final OutputView OUTPUT_VIEW = new OutputView();
    public static final int LOTTO_PRICE = 1000;
    public static final int MIN_NUMBER_LOTTO = 1;
    public static final int MAX_NUMBER_LOTTO = 45;
    public static final int COUNT_OF_LOTTO = 6;

    public void run() {
        int price = buyLotto();
        int lottoCount = getLottoCount(price);

        List<Lotto> lottos = userLotto(lottoCount);

    }

    private int buyLotto() {
        OUTPUT_VIEW.printPriceMessage();
        String inputPrice = Console.readLine();
        return validationPrice(inputPrice);
    }

    private int validationPrice(String inputPrice) {
        int price = 0;

        try {
            Error.CHECK.isAllInteger(inputPrice);
            price = Integer.parseInt(inputPrice);
            Error.CHECK.isUnder1000Price(price);
        } catch (IllegalArgumentException e) {
            buyLotto();
        }
        return price;
    }

    public int getLottoCount(int price) {
        return price / LOTTO_PRICE;
    }

    public List<Lotto> userLotto(int lottoCount) {
        OUTPUT_VIEW.printBuyLottoMessage(lottoCount);
        List<Lotto> lottos = publishLotto(lottoCount);
        OUTPUT_VIEW.printLottoMessage(lottos);

        return lottos;
    }

    public List<Lotto> publishLotto(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottoCount > 0) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(MIN_NUMBER_LOTTO, MAX_NUMBER_LOTTO, COUNT_OF_LOTTO);
            Collections.sort(lotto);
            lottos.add(new Lotto(lotto));
            lottoCount--;
        }
        return lottos;
    }

}
