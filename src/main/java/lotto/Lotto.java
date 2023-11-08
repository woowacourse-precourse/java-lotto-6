package lotto;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    private static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다");
        }
    }

    // TODO: 추가 기능 구현
    public static void validateNumber(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이어야 합니다.");
            }
        }
    }

    public static void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            if (!uniqueNumbers.add(number)) {
                // 이미 존재하는 중복된 숫자를 발견했을 때 예외 발생
                throw new IllegalStateException("[ERROR]로또 번호에 중복된 숫자가 있습니다.");
            }
        }
    }
    public static void ExeptionTest(List<Integer> numbers)
    {
        try {
            validateNumber(numbers);
            validateDuplicateNumbers(numbers);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

//    public void createLotto(int count) {
//        System.out.println(count + "개를 구매했습니다");
//        for (int i = 0; i < count; i++) {
//            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//            List<Integer> bonusNumber;
//            System.out.print(numbers);
//            System.out.print("\n");
//
//            do {
//                bonusNumber = Randoms.pickUniqueNumbersInRange(1, 45, 1);
//            } while (lottoNumbers.contains(bonusNumber)); // 보너스 번호가 lottoNumber에 이미 존재할 경우 다시 선택
//        }
//    }





}


