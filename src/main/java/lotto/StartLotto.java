package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class StartLotto {
    private final List<Lotto> lottoList;
    private int purchasePrice;
    private Lotto winningNumbers;
    private int bonusNumber;
    private final HashMap<String, Integer> priceHistory;

    public StartLotto() {
        this.lottoList = new ArrayList<Lotto>();
        this.purchasePrice = 0;
        this.bonusNumber = 0;
        this.winningNumbers = null;
        this.priceHistory = new HashMap<>() {{
            put("Fifth", 0);
            put("Forth", 0);
            put("Third", 0);
            put("Second", 0);
            put("First", 0);
        }};
    }

    /*
     * String을 int로 변환한다. 이때, String이 Number Format이 아니면 Exception을 throw한다.
     */
    private int changeStringToInteger(String inputString) {
        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("올바른 숫자 형식이 아닙니다. 숫자를 입력해주세요.");
        }
    }

    /*
     * String List를 Integer List로 변환한다.
     */
    private List<Integer> changeStringToInteger(String[] inputString) {
        List<Integer> retVal = new ArrayList<Integer>();

        for (String s : inputString) {
            int number = changeStringToInteger(s);
            retVal.add(number);
        }

        return retVal;
    }

    public void printMessageForInputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    /*
     * 구입 금액을 입력받는다. 이때, 구입 금액이 숫자 형식인지 확인하고 1000단위의 숫자인지 확인한다.
     * 만약 Exception이 발생하면 다시 입력받게 한다.
     */
    public void inputPurchasePriceForClient() {
        boolean errorOccurred;
        do {
            String purchasePrice = Console.readLine();
            try {
                checkPurchasePrice(purchasePrice);
                errorOccurred = false;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
                errorOccurred = true;
            }
        } while (errorOccurred);
    }

    public void checkPurchasePrice(String purchasePrice) {
        // String -> Integer로 변환한다.
        int purchaseNumber = changeStringToInteger(purchasePrice);
        // 1000원 단위인지 확인한다.
        checkIs1000wonUnit(purchaseNumber);
        this.purchasePrice = purchaseNumber;
    }

    private void checkIs1000wonUnit(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("구입금액은 1000원 단위입니다. 다시 입력해주세요.");
        }
    }

    public void printMessageForInputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    /*
     * 당첨 번호를 입력받는다. 이때, 당첨 번호가 숫자 형식인지 확인하고 1 ~ 45 사이의 숫자인지, 중복되는 숫자는 없는지 확인한다.
     * 만약 Exception이 발생하면 다시 입력받게 한다.
     */
    public void inputWinningNumbersForClient() {
        boolean errorOccurred;
        do {
            String winningNumbersString = Console.readLine();
            try {
                checkWinningNumbers(winningNumbersString);
                errorOccurred = false;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
                errorOccurred = true;
            }
        } while (errorOccurred);
    }

    public void checkWinningNumbers(String winningNumbersString) {
        // String을 ,(쉼표) 단위로 split. String에 공백이 포함되어 있으면 공백을 없엔다.
        String[] splitWinningNumbersString = splitInputString(winningNumbersString);
        // String -> Integer로 변환한다.
        List<Integer> winningNumbers = changeStringToInteger(splitWinningNumbersString);
        // 입력받은 당첨 번호 리스트로 Lotto 객체를 만든다.
        this.winningNumbers = new Lotto(winningNumbers);
    }

    private String[] splitInputString(String winningNumbers) {
        winningNumbers = winningNumbers.replaceAll(" ", "");
        return winningNumbers.split(",", 0);
    }

    public void printMessageForInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
    }

    /*
     * 보너스 번호를 입력받는다. 이때, 보너스 번호가 숫자 형식인지 확인하고 1 ~ 45 사이의 숫자인지, 중복되는 숫자는 없는지 확인한다.
     * 만약 Exception이 발생하면 다시 입력받게 한다.
     */
    public void inputBonusNumberForClient() {
        boolean errorOccurred;
        do {
            String bonusNumberString = Console.readLine();
            try {
                checkBonusNumber(bonusNumberString);
                errorOccurred = false;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
                errorOccurred = true;
            }
        } while (errorOccurred);
    }

    public void checkBonusNumber(String bonusNumberString) {
        // String -> Integer로 변환한다.
        int bonusNumber = changeStringToInteger(bonusNumberString);
        // 1 ~ 45 사이의 숫자인지 확인한다.
        checkBonusNumberInRange(bonusNumber);
        // 당첨 번호와 보너스 번호가 중복되지 않는지 확인한다.
        checkDuplicatedNumberBonus(bonusNumber, this.winningNumbers.getNumbers());
        this.bonusNumber = bonusNumber;
    }

    private void checkBonusNumberInRange(int bonusNumber) {
        if (bonusNumber < 1 || 45 < bonusNumber) {
            throw new IllegalArgumentException("보너스 번호는 1 ~ 45 사이의 값을 가집니다.");
        }
    }

    private void checkDuplicatedNumberBonus(int bonusNumber, List<Integer> winningNumbers) {
        for (Integer oneNumber : winningNumbers) {
            if (bonusNumber == oneNumber) {
                throw new IllegalArgumentException("보너스 번호와 당첨 번호에는 서로 중복되는 숫자가 없습니다. 다시 입력해주세요.");
            }
        }
    }

    /*
     * 구입 금액 만큼 렌덤한 Lotto를 생성한다.
     */
    public void generateLottoList() {
        int listLen = this.purchasePrice / 1000;

        for (int i = 0; i < listLen; i++) {
            Lotto oneLotto = generateLotto();
            this.lottoList.add(oneLotto);
        }
    }

    /*
     * 서로 중복되지 않는 렌덤 숫자 6개를 발생시키고 오름차순으로 정렬한다.
     */
    private Lotto generateLotto() {
        List<Integer> temp = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sortLottoNumber(temp);
        return new Lotto(temp);
    }

    private void sortLottoNumber(List<Integer> lottoNumbers) {
        List<Integer> modifiedList = new ArrayList<Integer>(lottoNumbers);  //lottoNumbers가 unmodified일 경우 modified로 변환
        Collections.sort(modifiedList);
    }

    public void printPurchaseLottoAmount() {
        int lottoAmount = this.purchasePrice / 1000;
        System.out.println(lottoAmount + "개를 구매했습니다.");
    }

    /*
     * 구매한 Lotto 리스트를 출력한다.
     */
    public void printLottoList() {
        int listLen = this.purchasePrice / 1000;

        for (int i = 0; i < listLen; i++) {
            Lotto oneLotto = this.lottoList.get(i);
            printOneLotto(oneLotto);
        }
    }

    private void printOneLotto(Lotto oneLotto) {
        System.out.print("[");

        for (int i = 0; i < 5; i++) {
            System.out.print(oneLotto.getNumbers().get(i) + ", ");
        }

        System.out.println(oneLotto.getNumbers().get(5) + "]");
    }

    public void printPriceHistory() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + this.priceHistory.get("Fifth") + "개");
        System.out.println("4개 일치 (50,000원) - " + this.priceHistory.get("Forth") + "개");
        System.out.println("5개 일치 (1,500,000원) - " + this.priceHistory.get("Third") + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + this.priceHistory.get("Second") + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + this.priceHistory.get("First") + "개");
    }

    /*
     * 구입한 Lotto 리스트에서 1등부터 5등까지 몇개가 당첨되었는지 갯수를 파악한다.
     */
    public void fillPriceHistoryMap() {
        for (Lotto lotto : this.lottoList) {
            int sameNumberCount = countSameNumber(lotto);
            boolean lottoHasBonusNumber = false;

            if (sameNumberCount == 5) {
                lottoHasBonusNumber = checkLottoHasBonusNumber(lotto);
            }
            fillPriceHistory(sameNumberCount, lottoHasBonusNumber);
        }
    }

    private int countSameNumber(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int count = 0;

        for (int number : numbers) {
            if (checkNumberInWinningNumbers(number)) {
                count++;
            }
        }

        return count;
    }

    private boolean checkNumberInWinningNumbers(int number) {
        for (int winningNumber : this.winningNumbers.getNumbers()) {
            if (number == winningNumber) {
                return true;
            }
        }

        return false;
    }

    private boolean checkLottoHasBonusNumber(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();

        for (int number : numbers) {
            if (number == this.bonusNumber) {
                return true;
            }
        }

        return false;
    }

    private void fillPriceHistory(int count, boolean hasBonusNumber) {
        if (count == 3) {
            this.priceHistory.put("Fifth", this.priceHistory.get("Fifth") + 1);
        }
        if (count == 4) {
            this.priceHistory.put("Forth", this.priceHistory.get("Forth") + 1);
        }
        if (count == 5 && !hasBonusNumber) {
            this.priceHistory.put("Third", this.priceHistory.get("Third") + 1);
        }
        if (count == 5 && hasBonusNumber) {
            this.priceHistory.put("Second", this.priceHistory.get("Second") + 1);
        }
        if (count == 6) {
            this.priceHistory.put("First", this.priceHistory.get("First") + 1);
        }
    }

    public void printTotalEarningRate(double totalEarningRate) {
        System.out.println("총 수익률은 " + totalEarningRate + "%입니다.");
    }

    /*
     * 당첨 통계 바탕으로 수익률을 계산한다.
     */
    public double calcEarningRate() {
        double priceSum = 0.0;
        for (String price : new String[]{"Fifth", "Forth", "Third", "Second", "First"}) {
            priceSum += calcPrice(price);
        }
        double earningRate = (priceSum / this.purchasePrice) * 100.0;
        return roundSecondDigit(earningRate);
    }

    private double calcPrice(String price) {
        int count = this.priceHistory.get(price);
        if (Objects.equals(price, "Fifth")) {
            return count * Price.FIFTH.getPrice();
        }
        if (Objects.equals(price, "Forth")) {
            return count * Price.FORTH.getPrice();
        }
        if (Objects.equals(price, "Third")) {
            return count * Price.THIRD.getPrice();
        }
        if (Objects.equals(price, "Second")) {
            return count * Price.SECOND.getPrice();
        }
        return count * Price.FIRST.getPrice();
    }

    private double roundSecondDigit(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    private void printErrorMessage(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}
