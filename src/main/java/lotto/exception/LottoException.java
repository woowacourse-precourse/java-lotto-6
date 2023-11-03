package lotto.exception;

import java.util.List;

public class LottoException extends IllegalArgumentException{

    public LottoException(String message){
        super(message);
    }

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
