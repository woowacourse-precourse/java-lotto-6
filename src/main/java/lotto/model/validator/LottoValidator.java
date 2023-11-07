package lotto.model.validator;

import java.util.List;
import lotto.constant.LottoConstants;
import lotto.model.Lotto;

public class LottoValidator implements ModelValidator {
    // Singleton
    private static LottoValidator lottoValidator;

    private LottoValidator() {
    }

    public static LottoValidator getInstance() {
        if (lottoValidator == null) {
            lottoValidator = new LottoValidator();
            return lottoValidator;
        }
        return lottoValidator;
    }

    @Override
    public void validate(Object o) {
        if (o instanceof Lotto) {
            validate((Lotto) o);
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_PROPER_OBJECT_TYPE.getMessage());
    }

    public void validate(Lotto lotto) {
        validateNull(lotto);
        validateLottoTicketSize(lotto.getNumbers());
        lotto.getNumbers().forEach(this::validateNumberInRange);
        validateDuplication(lotto.getNumbers());
    }

    private void validateNull(Lotto lotto) {
        if (lotto == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_ENTERED.getMessage());
        }
    }

    private void validateNumberInRange(int number) {
        if (number < LottoConstants.LOTTO_NUMBER_MIN || number > LottoConstants.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_NOT_IN_RANGE.getMessage());
        }
    }

    private void validateLottoTicketSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.SIZE_OF_LOTTO) {
            throw new IllegalArgumentException(ErrorMessage.NOT_PROPER_SIZE_OF_LOTTO.getMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.HAS_DUPLICATED_NUMBER.getMessage());
        }
    }
}