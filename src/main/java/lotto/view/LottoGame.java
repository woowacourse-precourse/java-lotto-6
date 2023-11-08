package lotto.view;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Price;
import lotto.domain.SelectedLottoNumber;

import java.util.List;

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
        System.out.println(String.format("\n%d개를 구매했습니다.", boughtCount));
        Lottos lottos = new Lottos(lottoController.makeLottos(boughtCount));
        for (int i = 0; i < boughtCount; i++) {
            Lotto lotto = lottos.getLottos().get(i);
            System.out.println(lotto.getNumbers());
        }

        return lottos;
    }

    public SelectedLottoNumber selectLotto() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> numbers = lottoController.selectedNumber();

        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonus = lottoController.BonusNumber();

        SelectedLottoNumber selectedLottoNumber = new SelectedLottoNumber(numbers, bonus);

        return selectedLottoNumber;
    }
}
