package lotto.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import lotto.util.ErrorMessageSender;
import lotto.util.IntParser;
import lotto.util.NumberSplitter;
import lotto.validator.Validator;

public class LottoSettingService {
    public int selectPurchaseAmount(Validator<String> validator, Supplier<String> inputSupplier,
                                    Runnable requestMessage, Consumer<String> errorMessage) {
        String validInput = getValidInput(validator, inputSupplier, requestMessage, errorMessage);
        return IntParser.parseInt(validInput);
    }

    public List<Integer> selectWinningNumbers(Validator<String> validator, Supplier<String> inputSupplier,
                                              Runnable requestMessage, Consumer<String> errorMessage) {
        String validInput = getValidInput(validator, inputSupplier, requestMessage, errorMessage);
        return NumberSplitter.splitNumbers(validInput);
    }

    public int selectBonusNumber(Validator<String> validator, Supplier<String> input,
                                 Runnable requestMessage, Consumer<String> errorMessage) {
        String validInput = getValidInput(validator, input, requestMessage, errorMessage);
        return IntParser.parseInt(validInput);
    }

    private String getValidInput(Validator<String> validator, Supplier<String> inputSupplier,
                                 Runnable requestMessage, Consumer<String> errorMessage) {
        Optional<String> userInput;
        do {
            requestMessage.run(); // 입력 요청 메시지 출력
            userInput = validateInput(validator, inputSupplier,
                    errorMessage);

        } while (userInput.isEmpty());
        return userInput.get();
    }
    private Optional<String> validateInput(Validator<String> validator, Supplier<String> inputSupplier,
                                          Consumer<String> errorConsumer) {
        String input = inputSupplier.get();
        Optional<String> errorMessage =
                ErrorMessageSender.validateAndGetErrorMessage(validator, input);

        if(errorMessage.isPresent()) {
            errorConsumer.accept(errorMessage.get());
            return Optional.empty();
        }
        return Optional.of(input);
    }
}
