package lotto.Controller;

import lotto.Model.Bonus;
import lotto.Model.RandomLottos;
import lotto.Model.Price;
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
        RandomLottos randomLottos = new RandomLottos(price);

        OutputView.newLine();
        OutputView.printCounting(randomLottos);
        OutputView.printNumbers(randomLottos);

        // ------로또 구입 금액 받아서 랜덤로또번호 출력까지
        WinningLotto winningLotto = createWinningLotto();
        Bonus bonus = createBonusNumber(winningLotto);

        Result result = new Result();
        result.calculateWinningResult(randomLottos, winningLotto, bonus);

        // Rate는 총 Rank의 합
        Rate rate = new Rate(result);

        // 당첨 결과 출력
        OutputView.printWinningResult(result);

        // 수익률 결과 출력
        OutputView.printWinningRate(rate.calculateWinningRate(price));

    }

    private Price createPrice() {
        try {
            return new Price(InputView.inputPriceForPurchasingLotto());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            OutputView.newLine();
            return createPrice();
        }
    }

    private WinningLotto createWinningLotto() {
        try {
            return new WinningLotto(InputView.inputWinningLotto());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return createWinningLotto();
        }
    }

    private Bonus createBonusNumber(WinningLotto winningLotto) {
        try {
            return new Bonus(InputView.inputBonusNumber(), winningLotto);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return createBonusNumber(winningLotto);
        }
    }
}
