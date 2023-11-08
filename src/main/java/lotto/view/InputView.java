package lotto.view;

import lotto.validation.Validator;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

    public int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputNumber = readLine().trim();
        try {
            Validator.validateOnlyNumber(inputNumber);
            Validator.validateInt(inputNumber);
            Validator.validateThousandMultiple(Integer.parseInt(inputNumber));
            Validator.validateMoreThan1000(Integer.parseInt(inputNumber));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1000이상의 정수형으로 입력해주세요.");
            return inputPrice();
        }
        return Integer.parseInt(inputNumber);
    }

    public List<Integer> inputAnswerNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = readLine().trim();
        try {
            Validator.validateContainComma(numbers);
            Validator.validateOnlyNumber(numbers.replace(",", ""));
            Validator.validateDuplicateNumbers(numbers.split(","));
            Validator.validate1To45Numbers(numbers.split(","));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1,2,3,4,5,6 와 같은 형식으로 입력하세요.");
            return inputAnswerNumbers();
        }
        return mapStringToIntList(numbers);
    }

    private List<Integer> mapStringToIntList(String numbers) {
        return Arrays.stream(numbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public int inputBonusNumber(List<Integer> answerNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = readLine().trim();
        try {
            Validator.validateOnlyNumber(bonusNumber);
            Validator.validate1To45Number(Integer.parseInt(bonusNumber));
            Validator.validateDuplicateBonusNumber(answerNumbers, Integer.parseInt(bonusNumber));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1~45사이의 숫자를 입력하세요.");
            return inputBonusNumber(answerNumbers);
        }
        return Integer.parseInt(bonusNumber);
    }


}
