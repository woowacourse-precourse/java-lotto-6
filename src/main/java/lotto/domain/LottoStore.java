package lotto.domain;

import static lotto.constant.DomainConstant.LOTTO_PRICE;
import static lotto.constant.DomainConstant.LOTTO_SIZE;
import static lotto.constant.DomainConstant.START_INDEX;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.constant.ErrorMessage;

public final class LottoStore {
    private final NumberGenerator numberGenerator;

    private LottoStore(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public static LottoStore from(NumberGenerator numberGenerator) {
        return new LottoStore(numberGenerator);
    }

    public List<Lotto> purchaseLottos(long investmentAmount) {
        validateInvestmentAmount(investmentAmount);
        int numberOfLottos = calculateNumberOfLottos(investmentAmount);
        return createLottos(numberOfLottos);
    }

    private List<Lotto> createLottos(int numberOfLottos) {
        return IntStream.range(START_INDEX.getValue(), numberOfLottos)
            .mapToObj(i -> new Lotto(createLottoNumbers()))
            .collect(Collectors.toList());
    }

    private List<Integer> createLottoNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size() < LOTTO_SIZE.getValue()) {
            uniqueNumbers.add(numberGenerator.generate());
        }
        return new ArrayList<>(uniqueNumbers);
    }

    private int calculateNumberOfLottos(long investmentAmount) {
        return (int) investmentAmount / LOTTO_PRICE.getValue();
    }

    private void validateInvestmentAmount(long investmentAmount) {
        if (isInvalidInvestmentAmount(investmentAmount)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INVESTMENT_AMOUNT.getMessage());
        }
    }

    private boolean isInvalidInvestmentAmount(long investmentAmount) {
        return investmentAmount < LOTTO_PRICE.getValue() || investmentAmount % LOTTO_PRICE.getValue() != START_INDEX.getValue();
    }
}
