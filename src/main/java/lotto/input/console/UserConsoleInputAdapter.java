package lotto.input.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.LottoException;
import lotto.domain.Lotto;
import lotto.domain.LottoAnswer;
import lotto.domain.exception.*;
import lotto.input.UserInputPort;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class UserConsoleInputAdapter implements UserInputPort {
    @Override
    public int getLottoBuyPrice() {
        return doLoop(() -> {
            String input = getInputWithMessage("구입금액을 입력해 주세요.");

            validateLottoBuyPrice(input);
            return toInt(input);
        });
    }

    @Override
    public LottoAnswer getLottoAnswer() {
        List<Integer> lottoNumber = getLottoNumber();
        int bonusNumber = getBonusNumber(lottoNumber);

        return new LottoAnswer(lottoNumber, bonusNumber);
    }

    private <T> T doLoop(Supplier<T> inputFunction) {
        while (true) {
            try {
                return inputFunction.get();
            } catch (LottoException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getInputWithMessage(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    private List<Integer> getLottoNumber() {
        return doLoop(() -> {
            String input = getInputWithMessage("당첨 번호를 입력해 주세요.");;
            List<String> numbers = Arrays.asList(input.split(","));

            validateLottoNumbers(numbers);
            return toIntList(numbers);
        });
    }

    private int getBonusNumber(List<Integer> lottoNumber) {
        return doLoop(() -> {
            String input = getInputWithMessage("보너스 번호를 입력해 주세요.");
            validateBonusNumber(input, lottoNumber);
            return toInt(input);
        });
    }

    private void validateBonusNumber(String input, List<Integer> lottoNumber) {
        validateBonusNumberIsInteger(input);
        validateLottoNumber(toInt(input));
        validateDuplicateBonusNumber(toInt(input), lottoNumber);
    }

    private void validateDuplicateBonusNumber(int bonusNumber, List<Integer> lottoNumber) {
        if (lottoNumber.contains(bonusNumber)) {
            throw new DuplicatedLottoNumberException();
        }
    }

    private void validateLottoBuyPrice(String lottoBuyPrice) {
        validateLottoPriceIsInteger(lottoBuyPrice);
        validateNoRecharge(toInt(lottoBuyPrice));
    }

    private void validateLottoPriceIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalLottoPriceException();
        }
    }

    private void validateBonusNumberIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalLottoNumberException();
        }
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    private List<Integer> toIntList(List<String> numbers) {
        return numbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private void validateNoRecharge(int lottoBuyPrice) {
        if (lottoBuyPrice % Lotto.LOTTO_PRICE != 0) {
            throw new LottoRechargeExistException();
        }
    }

    private void validateLottoNumbers(List<String> numbers) {
        if (numbers.size() != Lotto.LOTTO_NUMBER_SIZE) {
            throw new IllegalLottoSizeException();
        }

        for (String number : numbers) {
            validateLottoPriceIsInteger(number);
            validateLottoNumber(toInt(number));
        }
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < Lotto.LOTTO_NUMBER_MIN || lottoNumber > Lotto.LOTTO_NUMBER_MAX) {
            throw new IllegalLottoNumberException();
        }
    }
}
