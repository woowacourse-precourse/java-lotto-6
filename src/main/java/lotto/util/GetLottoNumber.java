package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetLottoNumber {
    public static List<Integer> userTicketNumbers() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> modifiableList = new ArrayList<>(lottoNumber);
        Collections.sort(modifiableList);

        return modifiableList;
    }

    public static Lotto winningTicketNumbers() {
        while (true) {
            try {
                String input = InputView.inputWinNumber();
                removeSpaces(input);

                String [] numbers = input.split(",");
                List<Integer> winningNumbers = new ArrayList<>();

                for (String num : numbers) {
                    Validator.isNumericInput(num);
                    Validator.isNumberInRange(num);
                    int number = Integer.parseInt(num);
                    winningNumbers.add(number);
                }

//                Stream<String> nums = Arrays.stream(input.split(","));
//
//                List<Integer> winningNumbers = nums
//                        .filter(number -> Validator.isNumericInput(number) && Validator.isNumberInRange(number))
//                        .map(Integer::parseInt)
//                        .collect(Collectors.toList());

                Lotto winningLotto = new Lotto(winningNumbers);

                return winningLotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int bonusNumber() {
        int bonusNumber = 0;
        try {
            String input = InputView.inputBonusNumber();
            removeSpaces(input);

            Validator.isNumericInput(input);
            Validator.isNumberInRange(input);
            bonusNumber = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return bonusNumber;
    }

    public static void removeSpaces(String input) {
        input.replaceAll(" ", "");
    }
}
