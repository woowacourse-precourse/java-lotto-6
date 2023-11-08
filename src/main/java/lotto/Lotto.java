package lotto;

import lotto.Domain.PrizeBonusNumber;
import lotto.Function.Validate;
import lotto.Util.ErrorMessage;

import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.Set;
import java.util.HashSet;

public class Lotto {
    public static final int LOTTO_SIZE=6;
    public static final int MIN_LOTTO_RANGE=1;
    public static final int MAX_LOTTO_RANGE=45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validate.validateLotto(numbers);
        numbers = sorted(numbers);
        this.numbers = numbers;
    }
    //오름차순 정렬
    private List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }
    //생성된 로또 번호 내 번호 찾기
    public boolean isContain(int number) {
        return numbers.contains(number);
    }
    //생성된 로또 번호 내 번호 찾기와 카운팅 하기
    public int getMatchLottoNumber(PrizeBonusNumber prizeBonusNumber) {
        return (int) numbers.stream()
                .filter(prizeBonusNumber::isContain)
                .count();
    }
    //배열 주소에 있는 값을 보여줌
    @Override
    public String toString() {
        return numbers.toString();
    }
}

