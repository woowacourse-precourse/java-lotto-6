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

    private int changeStringToInteger(String inputString) {
        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    private List<Integer> changeStringToInteger(String[] inputString) {
        List<Integer> retVal = new ArrayList<Integer>();

        for (String s : inputString) {
            int number = changeStringToInteger(s);
            checkNumberInRange(number);
            checkDuplicatedNumber(number, retVal);
            retVal.add(number);
        }

        return retVal;
    }

    private void checkNumberInRange(int number) {
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicatedNumber(int number, List<Integer> numberList) {
        for (Integer oneNumber : numberList) {
            if (number == oneNumber) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void printMessageForInputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private void inputPurchasePrice() {
        String purchasePrice = Console.readLine();

        int purchaseNumber = changeStringToInteger(purchasePrice);
        checkIs1000wonUnit(purchaseNumber);
        this.purchasePrice = purchaseNumber;
    }

    private void checkIs1000wonUnit(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void printMessageForInputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
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

    private void printMessageForInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
    }

    private void inputBonusNumber() {
        String bonusNumberString = Console.readLine();

        int bonusNumber = changeStringToInteger(bonusNumberString);
        checkNumberInRange(bonusNumber);
        checkDuplicatedNumber(bonusNumber, this.winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void generateLottoList() {
        int listLen = this.purchasePrice / 1000;

        for (int i = 0; i < listLen; i++) {
            Lotto oneLotto = generateLotto();
            this.lottoList.add(oneLotto);
        }
    }

    private Lotto generateLotto() {
        List<Integer> temp = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sortLottoNumber(temp);
        return new Lotto(temp);
    }

    private void sortLottoNumber(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }

    private void printPurchaseLottoAmount() {
        int lottoAmount = this.purchasePrice / 1000;
        System.out.println(lottoAmount + "개를 구매했습니다.");
    }

    private void printLottoList() {
        int listLen = this.purchasePrice / 1000;

        for (int i = 0; i < listLen; i++) {
            Lotto oneLotto = this.lottoList.get(i);
            printOneLotto(oneLotto);
        }
    }

    private void printOneLotto(Lotto oneLotto) {
        System.out.print('[');

        for (int i = 0; i < 5; i++) {
            System.out.print(oneLotto.getNumbers().get(i) + ", ");
        }

        System.out.print(oneLotto.getNumbers().get(5) + ']');
    }

    private void printPriceHistory() {
        fillPriceHistoryMap();
        System.out.println("3개 일치 (5,000원) - " + this.priceHistory.get("Fifth") + "개");
        System.out.println("4개 일치 (50,000원) - " + this.priceHistory.get("Forth") + "개");
        System.out.println("5개 일치 (1,500,000원) - " + this.priceHistory.get("Third") + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + this.priceHistory.get("Second") + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + this.priceHistory.get("First") + "개");
    }

    private void fillPriceHistoryMap() {
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

    private void printTotalEarningRate(double totalEarningRate) {
        System.out.println("총 수익률은 " + totalEarningRate + "%입니다.");
    }

    private double calcEarningRate() {
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
}
