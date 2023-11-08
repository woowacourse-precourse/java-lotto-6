package lotto;

import lotto.constants.ErrorMassageConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.constants.LottoNumberConstants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateLotto(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicateLotto(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size() != numbers.size()){
            throw new IllegalArgumentException(ErrorMassageConstants.LOTTO_DUPLICATE_ERROR_MESSAGE.getMessage());
        }
    }

    public List<Integer> oneLottoNumberCopy(){
        return List.copyOf(numbers);
    }

    public static List<Lotto> purchaseLottoEach(int numberOfLotto) {
        return IntStream.range(0, numberOfLotto)
                .mapToObj(i -> new Lotto(createLottoNumber()))
                .collect(Collectors.toList());
    }

    private static List<Integer> createLottoNumber() {
        return pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_RANGE)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
