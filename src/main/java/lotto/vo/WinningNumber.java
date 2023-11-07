package lotto.vo;

import java.util.List;

import static lotto.values.LottoInformation.TOTAL_LOTTO_NUMBER;

public class WinningNumber {
    private final List<Integer> numbers;
    public WinningNumber(List<Integer> numbers){
        this.numbers = numbers;
    }

    public int compareLotto(Lotto lotto) {
        int count = 0;
        List<Integer> lottoNumbers = lotto.getNumbers();
        for(int i=0; i<TOTAL_LOTTO_NUMBER.getValue(); i++){
            if(numbers.contains(lottoNumbers.get(i))) count++;
        }

        return count;
    }
}
