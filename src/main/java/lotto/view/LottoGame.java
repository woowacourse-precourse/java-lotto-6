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
        int lottoPrice = lottoController.lottoSetPrice();
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
        int bonus = lottoController.bonusNumber();

        SelectedLottoNumber selectedLottoNumber = new SelectedLottoNumber(numbers, bonus);

        return selectedLottoNumber;
    }

    public void showResult(Price price, Lottos lottos, SelectedLottoNumber selectedLottoNumber) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        int[] corrections = lottoController.correct(price, lottos, selectedLottoNumber);
        showComment(corrections);

    }

    public void showComment(int[] corrections) {
        System.out.print(ResultComment.THREE.comment);
        System.out.println(String.format("%d개", corrections[4]));

        System.out.print(ResultComment.FOUR.comment);
        System.out.println(String.format("%d개", corrections[3]));

        System.out.print(ResultComment.FIVE.comment);
        System.out.println(String.format("%d개", corrections[2]));

        System.out.print(ResultComment.FIVE_BONUS.comment);
        System.out.println(String.format("%d개", corrections[1]));

        System.out.print(ResultComment.SIX.comment);
        System.out.println(String.format("%d개", corrections[0]));
    }

    public float rate(Price price, int[] corrections) {
        int revenue = 0;
        for (int i = 0; i < 5; i++) {
            revenue += RevenuePrice.getPriceByIndex(i) * corrections[i];
        }
        float revenueRate = (float)revenue/price.getPrice();

        return revenueRate;
    }
}
