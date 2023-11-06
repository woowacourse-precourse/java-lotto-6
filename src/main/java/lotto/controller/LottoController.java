package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.LottoDto;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.Money;
import lotto.util.Message;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Money money = requestMoney();
        List<Lotto> randomLotto = makeRandomLotto(money);
        printGeneratedLotto(randomLotto);
        Lotto winningLotto = requestWinningLotto();
        /*
        구입금액_입력받기(); --> inputView에서 받고, dto로 전달
        로또번호추출();
        당첨번호_입력받기();
        보너스번호_입력받기();
        결과계산하기(); --> 서비스 계층
        출력하기(outputView);
         */
    }

    Money requestMoney() {
        outputView.printMessage(Message.REQUEST_MONEY);
        while (true) {
            try {
                return new Money(inputView.requestInteger());
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    List<Lotto> makeRandomLotto(Money money) {
        List<Lotto> randomLotto = new ArrayList<>();
        Integer size = money.numberOfPurchaseAvailable();
        for (int i = 0; i < size; i++) {
            Lotto newLotto = LottoGenerator.generateRandomLotto();
            randomLotto.add(newLotto);
        }
        return randomLotto;
    }

    void printGeneratedLotto(List<Lotto> lotto) {
        outputView.printMessage(Message.RESULT_MONEY, lotto.size());
        for (Lotto obj : lotto) {
            outputView.printObject(LottoDto.from(obj));
        }
    }

    Lotto requestWinningLotto() {
        outputView.printMessage(Message.REQUEST_WINNING_NUMBERS);
        while (true) {
            try {
                return LottoGenerator.generateAnswerLotto(inputView.requestIntegers());
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
