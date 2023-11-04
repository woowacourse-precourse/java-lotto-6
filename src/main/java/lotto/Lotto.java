package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.InputView;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또번호 6자리 아님.");
        }
    }

    public String toString(){
        String lottoNumber = String.join(", ", String.valueOf(numbers));
        return lottoNumber;
    }

    public int[] toIntegerArr(){
        int[] lottoNumber = new int[6];
        for(int i=0;i<numbers.size();i++){
            lottoNumber[i] = numbers.get(i);
        }
        return lottoNumber;
    }
    public Set<Integer> toSet() {
        Set<Integer> lotto = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            lotto.add(numbers.get(i));
        }
        return lotto;
    }
    public void sortNumber(){
        Collections.sort(this.numbers);
    }
    // TODO: 추가 기능 구현
}
