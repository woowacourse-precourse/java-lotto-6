package lotto.domain;

import lotto.io.OutputHandler;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public boolean contains(int number){
        return numbers.contains(number);
    }

    public void printLottoInfo(){
        OutputHandler.printLotto(numbers);
    }

    public int compareWithAnotherLotto(Lotto another){
        int count=0;
        for(int i=0;i<6;i++){
            if(another.contains(numbers.get(i)))
                count++;
        }
        return count;
    }

}
