package lotto.validate;

import static lotto.view.LottoConsoleIn.inputBonusNumber;
import static lotto.view.LottoConsoleIn.inputNumberOfWinningNumbers;
import static lotto.view.LottoConsoleIn.inputPurchaseAmount;

import java.util.Arrays;
import java.util.List;


public class InputValidator {
    private List<Integer> list;

    private static final String ERROR_PREFIX = "[ERROR] ";

    public Long validatePurchaseAmount(String number){
        try{
            Long longNumber = validateCorrectLongFormat(number);
            validateNonNegativeLong(longNumber);
            validateDivideByThousand(longNumber);
            return longNumber;
        }catch (Exception e){
            System.out.println(ERROR_PREFIX+e.getMessage());
            return inputPurchaseAmount();
        }
    }


    public Integer validateBonusNumber(String number){
        try{
            Integer integer = validateCorrectIntegerFormat(number);
            validateNonNegativeInteger(integer);
            validateUniqueBonus(integer);
            return integer;
        }catch (Exception e){
            System.out.println(ERROR_PREFIX + e.getMessage());
            return inputBonusNumber();
        }
    }


    public String validateWinningInput(String lottos){
        try {
            lottos = lottos.replaceAll(" ", "");
            totalValidateForWinningInput(lottos);
            return lottos;
        }
        catch (Exception e){
            System.out.println(ERROR_PREFIX+e.getMessage());
            return inputNumberOfWinningNumbers();
        }
    }
    private void totalValidateForWinningInput(String lottos) {
        String[] split = validateNumberOfLotto(lottos);
        validateListNumberFormat(split);
        validateListRange(split);
        splitToList(split);
        validateUniqueList();
    }

    private void splitToList(String[] split) {
        this.list= Arrays.stream(split)
                .map(Integer::parseInt)
                .toList();
    }

    private void validateListNumberFormat(String[] split) {
        try{
            Arrays.stream(split)
                    .map(Integer::parseInt)
                    .toList();
        }catch (Exception e){
            throw new IllegalArgumentException("'숫자' 그리고 ',' 만을 입력해주세요");
        }
    }
    private static String[] validateNumberOfLotto(String lottos) {
        String[] split = lottos.split(",");
        if (split.length != 6){
            throw new IllegalArgumentException("잘못된 입력입니다. ',' 로 구분하여 정확히 6개 숫자를 입력해주세요.");
        }
        return split;
    }
    private void validateDivideByThousand(Long longNumber){
        if (longNumber % 1000 != 0L){
            throw new IllegalArgumentException("1,000 단위의 구매 가격을 입력해주세요.");
        }
    }

    private Long validateCorrectLongFormat(String number) {
        try {
            return Long.parseLong(number);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 숫자를 입력해주세요(범위 1,000~1,000,000,000)");
        }
    }



    private Integer validateCorrectIntegerFormat(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 숫자를 입력해주세요");
        }
    }
    private void validateUniqueList() {
        int distinctCount = (int) list.stream()
                .distinct()
                .count();
        if (distinctCount != list.size()) {
            throw new IllegalStateException("로또 번호가 중복되었습니다. 중복되지 않은 숫자들로 다시 입력해주세요.");
        }

    }

    private void validateNonNegativeInteger(Integer number) {
        if (number < 0) {
            throw new IllegalArgumentException("0 이상의 숫자를 입력해주세요.");
        }
    }


    private void validateNonNegativeLong(Long number) {
        if (number < 0) {
            throw new IllegalArgumentException("0 이상의 숫자를 입력해주세요.");
        }
    }
    private void validateListRange(String[] split) {
        Arrays.stream(split)
                .map(Integer::parseInt)
                .forEach(this::validateCorrectLottoNumber);
    }
    private void validateCorrectLottoNumber(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1에서 45까지만 허용합니다.");
        }
    }

    private void validateUniqueBonus(int bonus) {
        if (list.contains(bonus)) {
            throw new IllegalArgumentException("보너스 번호는 로또 번호와 겹칠 수 없습니다 다시 입력해세요.");
        }
    }


}


