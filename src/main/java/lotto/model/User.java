package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ErrorMessage;

import java.util.List;
import java.util.stream.Collectors;

public class User {
    //    사용자는 구입 금액과 당첨 번호, 보너스 번호를 각각 입력해야 한다.
    public int inputPurchaseAmount() {
        String input = Console.readLine();
        try {
            int money = Integer.parseInt(input);
            validatePurchaseAmount(money);
            return money;
        } catch (NumberFormatException e) { // 숫자인지 확인 가능
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_CHARACTER.getMessage());
        }
    }

    public List<Integer> inputLottoNumber() {
        try {
            List<Integer> numbers = List.of(Console.readLine().split(",")).stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return numbers;
        } catch (NumberFormatException e) {//사용자가 당첨 번호를 숫자가 아닌 문자로 입력했을 경우
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    public int inputBonusNumber(List<Integer> lottoNumber){
        String input = Console.readLine();
        try {
            int number = Integer.parseInt(input);
            validateBonusNumber(lottoNumber, number);
            return number;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_CHARACTER.getMessage());
        }
    }
    private void validateBonusNumber(List<Integer> lottoNumber, int bonusNumber){
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
        if(lottoNumber.contains(bonusNumber)){
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_DUPLICATION.getMessage());
        }

    }
    private void validatePurchaseAmount(int money) {
        if (money < 1000 || money > 100000) {// 1000원 미만, 100000원 초과의 값 입력시의 예외 처리
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_NUMBER.getMessage());
        }
        if (money % 1000 != 0) {// 1000원 단위의 값 외의 값 입력시의 예외 처리
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_UNIT.getMessage());
        }
    }
}
