package lotto.domain.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.global.utils.console.ConsoleUtil;
import lotto.global.utils.constant.OutputType;

import java.util.Arrays;
import java.util.List;

import static lotto.global.utils.constant.OutputType.EXCEPTION_INPUT_PRICE;

public class ClientService {
    private static final String SPLITTER = ",";

    public Lotto getLottoNumbers() {
        ConsoleUtil.commonOutputLine(OutputType.OUTPUT_WINNING_NUMBERS.getComment());
        String input = ConsoleUtil.input();
        List<Integer> inputLottoList = Arrays.stream(input.split(SPLITTER))
                .map(Integer::parseInt)
                .toList();
        return new Lotto(inputLottoList);
    }

    public BonusNumber getBonusNumber(Lotto inputLottoList) {
        ConsoleUtil.commonOutputLine(OutputType.OUTPUT_BONUS_NUMBER.getComment());
        String input = ConsoleUtil.input();
        return new BonusNumber(inputLottoList, Integer.parseInt(input));
    }

    public int getLottoCount() {
        while (true) {
            String input = ConsoleUtil.input();
            try {
                int priceOfLotto = Integer.parseInt(input);
                validatePriceOfLotto(priceOfLotto);
                return priceOfLotto / 1000;
            } catch (IllegalArgumentException e) {
                ConsoleUtil.commonOutputLine(OutputType.EXCEPTION_INPUT_PRICE.getComment());
            }
        }
    }

    private void validatePriceOfLotto(int priceOfLotto) {
        if (priceOfLotto < 0 || priceOfLotto % 1000 != 0) {
            throw new IllegalArgumentException(EXCEPTION_INPUT_PRICE.getComment());
        }
    }
}
