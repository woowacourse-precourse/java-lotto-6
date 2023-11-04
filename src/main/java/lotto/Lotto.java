package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException{
        validate(numbers);
        validateNumbersRange(numbers);
        validateUniqueNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumbersRange(List<Integer> numbers){
        for(int number: numbers){
            if(number<1 || number>45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 6개의 숫자여야 합니다.");
        }
    }

    public int countMatchedNumbers(Lotto lotto){
        int count = 0;
        for(int number: numbers){
            if(lotto.getNumbers().contains(number)){
                count++;
            }
        }
        return count;
    }

    public boolean isBonusMatched(int bonusNumber){
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public void printLotto(){
        System.out.print("[");
        for(int i = 0; i<6;i++){
            if(i == 5) {
                System.out.print(numbers.get(i));
                break;
            }
            System.out.print(numbers.get(i)+", ");
        }
        System.out.println("]");
    }

}
