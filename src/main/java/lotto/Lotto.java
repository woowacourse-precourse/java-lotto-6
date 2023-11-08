package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumber(numbers);

        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public static void validateLottoNumber(List<Integer> numbers){
        validate(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }
    public List<Integer> getLottoNumbers(){
        return numbers;
    }
    public int countMatch(Lotto matchLotto){
        return (int) numbers.stream().filter(matchLotto::containNumber).count();
    }

    public boolean containNumber(int number) {

        return numbers.contains(number);
    }

    private static void validate(List<Integer> numbers) throws IllegalArgumentException{
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개만 가능합니다.");
        }
    }
    private static void validateDuplicate(List<Integer> numbers){
        Set<Integer> nonDupliecateNumber = new HashSet<>(numbers);
        if(nonDupliecateNumber.size() != 6){
            throw new IllegalArgumentException("[ERROR]로또 번호는 중복될 수 없습니다.");
        }
    }

    private static void validateRange(List<Integer> numbers){
        for(int matchNumber =0;matchNumber < numbers.size();matchNumber++){
            if(numbers.get(matchNumber) > MAX_NUMBER || numbers.get(matchNumber) < MIN_NUMBER){
                throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1~45 사이 입니다.");
            }
        }
    }

    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber){
        if(numbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 넘버는 로또 번호와 중복될 수 없습니다.");
        }
    }

}
