package lotto.view;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Price;

public class LottoGame {

    final int lottoLength = 6;
    private final LottoController lottoController = new LottoController();


    public Price bougthPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int lottoPrice = lottoController.LottoSetPrice();
        Price price = new Price(lottoPrice);

        return price;
    }

    public Lottos showLotto(Price price) {
        int boughtCount = price.getPrice()/1000;
        System.out.println(String.format("%d개를 구매했습니다.", boughtCount));
        Lottos lottos = new Lottos(lottoController.makeLottos(boughtCount));
        for (int i = 0; i < boughtCount; i++) {
            Lotto lotto = lottos.getLottos().get(i);
            System.out.println(lotto.getNumbers());
        }

        return lottos;
    }
}
