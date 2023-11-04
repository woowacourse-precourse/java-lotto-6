package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int getPurchasingVolume(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int volume = Integer.parseInt(input);
        //        입력값 검증 함수
        return volume/1000;
    }

    public List<Integer> inputNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        Integer[] inputNums = Stream.of(input.split(",")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(inputNums));
//       입력값 검증 함수
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
