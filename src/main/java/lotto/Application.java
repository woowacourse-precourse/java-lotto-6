package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Application {

    public static final int PURCHASE_AMOUNT_UNIT = 1000;
    public static final int NUM_OF_LOTTO = 6;
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        playLotto();
    }

    public static void playLotto() {
        int purChaseAmount = inputPurchaseAmount();
        System.out.println(purChaseAmount);

        List<Integer> lottoNumbers = inputLottoNumbers();
        for (Integer lottoNumber : lottoNumbers) {
            System.out.print(lottoNumber + " ");
        }
        int bonusNumber = inputBonusNumber(lottoNumbers);
        System.out.println(bonusNumber);
    }

    public static int inputPurchaseAmount() {
        String inputPurchaseAmount = Console.readLine();

        while (!validateInputPurchaseAmount(inputPurchaseAmount)) {
            inputPurchaseAmount = Console.readLine();
        }

        return Integer.parseInt(inputPurchaseAmount);
    }

    public static boolean validateInputPurchaseAmount(final String inputPurchaseAmount) {
        if (!validateInputPurchaseAmountIsNumber(inputPurchaseAmount)
                || !validateDivideToThousand(inputPurchaseAmount)) {
            throwIllegalArgumentException();
            return false;
        }

        return true;
    }

    public static boolean validateInputPurchaseAmountIsNumber(final String inputPurchaseAmount) {
        return isNumber(inputPurchaseAmount);
    }

    public static boolean validateDivideToThousand(final String inputPurchaseAmount) {
        int purchaseAmount = Integer.parseInt(inputPurchaseAmount);

        if (purchaseAmount % PURCHASE_AMOUNT_UNIT != 0) {
            return false;
        }

        return true;
    }

    public static List<Integer> inputLottoNumbers() {
        List<String> lottoNumbers = List.of(Console.readLine().split(","));

        while (!validateInputLottoNumbers(lottoNumbers)) {
            lottoNumbers = List.of(Console.readLine().split(","));
        }

        return stringListToIntegerList(lottoNumbers);
    }

    public static boolean validateInputLottoNumbers(final List<String> inputLottoNumbers) {
        if (!validateNumOfLotto(inputLottoNumbers)
                || !validateEachLottoIsNumber(inputLottoNumbers)
                || !validateEachLottoIsInBound(inputLottoNumbers)
                || !validateDuplicateLottoNumbers(inputLottoNumbers)) {
            throwIllegalArgumentException();
            return false;
        }

        return true;
    }

    public static boolean validateNumOfLotto(final List<String> inputLottoNumbers) {
        if (inputLottoNumbers.size() != NUM_OF_LOTTO) {
            return false;
        }

        return true;
    }

    public static boolean validateEachLottoIsNumber(final List<String> inputLottoNumbers) {
        for (String inputLottoNumber : inputLottoNumbers) {
            if (!isNumber(inputLottoNumber)) {
                return false;
            }
        }

        return true;
    }

    public static boolean validateEachLottoIsInBound(final List<String> inputLottoNumbers) {
        for (String inputLottoNumber : inputLottoNumbers) {
            int lottoNumber = Integer.parseInt(inputLottoNumber);
            if (lottoNumber < MINIMUM_LOTTO_NUMBER || lottoNumber > MAXIMUM_LOTTO_NUMBER) {
                return false;
            }
        }

        return true;
    }

    public static boolean validateDuplicateLottoNumbers(final List<String> inputLottoNumbers) {
        int inputLottoNumbersSize = inputLottoNumbers.size();
        int distinctInputLottoNumbersSize = inputLottoNumbers
                .stream()
                .distinct()
                .toList().size();

        return inputLottoNumbersSize == distinctInputLottoNumbersSize;
    }

    public static List<Integer> stringListToIntegerList(final List<String> lottoNumbers) {
        return lottoNumbers
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static boolean isNumber(final String inputPurchaseAmount) {
        ParsePosition pos = new ParsePosition(0);
        NumberFormat.getInstance().parse(inputPurchaseAmount, pos);
        return inputPurchaseAmount.length() == pos.getIndex();
    }

    public static int inputBonusNumber(final List<Integer> lottoNumbers) {
        String inputBonusNumber = Console.readLine();

        while (!validateBonusNumber(lottoNumbers, inputBonusNumber)) {
            inputBonusNumber = Console.readLine();
        }

        return Integer.parseInt(inputBonusNumber);
    }

    public static boolean validateBonusNumber(final List<Integer> lottoNumbers, final String inputBonusNumber) {
        if (!validateInputBonusNumberIsNumber(inputBonusNumber)
                || !validateInputBonusNumberIsInBound(inputBonusNumber)
                || !validateInputBonusNumberDuplicateWithLottoNumbers(lottoNumbers, inputBonusNumber)) {
            throwIllegalArgumentException();
            return false;
        }

        return true;
    }

    public static boolean validateInputBonusNumberIsNumber(final String inputBonusNumber) {
        return isNumber(inputBonusNumber);
    }

    public static boolean validateInputBonusNumberIsInBound(final String inputBonusNumber) {
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        if (bonusNumber < MINIMUM_LOTTO_NUMBER || bonusNumber > MAXIMUM_LOTTO_NUMBER) {
            return false;
        }

        return true;
    }

    public static boolean validateInputBonusNumberDuplicateWithLottoNumbers(
            final List<Integer> lottoNumbers,
            final String inputBonusNumber
    ) {
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        for (Integer lottoNumber : lottoNumbers) {
            if (lottoNumber == bonusNumber) {
                return false;
            }
        }

        return true;
    }

    public static void throwIllegalArgumentException() {
        try {
            throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException exception) {
            System.out.println("[ERROR] 잘못된 입력 값을 입력하셨습니다. 다시 입력해 주세요!");
        }
    }
}
