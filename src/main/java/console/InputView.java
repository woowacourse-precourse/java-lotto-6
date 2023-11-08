package console;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String NOT_NUMBER = "[ERROR] 유효한 숫자를 입력하세요.";
    private static final String INVALID_MONEY = "[ERROR] 입력한 금액은 1000원 단위로 입력해야 합니다.";
    private static final String INVALID_BOUND = "[ERROR] 숫자는 1~45 사이여야 합니다.";
    private static final String BONUS_NUMBER_DUPLICATED = "[ERROR] 입력하신 숫자는 이미 로또에 존재합니다.";
    private static final String DELIMITER = ",";
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int MONEY_UNIT = 1000; // 돈의 단위 숫자

    private InputView() {
        throw new UnsupportedOperationException();
    }

    public static Integer getMoney() {
        try {
            return parseStringToMoney();
        } catch (NumberFormatException e) {
            OutputView.printError(NOT_NUMBER);
            return getMoney();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getMoney();
        }
    }

    public static Lotto getLottoInput(){
        try {
            return convertStringInputToLotto();
        } catch (IllegalArgumentException e){
            OutputView.printError(e.getMessage());
            return getLottoInput();
        }
    }

    public static Integer getBonusNumberByUser(Lotto lotto) {
        try{
            String userInput = Console.readLine();
            Integer.parseInt(userInput);
            int bonusNumber = getBonusNumberByUser(userInput);
            if (lotto.containsBonusNumber(bonusNumber)){
                throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED);
            }
            return bonusNumber;
        } catch (IllegalArgumentException e){
            OutputView.printError(e.getMessage());
            return getBonusNumberByUser(lotto);
        }
    }

    public static Lotto convertStringInputToLotto() {
        String userInput = Console.readLine();
        String[] split = userInput.split(DELIMITER);
        List<Integer> lottoNumberList = Arrays.stream(split)
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        return new Lotto(lottoNumberList);
    }

    private static int getBonusNumberByUser(String userInput) {
        int bonusNumber = Integer.parseInt(userInput);
        if (bonusNumber > MAX_NUMBER || bonusNumber < MIN_NUMBER) {
            throw new IllegalArgumentException(INVALID_BOUND);
        }
        return bonusNumber;
    }

    private static int parseStringToMoney() {
        int money = Integer.parseInt(Console.readLine());
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_MONEY);
        }
        return money;
    }
}
