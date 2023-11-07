package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {

        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 번호 6개를 입력해주세요.");
        }
    }

    public void inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        int inputPurchaseAmount = Integer.parseInt(Console.readLine());
    }

    public void validateInputPurchaseAmount(int inputPurchaseAmount) {
        if (inputPurchaseAmount % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }

    public int calculateRound(int inputPurchaseAmount) {
        return inputPurchaseAmount / 1000;
    }
}
