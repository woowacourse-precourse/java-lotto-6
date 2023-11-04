package lotto;

import java.util.List;
import java.util.StringJoiner;
import lotto.util.Validator;

public class Lotto {
    private static final int LOTTO_SIZE=6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }

        if (isDuplicated(numbers)){
            throw new IllegalArgumentException();
        }
        Validator validator=Validator.INSTANCE;
        validator.validateOutOfRange(numbers);
    }

    private boolean isDuplicated(List<Integer> numbers){
        int uniqueSize=numbers.stream().distinct().toList().size();

        return uniqueSize!=LOTTO_SIZE;
    }

    public boolean isContains(int number){
        return numbers.contains(number);
    }

    public long getMatchCount(Lotto otherLotto){
        return otherLotto.numbers.stream()
                .filter(this::isContains)
                .count();
    }

    public String getNumbersMessage(){
        List<Integer> sortNumbers=getSortingNumbers();
        StringJoiner numberMessage=new StringJoiner(", ","[","]");
        sortNumbers.stream()
                .map(String::valueOf)
                .forEach(numberMessage::add);

        return numberMessage.toString();
    }

    private List<Integer> getSortingNumbers(){
        return numbers.stream().sorted().toList();
    }
}
