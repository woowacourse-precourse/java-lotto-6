package lotto.service;

import static lotto.enums.ViewMessageType.INPUT_SEPARATOR;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import lotto.enums.ViewMessageType;
import lotto.utils.LottoNumbersValidator;
import lotto.utils.PaymentValidator;
import lotto.utils.RandomNumberGenerator;

public class LottoServiceImpl implements LottoService {
    private static LottoService instance = new LottoServiceImpl();
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private LottoServiceImpl() {}

    public static LottoService getInstance() {
        return instance;
    }

    @Override
    public Lottos buyLottos(String paymentInput) throws NumberFormatException {
        PaymentValidator.validateInteger(paymentInput);
        int payment = Integer.parseInt(paymentInput);

        Lottos lottos = new Lottos(payment);

        int buyCount = payment / LOTTO_PRICE;
        for (int cnt=0; cnt < buyCount; cnt++) {
            lottos.addLotto(issueAutoLotto());
        }
        return lottos;
    }

    public Lotto issueAutoLotto() {
        return new Lotto(
                RandomNumberGenerator.makeUniQueRandomNumbers(
                        MIN_LOTTO_NUMBER,
                        MAX_LOTTO_NUMBER,
                        LOTTO_SIZE
                )
        );
    }

    @Override
    public Lotto drawWinningNumbers(String numbersInput) {
        LottoNumbersValidator.validateSeparator(numbersInput);
        return new Lotto(
                Arrays.stream(numbersInput.split(INPUT_SEPARATOR.getMessage()))
                        .map(Integer::parseInt)
                        .toList()
        );
    }
}
