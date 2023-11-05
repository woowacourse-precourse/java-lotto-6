package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Converter;
import lotto.constant.ExceptionMessage;
import lotto.constant.Number;
import lotto.domain.Lotto;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

public class LottoController {

    int ticketCount;
    List<Integer> winningNumbers;
    int bonusNumber;
    List<Lotto> lottos = new ArrayList<>();

    public void start() throws IllegalArgumentException {
        // 구입금액 받기
        OutputHandler.requirePaymentPrice();
        String paymentPrice = InputHandler.getInput();
        OutputHandler.printEmptyLine();

        // 구입 개수 계산하기
        ticketCount = getTicketCount(paymentPrice);
        OutputHandler.sayTicketCount(ticketCount);

        // 구입 개수만큼 로또 발행하기
        for (int i = 0; i < ticketCount; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
            OutputHandler.printLottoNumbers(lotto.getNumbers());
        }

        // 당첨 번호 받기
        OutputHandler.requireWinningNumbers();
        String winningNumbersInput = InputHandler.getInput();
        if (winningNumbersInput.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_NONEMPTY_INPUT);
        }
        List<Integer> winningNumbers = Converter.winningNumbers(winningNumbersInput);
        if (winningNumbers.size() != Number.LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_SIX_NUMBERS);
        }
        this.winningNumbers = winningNumbers;

        // 보너스 번호 받기
        OutputHandler.requireBonusNumber();
        String bonusNumberInput = InputHandler.getInput();
        if (bonusNumberInput.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_NONEMPTY_INPUT);
        }
        int bonusNumber = Converter.bonusNumbers(bonusNumberInput);
        this.bonusNumber = bonusNumber;
    }

    int getTicketCount(String inputPay) throws IllegalArgumentException {
        int paymentPrice = Converter.pay(inputPay);
        if (paymentPrice < 0) {
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_POSITIVE_INTEGER);
        }
        if (paymentPrice % Number.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_MULTIPLE_OF_LOTTO_PRICE);
        }
        return paymentPrice / Number.LOTTO_PRICE;
    }
}
