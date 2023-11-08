package lotto;

import java.util.List;

public class  Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateLottoNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 콤마(,)로 구별해 6자리를 입력해야 합니다.");
        }
    }

    private void validateLottoNumber(List<Integer> numbers){
        for(int i=0;i<6;i++){
            if(numbers.get(i)>45 || numbers.get(i)<1){
                throw  new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

}
