package lotto.dto;

import java.util.Collections;
import java.util.List;

public class LottoDTO {

    private int firstNumber;

    private int secondNumber;

    private int thirdNumber;

    private int forthNumber;

    private int fifthNumber;

    private int sixthNumber;

    public void saveNumbers(List<Integer> numbers){

        //Collections.sort(numbers);

        firstNumber = numbers.get(0);
        secondNumber = numbers.get(1);
        thirdNumber = numbers.get(2);
        forthNumber = numbers.get(3);
        fifthNumber = numbers.get(4);
        sixthNumber = numbers.get(5);
    }

    @Override
    public String toString() {
        return "[" +
                firstNumber + ", " +
                secondNumber + ", " +
                thirdNumber + ", " +
                forthNumber + ", " +
                fifthNumber + ", " +
                sixthNumber +
                "]";
    }
}
