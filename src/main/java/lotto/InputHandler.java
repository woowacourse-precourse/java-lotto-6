package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    Validate validate = new Validate();

    // 로또를 구입할 금액을 입력받는다.
    public int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String price = Console.readLine();

        try {
            validate.handleNonThousandUnit(price);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputAmount();
        }
        int amount = Integer.parseInt(price) / 1000;

        System.out.println("\n"+amount+"개를 구매했습니다.");

        return amount;
    }

    // 당첨 번호를 입력받는다.
    public List<Integer> inputSixNumber() {
        List<Integer> numbers = new ArrayList<>();
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winnerNumbers = Console.readLine();      //당첨 번호를 입력받음

        try {
            validate.handleInvalidNumberCount(winnerNumbers);    //당첨 번호 예외처리
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputSixNumber();
        }

        for (String s : winnerNumbers.split(",")) {
            numbers.add(Integer.parseInt(s));           //int 타입으로 변환 후 리스트에 추가
        }

        try {
            validate.handleDuplicateNumbers(numbers);            //당첨 번호 중복 검사 예외처리
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputSixNumber();
        }

        return numbers;
    }

    // 보너스 번호를 입력 받는 기능
    public int inputBonusNumber(List<Integer> numbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        try {
            validate.handleInvalidNumberInput(bonusNumber);          //보너스 번호 예외처리
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(numbers);
        }
        try {
            validate.handleDuplicateNumbers(numbers, bonusNumber);            //당첨 번호 중복 검사 예외처리
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(numbers);
        }

        return Integer.parseInt(bonusNumber);
    }

}
