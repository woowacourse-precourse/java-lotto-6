package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final String ERROR_MESSAGE = "[ERROR]";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또는 번호가 6개 있습니다.");
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        string.append("[");

        for(int i=0;i<6;i++){
            if(i == 5){
                string.append(numbers.get(i));
                continue;
            }

            string.append(numbers.get(i)+", ");
        }

        string.append("]");

        return string.toString();
    }
}
