package lotto.common.validate;

import java.util.List;
import lotto.common.constants.ErrorMessage;
import lotto.common.constants.LottoRule;
import lotto.common.constants.Symbol;

public class Validate {
    private static final int ZERO = 0;

    // 프로그램 내에서 직접 사용하는 메서드
    public static void consoleBlank(String input) {
        inBlank(input);
    }

    public static void buyPriceValidate(String price) {
        notNumber(price);
        underThousand(price);
        notThousandUnit(price);
    }

    public static void inputSixHitLottoNumberValidate(List<String> lottoNumbers) {
        notNumbers(lottoNumbers);
    }

    public static void sixHitLottoNumberValidate(List<Integer> lottoNumbers) {
        overInput(lottoNumbers);
        outOfNumberRange(lottoNumbers);
        overlapInput(lottoNumbers);
    }

    public static void inputBonusHitLottoNumberValidate(String bonusNumber) {
        notNumber(bonusNumber);
    }

    public static void bonusHitLottoNumberValidate(int bonusNumber) {
        outOfNumber(bonusNumber);
    }

    public static void compareLottoAndBonusNumberValidate(List<Integer> lottoNumbers, int bonusNumber) {
        beforeOverlapInput(lottoNumbers, bonusNumber);
    }

    // 기능별 예외처리 메서드
    private static void inBlank(String inputString) {
        if (inputString.isBlank()) {
            System.out.println(ErrorMessage.ERROR_BLANK.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private static void notNumbers(List<String> input) {
        for (String inputNumber : input) {
            notNumber(inputNumber);
        }
    }

    private static void notNumber(String inputString) {
        if (!inputString.matches(Symbol.ONLY_NUMBER.getSymbol())) {
            System.out.println(ErrorMessage.ERROR_NOT_NUMBER.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private static void underThousand(String inputString) {
        if (Integer.parseInt(inputString) < LottoRule.ONE_LOTTO_TICKET_PRICE.getRule()) {
            System.out.println(ErrorMessage.ERROR_UNDER_THOUSAND.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private static void notThousandUnit(String inputString) {
        if (Integer.parseInt(inputString) % LottoRule.ONE_LOTTO_TICKET_PRICE.getRule() != ZERO) {
            System.out.println(ErrorMessage.ERROR_NOT_THOUSAND_UNITS.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private static void overInput(List<Integer> input) {
        if (input.size() != LottoRule.PICK_HIT_NUMBER_TOTAL.getRule()) {
            System.out.println(ErrorMessage.ERROR_NOT_SIX_LOTTO_NUMBER.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private static void outOfNumberRange(List<Integer> input) {
        for (Integer inputNumber : input) {
            outOfNumber(inputNumber);
        }
    }

    private static void outOfNumber(int inputNumber) {
        if (inputNumber < LottoRule.PICK_MIN_NUMBER.getRule() || inputNumber > LottoRule.PICK_MAX_NUMBER.getRule()) {
            System.out.println(ErrorMessage.ERROR_NOT_LOTTO_RANGE.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private static void overlapInput(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()){
            System.out.println(ErrorMessage.ERROR_OVERLAP_LOTTO_NUMBER.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private static void beforeOverlapInput(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            System.out.println(ErrorMessage.ERROR_OVERLAP_BONUS_LOTTO_NUMBER.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
