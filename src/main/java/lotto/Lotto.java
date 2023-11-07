package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);

        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public int countMatch(Lotto winningLotto) {
        return (int) numbers.stream().
                filter(winningLotto::containNumber).
                count();
    }

    public boolean containNumber(int number) {

        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {

            System.out.println("[ERROR] 로또 당첨 번호 6개를 입력 해야합니다.");
            Controller controller = new Controller();
            controller.validateBonus();
            throw new IllegalArgumentException();
        }
        Set<Integer> numSet = new HashSet<>(numbers);
        if(numSet.size()!= numbers.size()){
            System.out.println("[ERROR] 중복된 숫자가 포함되어 있습니다.");
            Controller controller = new Controller();
            controller.validateBonus();
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int winningNumber = 0; winningNumber < numbers.size(); winningNumber++) {
            if (numbers.get(winningNumber) < 1 || numbers.get(winningNumber) > 45) {
                System.out.println("[ERROR] 숫자는 1 ~ 45 사이의 숫자여야 합니다.");
                Controller controller = new Controller();
                controller.validateBonus();
                throw new IllegalArgumentException();
            }

        }
    }

    public void validateBonusNumber(List<Integer> numbers, int bonusNumber) {

        if (numbers.contains(bonusNumber)) {

            System.out.println("[ERROR] 중복된 숫자를 입력했습니다.");
            Controller controller = new Controller();
            controller.validateBonus();
            throw new IllegalArgumentException();
        }

    }
}
