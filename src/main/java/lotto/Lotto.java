package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import lotto.InputView;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        Set<Integer> numberSet = new HashSet<>(numbers);
        if(numbers.size() != numberSet.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복되어 생성되었습니다.");
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return this.numbers;
    }
    public static Lotto makingSingleLotto(){
        List<Integer> lottoList = new ArrayList<>(6);
        lottoList = Randoms.pickUniqueNumbersInRange(1,45,6);
        Lotto singleLotto = new Lotto(lottoList);
        return singleLotto;
    }
}
