package lotto.application;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.WinningNumber;

import java.util.Arrays;
import java.util.List;

public class IOService {
    private final String BEFORE_PURCHASE_LOTTO_MESSAGE = "구입금액을 입력해 주세요.";
    private final String LOTTO_CNT_MESSAGE = "개를 구매했습니다.";
    private final String PRIZE_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final String ERROR_INTEGER = "[ERROR] 구입 금액은 정수여야 합니다.";
    private final String ERROR_UNIT = "[ERROR] 구입 금액은 1,000원 단위여야합니다.";
    private final String ERROR_PRIZE_NUMBER_CNT = "[ERROR] 6개를 입력해야합니다.";
    private final String ERROR_PRIZE_NUMBER_INTEGER = "[ERROR] 당첨 번호는 정수여야 합니다.";
    private final String ERROR_PRIZE_NUMBER_RANGE = "[ERROR] 당첨 번호는 1이상 45이하입니다.";
    private final String ERROR_PRIZE_NUMBER_DUPLICATE = "[ERROR] 당첨 번호는 중복될 수 없습니다.";
    private final String ERROR_MINIMUM = "[ERROR] 구입 금액이 1000원보다 작을 수는 없습니다.";
    private final String ERROR_BONUS_NUMBER_CNT = "[ERROR] 1개를 입력해야합니다.";
    private final String ERROR_BONUS_NUMBER_INTEGER = "[ERROR] 보너스 번호는 정수여야합니다.";
    private final String ERROR_BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 1이상 45이하입니다.";

    private final String ERROR_BONUS_NUMBER_DUPLICATED = "[ERROR] 보너스 번호는 기존 번호와 중복될 수 없습니다.";

    public void printBeforePurchaseLottoMessage() {
        System.out.println(BEFORE_PURCHASE_LOTTO_MESSAGE);
    }

    public void printLottos(User user) {
        List<Lotto> lottos = user.getLottos();

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printLottoCount(int cnt) {
        System.out.println(cnt + LOTTO_CNT_MESSAGE);
    }

    public void printPrizeNumberMessage() {
        System.out.println(PRIZE_NUMBER_MESSAGE);
    }

    public void printBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public long scanPurchaseAmount() {
        boolean success = true;
        String purchaseAmount;
        do {
            purchaseAmount = Console.readLine();

            success = validatePurchaseAmount(purchaseAmount);
        } while (!success);

        return Long.parseLong(purchaseAmount);
    }

    public WinningNumber scanWinningNumber(){
        List<Integer> prizeNumbers = scanPrizeNumbers();

        prizeNumbers = prizeNumbers.stream().sorted().toList();
        WinningNumber winningNumber = new WinningNumber(prizeNumbers);

        int bonusNumber = scanBonusNumber(prizeNumbers);
        winningNumber.setBonusNumber(bonusNumber);

        return winningNumber;
    }

    private List<Integer> scanPrizeNumbers() {
        boolean success = true;

        String prizeNumbers;
        do {
            prizeNumbers = Console.readLine();

            success = validatePrizeNumber(prizeNumbers);
        } while (!success);

        return Arrays.stream(prizeNumbers.split(",")).map(s -> Integer.parseInt(s)).toList();
    }

    private int scanBonusNumber(List<Integer> prizeNumbers){
        boolean success = true;

        String bonusNumber;
        do {
            bonusNumber = Console.readLine();

            success = validateBonusNumber(prizeNumbers, bonusNumber);
        } while (!success);

        return Integer.parseInt(bonusNumber);
    }

    public boolean validatePurchaseAmount(String purchaseAmount) {
        try {
            validateLong(purchaseAmount);
            validateMinimum(purchaseAmount);
            validateUnit(purchaseAmount);
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

    private void validateLong(String number) {
        try {
            Long.parseLong(number);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_INTEGER);
            throw new IllegalArgumentException();
        }
    }

    private void validateMinimum(String number) {
        if (Long.parseLong(number) < 1000) {
            System.out.println(ERROR_MINIMUM);
            throw new IllegalArgumentException();
        }
    }

    private void validateUnit(String number) {
        if (!number.endsWith("000")) {
            System.out.println(ERROR_UNIT);
            throw new IllegalArgumentException();
        }
    }

    public boolean validatePrizeNumber(String prizeNumbers) {
        try {
            validateCnt(prizeNumbers);
            validateAllInteger(prizeNumbers);
            validateAllRange(prizeNumbers);
            validateAllDuplicate(prizeNumbers);
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

    private void validateCnt(String prizeNumbers) {
        String[] split = prizeNumbers.split(",");

        if (split.length != 6) {
            System.out.println(ERROR_PRIZE_NUMBER_CNT);
            throw new IllegalArgumentException();
        }
    }

    private void validateAllInteger(String prizeNumbers) {
        String[] split = prizeNumbers.split(",");

        try {
            for (String s : split)
                Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_PRIZE_NUMBER_INTEGER);
            throw new IllegalArgumentException();
        }
    }

    private void validateAllRange(String prizeNumbers) {
        String[] split = prizeNumbers.split(",");

        for (String s : split) {
            int number = Integer.parseInt(s);

            if (number < 1 || number > 45) {
                System.out.println(ERROR_PRIZE_NUMBER_RANGE);
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateAllDuplicate(String prizeNumbers) {
        String[] split = prizeNumbers.split(",");

        for (int i = 0; i < split.length; ++i) {
            if (isDuplicated(split, i)) {
                System.out.println(ERROR_PRIZE_NUMBER_DUPLICATE);
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean isDuplicated(String[] arr, int index) {
        String target = arr[index];

        for (int i = 0; i < index; ++i) {
            if (arr[i].equals(target))
                return true;
        }

        return false;
    }

    public boolean validateBonusNumber(List<Integer> prizeNumbers, String bonusNumber){
        try {
            validateBonusNumberCnt(bonusNumber);
            validateBonusNumberInteger(bonusNumber);
            validateBonusNumberRange(bonusNumber);
            validateBonusNumberDuplicated(prizeNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

    private void validateBonusNumberCnt(String bonusNumber) {
        String[] split = bonusNumber.split(",");

        if (split.length != 1) {
            System.out.println(ERROR_BONUS_NUMBER_CNT);
            throw new IllegalArgumentException();
        }
    }
    private void validateBonusNumberInteger(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_BONUS_NUMBER_INTEGER);
            throw new IllegalArgumentException();
        }
    }

    private void validateBonusNumberRange(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);

        if (number < 1 || number > 45) {
            System.out.println(ERROR_BONUS_NUMBER_RANGE);
            throw new IllegalArgumentException();
        }
    }

    private void validateBonusNumberDuplicated(List<Integer> prizeNumbers, String bonusNumber) {
        int target = Integer.parseInt(bonusNumber);

        for (Integer prizeNumber : prizeNumbers) {
            if(prizeNumber == target){
                System.out.println(ERROR_BONUS_NUMBER_DUPLICATED);
                throw new IllegalArgumentException();
            }
        }
    }
}
