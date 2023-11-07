package lotto.Logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }


    public List<Integer> getNumbers(){
        return this.numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException{
        if (numbers.size() != 6)
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개의 정수로 입력해야 한다");

        numberValid(numbers);
    }

    private void numberValid(List<Integer> numbers) throws IllegalArgumentException{
        List<Integer> checkValid=new ArrayList<>();

        for (int i=0;i<numbers.size();i++){

            if (numbers.get(i)<=0 || numbers.get(i)>45)
                throw new IllegalArgumentException("[ERROR] 각 당첨 번호는 1~45 사이로 표현해야 한다");

            if (checkValid.contains(numbers.get(i)))
                throw new IllegalArgumentException("[ERROR] 각 당첨 번호는 중복되면 안된다");

            checkValid.add(numbers.get(i));
        }
    }

    @Override
    public String toString() {
        List<Integer> sortNumbers=new ArrayList<>();
        sortNumbers.addAll(this.numbers);
        Collections.sort(sortNumbers);

        StringBuilder output = new StringBuilder("[");
        for (int i = 0; i < sortNumbers.size(); i++) {
            output.append(sortNumbers.get(i));

            if (i != sortNumbers.size() - 1)
                output.append(", ");
        }
        output.append("]");

        return output.toString();
    }

}
