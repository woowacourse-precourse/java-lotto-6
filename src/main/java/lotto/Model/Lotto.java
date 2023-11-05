package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

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
    }

    public static List<Integer> getLottoRandomNumber(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static List<Integer> sortLottoNumber(List<Integer> numbers){
        Collections.sort(numbers);
        return numbers;
    }

    public static int getWinningNumberCount(List<Integer>winningNumbers, List<Integer>numbers){
        int count = 0;
        for(int w_n: winningNumbers){
            for(int n: numbers){
                if(w_n == n){
                    count++;
                }
            }
        }
        return count;
    }

}
