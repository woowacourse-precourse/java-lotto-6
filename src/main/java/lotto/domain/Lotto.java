package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.util.Instruction.ERROR_DUPLICATE_LOTTO_NUMBER_EXISTENCE;
import static lotto.util.Instruction.ERROR_PROPERTY_LOTTO_TICKET_SIZE;

public class Lotto {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int ONE_LOTTO_LENGTH = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto() {
        this.lottoNumbers = createLotto();
        Collections.sort(lottoNumbers);
    }

    public Lotto(List<LottoNumber> numbers) {
        isValidLottoSize(numbers);
        isValidDuplication(numbers);
        this.lottoNumbers = numbers;
        Collections.sort(lottoNumbers);
    }

    private void isValidLottoSize(List<LottoNumber> numbers) {
        if (numbers.size() != ONE_LOTTO_LENGTH) {
            throw new IllegalArgumentException(ERROR_PROPERTY_LOTTO_TICKET_SIZE.getMessage());
        }
    }

    public void isValidDuplication(List<LottoNumber> numbers) {
        boolean hasDuplicateLottoNumber = numbers.stream()
                .anyMatch(lottoNumber -> Collections.frequency(numbers, lottoNumber) != 1);
        if (hasDuplicateLottoNumber) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_LOTTO_NUMBER_EXISTENCE.getMessage());
        }
    }

    public List<LottoNumber> createLotto() {
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER,LOTTO_MAX_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0,ONE_LOTTO_LENGTH);
    }

    public List<LottoNumber> getLottoTicket() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
