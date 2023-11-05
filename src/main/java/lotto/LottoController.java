package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoController {

    // instance
    private static final int UNIT = 1000;
    private final LottoDB lottoDB;
    private final LottoView lottoView;

    private Lotto lotto;

    public LottoController() {
        this.lottoDB = new LottoDB();
        this.lottoView = new LottoView();
    }

    // Method
    public void start() {
        setLottoCountFromUser();
        setUserLottoNumbers();
        setLottoWinningNumbers();
    }

    public void setLottoCountFromUser() throws IllegalArgumentException {
        boolean pass = true;
        do {
            try {
                lottoView.userCountInputAnnouncement();
                String userInputString = Console.readLine();
                int userInputInteger = convertStringToInteger(userInputString);
                checkUserInputIsThousandUnit(userInputInteger);
                lottoDB.saveUserLottoCount(userInputInteger / UNIT);
                pass = false;
            } catch (IllegalArgumentException e) {
                lottoView.printError(e.getMessage());
            }
        } while (pass);
    }

    public void setUserLottoNumbers() {
        int numberOfLotto = lottoDB.getUserLottoCount();
        lottoView.printLottoNumberAnnouncement(numberOfLotto);
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoView.printLottoNumber(lotto);
            lottoDB.storeLottoNumbers(lotto);
        }
    }

    public void setLottoWinningNumbers() {
        boolean pass = true;
        do {
            try {
                lottoView.userInputLottoWinningNumberAnnouncement();
                String userInputString = Console.readLine();
                String[] userInputStringArray = userInputString.split(",");
                List<Integer> userInputIntegerArray = convertStringListToIntegerList(userInputStringArray);
                this.lotto = new Lotto(userInputIntegerArray);
                pass = false;
            } catch (IllegalArgumentException e) {
                lottoView.printError(e.getMessage());
            }
        } while (pass);
    }

    public ArrayList<Integer> convertStringListToIntegerList(String[] input) throws IllegalArgumentException {
        ArrayList<String> ArrayString = new ArrayList<>(Arrays.asList(input));
        ArrayList<Integer> ArrayInteger = new ArrayList<>();
        for (String stringNumbers : ArrayString) {
            int integerNumber = convertStringToInteger(stringNumbers);
            checkWinningNumbersInRange(integerNumber);
            ArrayInteger.add(integerNumber);
        }
        return ArrayInteger;
    }

    public Integer convertStringToInteger(String stringInput) throws IllegalArgumentException {
        try {
            return Integer.parseInt(stringInput);
        } catch (NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException("[ERROR] : 입력된 값이 정수가 아닙니다.");
        }
    }

    public void checkWinningNumbersInRange(int checkNumber) throws IllegalArgumentException {
        if (checkNumber < 1 || checkNumber > 45) {
            throw new IllegalArgumentException("[ERROR] : 입력된 값이 1-45사이의 값이 아닙니다.");
        }
    }

    public void checkUserInputIsThousandUnit(int userInput) throws IllegalArgumentException {
        int countMod = userInput % UNIT;
        if (countMod != 0) {
            throw new IllegalArgumentException("[ERROR] : 입력된 값이 1,000단위가 아닙니다.");
        }
    }
}
