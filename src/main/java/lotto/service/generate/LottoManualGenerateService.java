package lotto.service.generate;

import lotto.domain.Lotto;
import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoManualGenerateService {
    private static final LottoManualGenerateService instance = new LottoManualGenerateService();

    private LottoManualGenerateService() {}

    public static LottoManualGenerateService getInstance() {
        return instance;
    }

    public Lotto generate(final List<String> list) throws LottoException {
        try {
            Set<Integer> uniqueNumbers = list.stream()
                    .map(Integer::valueOf)
                    .collect(Collectors.toSet());
            return new Lotto(new ArrayList<>(uniqueNumbers));
        } catch (NumberFormatException | LottoException exception) {
            throw new LottoException(LottoException.ErrorMessage.DUPLICATE_LOTTO_NUMBERS.getMessage());
        }
    }
}