package domain;

import static java.util.Collections.sort;
import static util.ErrorMessage.CANT_DUPLICATE_NUMBER;
import static util.ErrorMessage.LOTTO_COUNT_LIMIT;
import static util.ErrorMessage.LOTTO_NUMBER_RANGE;
import static view.InputView.inputWinningLottoNumber;

import java.util.List;
import java.util.regex.Pattern;

public class Lotto {
    public static final Pattern lotto = Pattern.compile("[1-9]|[1-3][0-9]|4[0-5]");
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if(!validateSize(numbers)){
            inputWinningLottoNumber();
        }
        if(!validateDuplicate(numbers)){
            inputWinningLottoNumber();
        }
        if(!validateRange(numbers)){
            inputWinningLottoNumber();
        }
    }

    private boolean validateSize(List<Integer> numbers){
        try {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException e){
            System.out.println(LOTTO_COUNT_LIMIT.getErrorMessage());
            return false;
        }
        return true;
    }

    private boolean validateDuplicate(List<Integer> numbers){
        try {
            if (numbers.size() != numbers.stream().distinct().count()) {
                throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException e){
            System.out.println(CANT_DUPLICATE_NUMBER.getErrorMessage());
            return false;
        }
        return true;
    }

    private boolean validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            try {
                if (!lotto.matcher(Integer.toString(number)).matches()) {
                    throw new IllegalArgumentException();
                }
            }catch(IllegalArgumentException e){
                System.out.println(LOTTO_NUMBER_RANGE.getErrorMessage());
                return false;
            }
        }
        return true;
    }


    public static void outputLotto(Lotto lotto) {
        sort(lotto.numbers);
        System.out.println(lotto.numbers.toString());
    }

}
