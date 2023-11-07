package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.LottoMatchNumberDTO;
import lotto.exception.*;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.dto.LottoInfoDTO;
import lotto.model.Lottos;
import lotto.validator.InputPriceValidator;
import lotto.view.LottoView;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    private static final int MATCH_COUNT_3 = 3;
    private static final int MATCH_COUNT_4 = 4;
    private static final int MATCH_COUNT_5 = 5;
    private static final int MATCH_COUNT_6 = 6;

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int START_INDEX = 0;
    private static final int DIVIDE_BY = 1000;

    public LottoService() {
    }

    public static Lottos generate(String price) {
        try {
            InputPriceValidator.validatePrice(price);
        } catch (InvalidPriceTypeException | InvalidInputException | EmptyException | InvalidPriceRangeException | InvalidInputPriceException e) {
            return generate(LottoView.requestInputPrice());
        }
        Integer priceInt = Integer.parseInt(price);
        return new Lottos(getLottos(priceInt));
    }

    private static List<LottoInfoDTO> getLottos(Integer priceInt) {
        return IntStream.range(START_INDEX, priceInt / DIVIDE_BY)
                .mapToObj(i -> generateLotto())
                .collect(Collectors.toList());
    }

    private static LottoInfoDTO generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_SIZE);
        return new LottoInfoDTO(new Lotto(sortingNumbers(numbers)));
    }

    private static List<Integer> sortingNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
