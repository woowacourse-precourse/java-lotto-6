package lotto.domain;

import lotto.io.OutputHandler;
import lotto.system.Constant;
import lotto.util.Util;
import lotto.verifier.LottoVerifier;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        String forCheck = Util.makeIntegerListToStringFormat(numbers);
        new LottoVerifier().check(forCheck);
    }

    public boolean contains(int number){
        return numbers.contains(number);
    }

    public void printLottoInfo(){
        OutputHandler.printLotto(numbers);
    }

    public int compareWithAnotherLotto(Lotto another){
        int count=0;
        for(int i = 0; i< Constant.LOTTO_SIZE; i++){
            if(another.contains(numbers.get(i)))
                count++;
        }
        return count;
    }

}
