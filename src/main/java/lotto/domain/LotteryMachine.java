package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ErrorMessageFormatter;
import lotto.util.ListUtil;

import java.util.*;

import static lotto.message.ErrorMessageFormatter.*;
import static lotto.util.ListUtil.*;
import static lotto.validator.LotteryMachineValidator.*;

public class LotteryMachine {

    private LotteryMachine() { }

    public static LotteryMachine of() {
        return new LotteryMachine();
    }

    public LuckyTicket makeLuckyTicket() {
        List<Integer> numbers = makeLuckyNumbers();
        int bonusNumber = makeBonusNumber(numbers);
        return LuckyTicket.of(new Lotto(numbers), bonusNumber);
    }

    private List<Integer> makeLuckyNumbers() {
        boolean luckyNumberInputFail = true;
        Optional<String> input = Optional.empty();
        do {
            try {
                input = Optional.of(inputLuckyNumber());
                luckyNumberInputFail = false;
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage("당첨번호는 ','으로 구분된 6개의 숫자를 입력해야한다."));
            }
        } while (luckyNumberInputFail);

        String numberInput = input.orElseThrow(() -> new RuntimeException("당첨번호를 입력받을 수 없습니다."));
        String[] split = numberInput.split(",");
        return StringArrayToList(split);
    }

    private String inputLuckyNumber() {
        System.out.println("당첨 번호를 입력해주세요");
        String input = Console.readLine();
        validateLuckyNumber(input);

        return input;
    }

    private int makeBonusNumber(List<Integer> luckyNumbers) {
        boolean bonusNumberInputFail = true;
        Optional<Integer> bonusNumber = Optional.empty();
        do {
            try {
                String input = inputBonusNumber(luckyNumbers);
                bonusNumber = Optional.of(Integer.parseInt(input));
                bonusNumberInputFail = false;
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage("보너스 번호는 1~45 사이의 정수가 입력되어야 합니다."));
            }
        } while (bonusNumberInputFail);

        return bonusNumber.orElseThrow(() -> new RuntimeException("보너스 번호를 입력받을 수 없습니다."));
    }
    private String inputBonusNumber(List<Integer> luckyNumbers) {
        System.out.println("보너스 번호를 입력해주세요.");
        String input = Console.readLine();
        validateBonusNumber(luckyNumbers, input);

        return input;
    }

}
