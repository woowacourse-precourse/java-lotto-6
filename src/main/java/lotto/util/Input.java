package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.dto.request.AnswerNumberRequestDto;

public class Input {

    private static final int MINIMUM_PRICE = 0;
    private static final String NUMBER_DIVISION = ",";


    public int buyMoney() {
        try {
            int money = stringToInt(Console.readLine());
            checkPriceByThousandWonUnitAndMinimum(money);
            return money;
        } catch (IllegalArgumentException errorMessage) {
            Log.println(errorMessage.getMessage());
        }
        return buyMoney();
    }

    public AnswerNumberRequestDto answerNumber() {
        try {
            String lottoNumbers = Console.readLine();
            return makeRequestDto(lottoNumbers);
        } catch (IllegalArgumentException errorMessage) {
            Log.println(errorMessage.getMessage());
        }
        return answerNumber();
    }

    public void bonusNumber(AnswerNumberRequestDto answerNumberRequestDto) {
        try {
            int bonusNumber = stringToInt(Console.readLine());
            answerNumberRequestDto.addBonusNumber(bonusNumber);
            return;
        } catch (IllegalArgumentException errorMessage) {
            Log.println(errorMessage.getMessage());
        }
        bonusNumber(answerNumberRequestDto);
    }

    private AnswerNumberRequestDto makeRequestDto(String lottoNumbers) {
        try {
            return AnswerNumberRequestDto.createDto(
                    Arrays.stream(lottoNumbers.split(NUMBER_DIVISION))
                            .map(Integer::parseInt)
                            .toList());
        } catch (IllegalArgumentException errorMessage) {
            if (errorMessage.getMessage().contains("[ERROR]")) {
                throw new IllegalArgumentException(errorMessage.getMessage());
            }
            throw new NumberFormatException("[ERROR] 숫자로 입력해야 합니다.");
        }
    }

    private void checkPriceByThousandWonUnitAndMinimum(int money) {
        if (money % Lotto.PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 가격은 천원 단위입니다.");
        }
        if (MINIMUM_PRICE >= money) {
            throw new IllegalArgumentException("[ERROR] 1장 이상 구매해야 합니다.");
        }
    }

    private int stringToInt(String readLine) {
        try {
            return Integer.parseInt(readLine);
        } catch (NumberFormatException errorMessage) {
            throw new NumberFormatException("[ERROR] 숫자로 입력해야 합니다.");
        }
    }
}
