package lotto.Controller;

import lotto.Model.Bonus;
import lotto.Model.Lottos;
import lotto.Model.Price;
import lotto.Model.RandomLotto;
import lotto.Model.Rate;
import lotto.Model.Result;
import lotto.Model.WinningLotto;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoGame {

    public void start() {
        // price는 로또 구매 가격
        Price price = createPrice();

        // randomLotto는 발행된 랜덤 로또 개수
        RandomLotto randomLotto = new RandomLotto(price);
        Lottos lottos = new Lottos(randomLotto.getCount());

        OutputView.printLottoPurChaseMessage(randomLotto);
        OutputView.printRandomLottoNumbers(lottos);

        // ------로또 구입 금액 받아서 랜덤로또번호 출력까지

        WinningLotto winningLotto = createWinningLotto();
        Bonus bonus = createBonusNumber(winningLotto);

        Result result = new Result();
        result.compare(lottos, winningLotto, bonus);

        // Rate는 총 Rank의 합
        Rate rate = new Rate(result);

        //System.out.println(result.getRankAndCounting());

        // 당첨 결과 출력
        OutputView.printWinningResult(result);

        // 수익률 결과 출력
        OutputView.printWinningRate(rate.calculateWinningRate(price));

    }

    private Price createPrice() {
        try {
            return new Price(InputView.inputPriceForLotto());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println();
            return createPrice();
        }
    }

    private WinningLotto createWinningLotto() {
        try {
            return new WinningLotto(InputView.inputWinningLotto());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createWinningLotto();
        }
    }

    private Bonus createBonusNumber(WinningLotto winningLotto) {
        try {
            Bonus bonus = new Bonus(InputView.inputBonusNumber());
            winningLotto.contain(bonus);
            return bonus;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createBonusNumber(winningLotto);
        }
    }
}
