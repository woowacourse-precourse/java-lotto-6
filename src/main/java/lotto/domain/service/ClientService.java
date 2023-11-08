package lotto.domain.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.global.utils.constant.LottoNumberType;
import lotto.global.utils.constant.OutputType;
import lotto.global.utils.view.InputView;
import lotto.global.utils.view.OutputView;

import java.util.Arrays;
import java.util.List;

import static lotto.global.utils.constant.OutputType.EXCEPTION_INPUT_PRICE;

public class ClientService {
    private static final String SPLITTER = ",";

    public Lotto getLottoNumbers() {
        OutputView.commonOutputLine(OutputType.OUTPUT_WINNING_NUMBERS.getComment());
        while (true) {
            String input = InputView.input();
            try {
                List<Integer> inputLottoList = Arrays.stream(input.split(SPLITTER))
                        .map(Integer::parseInt)
                        .toList();
                return new Lotto(inputLottoList);
            } catch (IllegalArgumentException e) {
                OutputView.commonOutputLine(OutputType.EXCEPTION.getComment());
            }
        }
    }

    public BonusNumber getBonusNumber(Lotto inputLottoList) {
        OutputView.commonOutputLine(OutputType.OUTPUT_BONUS_NUMBER.getComment());
        while (true) {
            String input = InputView.input();
            try {
                return new BonusNumber(inputLottoList, Integer.parseInt(input));
            } catch (IllegalArgumentException e) {
                OutputView.commonOutputLine(OutputType.EXCEPTION.getComment());
            }
        }
    }

    public int getLottoCount() {
        while (true) {
            String input = InputView.input();
            try {
                int priceOfLotto = Integer.parseInt(input);
                validatePriceOfLotto(priceOfLotto);
                return priceOfLotto / LottoNumberType.LOTTO_AMOUNT_UNIT.getValue();
            } catch (IllegalArgumentException e) {
                OutputView.commonOutputLine(OutputType.EXCEPTION_INPUT_PRICE.getComment());
            }
        }
    }

    private void validatePriceOfLotto(int priceOfLotto) {
        if (priceOfLotto < 0 || priceOfLotto % LottoNumberType.LOTTO_AMOUNT_UNIT.getValue() != 0) {
            throw new IllegalArgumentException(EXCEPTION_INPUT_PRICE.getComment());
        }
    }
}
