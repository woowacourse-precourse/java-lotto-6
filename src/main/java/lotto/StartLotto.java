package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class StartLotto {
    private List<Lotto> lottoList;
    private int purchasePrice;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private HashMap<String, Integer> priceHistory;

    public StartLotto() {
        this.lottoList = new ArrayList<Lotto>();
        this.purchasePrice = 0;
        this.bonusNumber = 0;
        this.winningNumbers = new ArrayList<Integer>();
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
     * String List를 Integer List로 변환한다. 이때, 숫자가 1~45 사이인지 확인하고 중복된 숫자가 있는지 확인한다.
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

    public void inputPurchasePriceForClient() {
        boolean errorOccurred;
        do {
            try {
                inputPurchasePrice();
                errorOccurred = false;
            } catch (NumberFormatException e) {
                printErrorMessage(e);
                errorOccurred = true;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
                errorOccurred = true;
            }
        } while (errorOccurred);
    }

    private void inputPurchasePrice() {
        String purchasePrice = Console.readLine();

        int purchaseNumber = changeStringToInteger(purchasePrice);
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

    public void inputWinningNumbersForClient() {
        boolean errorOccurred;
        do {
            try {
                inputWinningNumbers();
                errorOccurred = false;
            } catch (NumberFormatException e) {
                printErrorMessage(e);
                errorOccurred = true;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
                errorOccurred = true;
            }
        } while (errorOccurred);
    }

    private void inputWinningNumbers() {
        String winningNumbers = Console.readLine();

        String[] splitWinningNumbers = splitInputString(winningNumbers);
        this.winningNumbers = changeStringToInteger(splitWinningNumbers);
    }

    private String[] splitInputString(String winningNumbers) {
        winningNumbers = winningNumbers.replaceAll(" ", "");
        return winningNumbers.split(",", 0);
    }

    public void printMessageForInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
    }

    public void inputBonusNumberForClient() {
        boolean errorOccurred;
        do {
            try {
                inputBonusNumber();
                errorOccurred = false;
            } catch (NumberFormatException e) {
                printErrorMessage(e);
                errorOccurred = true;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
                errorOccurred = true;
            }
        } while (errorOccurred);
    }

    private void inputBonusNumber() {
        String bonusNumberString = Console.readLine();

        int bonusNumber = changeStringToInteger(bonusNumberString);
        checkNumberInRange(bonusNumber);
        checkDuplicatedNumber(bonusNumber, this.winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public void generateLottoList() {
        int listLen = this.purchasePrice / 1000;

        try {
            for (int i = 0; i < listLen; i++) {
                Lotto oneLotto = generateLotto();
                this.lottoList.add(oneLotto);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("로또 번호는 6개의 숫자입니다.");
        }
    }

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
        for (int winningNumber : this.winningNumbers) {
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
