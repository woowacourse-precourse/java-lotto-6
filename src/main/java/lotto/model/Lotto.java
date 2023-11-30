package lotto.model;


import java.util.*;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.ExceptionMessage;
import lotto.constant.LottoConstant;


public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        sortAsc(numbers);
        this.numbers = numbers
                .stream().
                map(number -> new LottoNumber(number))
                .collect(Collectors.toList());
    }


    public Lotto() {
        List<Integer> randomLottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LottoConstant.LOTTO_NUMBER_START_RANGE, LottoConstant.LOTTO_NUMBER_END_RANGE, LottoConstant.LOTTO_NUMBER_SIZE));
        sortAsc(randomLottoNumbers);
        this.numbers = randomLottoNumbers
                .stream()
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toList());
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_SIZE_EXCEPTION_MESSAGE);
        }
    }


    private void validateDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_LOTTO_EXCEPTION_MESSAGE);
        }
    }

    private void sortAsc(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }


    @Override
    public boolean equals(Object o) {
        Lotto lotto = (Lotto) o;
        if (numbers.equals(lotto.getNumbers())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String singleLotto = String.join(LottoConstant.LOTTO_NUMBER_PRINT_SEPARATOR, numbers.stream().map(LottoNumber::toString).collect(Collectors.toList()));
        return String.format("[%s]", singleLotto);
    }


    public Boolean contains(LottoNumber lottoNumber) {
        for (LottoNumber number : numbers) {
            if (number.equals(lottoNumber)) {
                return true;
            }
        }
        return false;
    }

    public Boolean contains(Integer lottoNumber) {
        for (LottoNumber number : numbers) {
            if (number.equals(lottoNumber)) {
                return true;
            }
        }
        return false;
    }


}