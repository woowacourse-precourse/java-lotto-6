package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
        validateBetweenOneAndFortyfive(numbers);
    }
    private void validateSize(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void validateDuplicated(List<Integer> numbers){
        for(int i = 0; i < 6; i++){
            if (numbers.indexOf(numbers.get(i)) != numbers.lastIndexOf(numbers.get(i))) throw new IllegalArgumentException();
        }
    }
    private void validateBetweenOneAndFortyfive(List<Integer> number){
        for(int i = 0; i < 6; i++){
            if (number.get(i) > 45 || number.get(i) < 1) throw new IllegalArgumentException();
        }
    }
    public int getSize(){
        return numbers.size();
    }
    public List<Integer> getList(){
        return numbers;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < numbers.size(); i++){
            sb.append(numbers.get(i)).append(", ");
        }
        sb.delete(sb.length()-2,sb.length());
        sb.append("]");
        return sb.toString();
    }
    // TODO: 추가 기능 구현
}
