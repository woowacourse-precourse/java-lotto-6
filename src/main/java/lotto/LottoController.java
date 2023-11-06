package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoController {

    // instance
    private static final int FIRSTGRADE = 0;
    private static final int FIFTHGRADE = 5;
    private static final int ZERO = 0;
    private static final int LOTTOSTARTNUMBER = 1;
    private static final int LOTTOENDNUMBER = 45;
    private static final int LOTTONUMBERSINEACHGAME = 6;
    private static final int PERCENT = 100;
    private static final int UNIT = 1000;
    private final LottoDB lottoDB;
    private final LottoView lottoView;

    private Lotto lotto;

    public LottoController() {
        this.lottoDB = new LottoDB();
        this.lottoView = new LottoView();
        this.lotto = new Lotto();
    }

    // Method
    public void start() {
        setLottoCountFromUser();
        setUserLottoNumbers();
        setLottoWinningNumbers();
        setLottoBonusNumber();
        calculateWinning();
        calculateWinningPrice();
        calculateWinningRate();
        printLottoResult();
    }

    public void setLottoCountFromUser() throws IllegalArgumentException {
        boolean pass = true;
        do {
            try {
                lottoView.userCountInputAnnouncement();
                String userInputString = readLineFromUser();
                int userInputInteger = convertStringToInteger(userInputString);
                checkUserInputIsThousandUnit(userInputInteger);
                lottoDB.setLottoGameCount(userInputInteger / UNIT);
                pass = false;
            } catch (IllegalArgumentException e) {
                lottoView.printError(e.getMessage());
            }
        } while (pass);
    }

    public void setUserLottoNumbers() {
        int numberOfLotto = lottoDB.getLottoGameCount();
        lottoView.printLottoNumberAnnouncement(numberOfLotto);
        for (int i = ZERO; i < numberOfLotto; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(LOTTOSTARTNUMBER, LOTTOENDNUMBER,
                    LOTTONUMBERSINEACHGAME);
            lottoView.printLottoNumber(lotto);
            lottoDB.storeLottoNumbers(lotto);
        }
    }

    public void setLottoWinningNumbers() {
        boolean pass = true;
        do {
            try {
                lottoView.userInputLottoWinningNumberAnnouncement();
                String userInputString = readLineFromUser();
                String[] userInputStringArray = splitStringByComma(userInputString);
                List<Integer> userInputIntegerArray = convertStringListToIntegerList(userInputStringArray);
                setLotto(userInputIntegerArray);
                pass = false;
            } catch (IllegalArgumentException e) {
                lottoView.printError(e.getMessage());
            }
        } while (pass);
    }

    public void setLottoBonusNumber() {
        boolean pass = true;
        do {
            try {
                lottoView.userLottoBonusNumberAnnouncement();
                String bonusNumberString = readLineFromUser();
                int bonusNumber = convertStringToInteger(bonusNumberString);
                checkWinningNumbersInRange(bonusNumber);
                lotto.checkDuplicateForBonusNumber(bonusNumber);
                lottoDB.setLottoBonusNumber(bonusNumber);
                pass = false;
            } catch (IllegalArgumentException e) {
                lottoView.printError(e.getMessage());
            }
        } while (pass);
    }

    public void calculateWinning() {
        int numberOfGame = lottoDB.getLottoGameCount();
        int bonusNumber = lottoDB.getLottoBonusNumber();
        for (int game = ZERO; game < numberOfGame * LOTTONUMBERSINEACHGAME; game += LOTTONUMBERSINEACHGAME) {
            ArrayList<Integer> lottoNumbers = lottoDB.getOneLottoNumbers(game);
            int winning = lotto.checkWinning(lottoNumbers, bonusNumber);
            lottoDB.saveWinningCount(winning);
        }
    }

    public void calculateWinningPrice() {
        long totalPrice = ZERO;
        for (int index = FIRSTGRADE; index < FIFTHGRADE; index++) {
            long price = Prize.getPrizeAmountByNumber(index);
            int winning = lottoDB.getNumberOfWinning(index);
            totalPrice += price * winning;
        }
        lottoDB.setLottoTotalPrice(totalPrice);
    }

    public void calculateWinningRate() {
        long totalPrice = lottoDB.getLottoTotalPrice();
        float InputMoney = lottoDB.getLottoGameCount() * UNIT;
        BigDecimal winningRate = new BigDecimal(totalPrice / InputMoney * PERCENT);
        BigDecimal totalWinningRate = winningRate.setScale(1, RoundingMode.HALF_UP);
        lottoDB.setLottoTotalWinningRate(totalWinningRate);
    }

    public void printLottoResult() {
        lottoView.totalResultAnnouncement();
        lottoView.printEachPrice(lottoDB.getWinningCount());
        lottoView.printWinningRate(lottoDB.getLottoTotalWinningRate());
    }

    public void setLotto(List<Integer> input) {
        this.lotto = new Lotto(input);
    }

    public String readLineFromUser() {
        return Console.readLine();
    }

    public String[] splitStringByComma(String input) {
        return input.split(",");
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
        if (checkNumber < LOTTOSTARTNUMBER || checkNumber > LOTTOENDNUMBER) {
            throw new IllegalArgumentException("[ERROR] : 입력된 값이 1-45사이의 값이 아닙니다.");
        }
    }

    public void checkUserInputIsThousandUnit(int userInput) throws IllegalArgumentException {
        int countMod = userInput % UNIT;
        if (countMod != ZERO) {
            throw new IllegalArgumentException("[ERROR] : 입력된 값이 1,000단위가 아닙니다.");
        }
    }
}
