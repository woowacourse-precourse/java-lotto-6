package lotto.Model;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        size_check(numbers);

        this.numbers = numbers;
    }

    private void size_check(List<Integer> numbers) {
        try{
            if (numbers.size() != 6) {
                throw new IllegalArgumentException();
            }
        }catch (Exception e){
            System.out.println("[ERROR] 로또 번호는 6개의 수를 입력해주세요.");
            System.out.println("다시 입력해주세요.");
            size_check(numbers);
        }

    }

    private void number_check(int number){
        try{
            if (number < 1 || number>45){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 로또 번호 1부터 45까지의 수로 입력해주세요.");
            number_check(number);
        }

    }

}
