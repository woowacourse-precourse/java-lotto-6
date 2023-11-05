package lotto.domain;

import static lotto.constant.Constant.COMMA;
import static lotto.constant.Constant.MAX_RANGE;
import static lotto.constant.Constant.MIN_RANGE;
import static lotto.constant.Constant.NUMBERS_FORMAT_REGEX;
import static lotto.constant.Constant.ONE_LOTTO_PRICE;
import static lotto.constant.Constant.ZERO_AMOUNT;
import static lotto.constant.Constant.ZERO_COUNT;
import static lotto.domain.LottoMaker.LottoMakerErrorMessage.DUPLICATED_BONUS_NUMBER;
import static lotto.domain.LottoMaker.LottoMakerErrorMessage.NEGATIVE_COUNT;
import static lotto.domain.LottoMaker.LottoMakerErrorMessage.NOT_EXIST_INPUT_ERROR;
import static lotto.domain.LottoMaker.LottoMakerErrorMessage.NOT_SIX_NUMBERS;
import static lotto.domain.LottoMaker.LottoMakerErrorMessage.NOT_THOUSAND_UNIT;
import static lotto.domain.LottoMaker.LottoMakerErrorMessage.OVER_RANGE;
import static lotto.domain.LottoMaker.LottoMakerErrorMessage.UNDER_THOUSAND_AMOUNT;
import static lotto.domain.LottoMaker.LottoMakerErrorMessage.WINNING_NUMBERS_INVALID_FORMAT;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMaker {
    private static final int START_ORDER = 1;
    private final LottoNumberMaker lottoNumberMaker;

    public LottoMaker() {
        this(new LottoNumberMaker());
    }

    public LottoMaker(LottoNumberMaker lottoNumberMaker) {
        this.lottoNumberMaker = lottoNumberMaker;
    }

    public WinningLotto createWinningLottoFromInput(String numbers, int bonusNumber) {
        validateNumbers(numbers);
        validateBonusNumber(numbers, bonusNumber);
        return new WinningLotto(lottoNumberMaker.createByInput(numbers), bonusNumber);
    }

    private void validateNumbers(String numbers) {
        if (numbers.isBlank()) {
            throw new IllegalArgumentException(NOT_EXIST_INPUT_ERROR.getErrorMessage());
        }
        if (isInvalidNumbersFormat(numbers)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_INVALID_FORMAT.getErrorMessage());
        }
        if (hasNotSixNumbers(numbers)) {
            throw new IllegalArgumentException(NOT_SIX_NUMBERS.getErrorMessage());
        }
    }

    private boolean isInvalidNumbersFormat(String numbers) {
        return !numbers.matches(NUMBERS_FORMAT_REGEX);
    }

    private boolean hasNotSixNumbers(String numbers) {
        return numbers.split(COMMA).length != 6;
    }

    private void validateBonusNumber(String numbers, int bonusNumber) {
        if (bonusNumber < MIN_RANGE || bonusNumber > MAX_RANGE) {
            throw new IllegalArgumentException(OVER_RANGE.getErrorMessage());
        }
        if (isBonusNumberDuplicated(numbers, bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER.getErrorMessage());
        }
    }

    private boolean isBonusNumberDuplicated(String numbers, int bonusNumber) {
        return Arrays.stream(numbers.split(COMMA))
                .mapToInt(Integer::parseInt)
                .anyMatch(number -> number == bonusNumber);
    }


    private Lotto createOneLotto() {
        List<Integer> lottoNumbers = lottoNumberMaker.createLottoNumbers();
        return new Lotto(lottoNumbers);
    }

    public List<Lotto> createLottoByPrice(int price) {
        validatePrice(price);
        int lottoCount = price / ONE_LOTTO_PRICE;

        return createLottosByCount(lottoCount);
    }

    private void validatePrice(int price) {
        if (price < ONE_LOTTO_PRICE) {
            throw new IllegalArgumentException(UNDER_THOUSAND_AMOUNT.getErrorMessage());
        }
        if (price % ONE_LOTTO_PRICE != ZERO_AMOUNT) {
            throw new IllegalArgumentException(NOT_THOUSAND_UNIT.getErrorMessage());
        }
    }

    private List<Lotto> createLottosByCount(int lottoCount) {
        validateCount(lottoCount);
        return IntStream.rangeClosed(START_ORDER, lottoCount)
                .mapToObj(order -> createOneLotto())
                .toList();
    }

    private void validateCount(int lottoCount) {
        if (lottoCount < ZERO_COUNT) {
            throw new IllegalArgumentException(NEGATIVE_COUNT.getErrorMessage());
        }
    }

    enum LottoMakerErrorMessage {
        NOT_EXIST_INPUT_ERROR("[ERROR] 입력이 존재하지 않습니다."),
        NOT_THOUSAND_UNIT("[ERROR] 금액은 1000원 단위로 입력해야 합니다."),
        UNDER_THOUSAND_AMOUNT("[ERROR] 최소 1000원의 금액을 입력해야 합니다."),
        WINNING_NUMBERS_INVALID_FORMAT("[ERROR] 입력 형식이 올바르지 않습니다."),
        NOT_SIX_NUMBERS("[ERROR] 입력 숫자는 6개여야 합니다."),
        DUPLICATED_BONUS_NUMBER("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다."),
        OVER_RANGE("[ERROR] 숫자 범위는 1부터 45까지 가능합니다."),
        NEGATIVE_COUNT("[ERROR] 갯수는 음수일 수 없습니다.");

        private final String errorMessage;

        LottoMakerErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }
}
