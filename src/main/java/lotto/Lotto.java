package lotto;

import lotto.view.ExceptionMessage;

import java.util.*;

public class Lotto {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validOverlap(numbers);
        validNumberRange(numbers);

        Collections.sort(numbers);
        this.numbers = numbers;
    }




    public static Lotto createLotto(List<Integer> numbers) {
        try {
            validate(numbers);
            validOverlap(numbers);
            validNumberRange(numbers);

            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            return createLotto(getUserInput()); // 잘못된 입력을 다시 받음
        }
    }

    private static List<Integer> getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter 6 distinct numbers between 1 and 45:");
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            int number = scanner.nextInt();
            numbers.add(number);
        }

        return numbers;
    }










    public List<Integer> printLottoNumbers(){
        return numbers;
    }



    public int matchingLottoCount(Lotto winningLotto){
        return (int) numbers.stream().
                filter(winningLotto::containNumber).count();
    }

    public boolean containNumber(int number){
        return numbers.contains(number);
    }


    private static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ExceptionMessage.errorMessage();
            ExceptionMessage.InputSizeError();
            throw new IllegalArgumentException();
        }
    }

    private static void validOverlap(List<Integer> numbers){
        Set<Integer> overlapCheck = new HashSet<>(numbers);

        if(overlapCheck.size() != 6){
            ExceptionMessage.errorMessage();
            ExceptionMessage.overlapNumberError();
            throw new IllegalArgumentException();
        }
    }


    private static void validNumberRange(List<Integer> numbers){
        for (Integer number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                ExceptionMessage.errorMessage();
                ExceptionMessage.invalidNumberRange();
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validBonusNumber(List<Integer> numbers, int bonusNumber){
        if(numbers.contains(bonusNumber)){
            ExceptionMessage.errorMessage();
            ExceptionMessage.overlapNumberError();
            throw new IllegalArgumentException();
        }
    }

}
