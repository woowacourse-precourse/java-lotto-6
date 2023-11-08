package lotto.domain;

import static lotto.exception.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.exception.ExceptionMessage.INVAILD_LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto { //Lotto = numbers
    protected List<LottoNumber> numbers;

    public Lotto() {
        this(createLotto());
    }

//    public Lotto(List<LottoNumber> numbers) {
//        validateNonDuplicatedNumbers(numbers);
//        validateLottoSize(numbers);
//        this.numbers = numbers;
//    }

    public Lotto (List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for(Integer number : numbers) {
            LottoNumber lottoNumber = new LottoNumber(number);
            lottoNumbers.add(lottoNumber);
        }
        validateLottoSize(lottoNumbers);
        validateNonDuplicatedNumbers(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    public static List<Integer> createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    private void validateNonDuplicatedNumbers(final List<LottoNumber> numbers) {
        List<LottoNumber> nonDuplicatedNumbers = numbers.stream().distinct().toList();
        if (nonDuplicatedNumbers.size() != numbers.size()) {
            System.out.println(DUPLICATE_LOTTO_NUMBER.getMessage());
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private void validateLottoSize(final List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            System.out.println(INVAILD_LOTTO_SIZE.getMessage());
            throw new IllegalArgumentException(INVAILD_LOTTO_SIZE.getMessage());
        }
    }

    public int countSameNumber(Lotto userLotto) {
        int sameNumberCount = 0;
        for(LottoNumber lottoNumber: numbers) {
            if(userLotto.hasNumber(lottoNumber)) {
                sameNumberCount++;
            }
        }
        return sameNumberCount;
    }

    public boolean hasNumber(LottoNumber userLottoNumber) {
        for(LottoNumber lottoNumber: numbers) {
            if (lottoNumber.equals(userLottoNumber)) {
                return true;
            }
        }
        return false;
    }

    public List<LottoNumber> getLotto() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
