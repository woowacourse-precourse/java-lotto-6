package lotto;

import java.util.List;

public class Lotto {
    static int MIN_NUMBER = 1;
    static int MAX_NUMBER = 45;
    static int NUMBER_SIZE = 6;
    enum LottoError {
        BOUND_LENGTH("[ERROR] 로또 번호는 6개가 필요합니다."),
        NON_PROPER_NUMS("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
        NON_DUPLICATED_NUMS("[ERROR] 로또 번호는 중복되면 안됩니다.");
        String errorMessage;
        LottoError(String errorMessage){
            this.errorMessage = errorMessage;
        }
        public String getErrorMessage(){
            return errorMessage;
        }
    }
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateAuthorizedLength(numbers);
        validateDuplicatedNums(numbers);
        validateProperNumbers(numbers);
    }

    public void validateAuthorizedLength(List<Integer> numbers){
        if(numbers.size()!=6) {
            throw new IllegalArgumentException(
                    LottoError.BOUND_LENGTH.getErrorMessage());
        }
    }

    public void validateProperNumbers(List<Integer> numbers){
        for(int i=0 ;i<numbers.size();i++){
            int lottoNum = numbers.get(i);
            if(lottoNum>MIN_NUMBER&&lottoNum<MAX_NUMBER){
                throw new IllegalArgumentException(
                        LottoError.NON_PROPER_NUMS.getErrorMessage()
                );
            }
        }
    }

    public void validateDuplicatedNums(List<Integer> numbers){
        int distinctNumbersCount = (int)numbers.stream().distinct().count();
        if(distinctNumbersCount != NUMBER_SIZE){
            throw new IllegalArgumentException(
                    LottoError.NON_DUPLICATED_NUMS.getErrorMessage()
            );
        }
    }
}
