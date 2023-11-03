package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class StartLotto {
    private List<Lotto> lottoList;
    private int purchasePrice;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public StartLotto() {
        this.purchasePrice = 0;
        this.bonusNumber = 0;
        this.winningNumbers = new ArrayList<Integer>();
    }

    private int changeStringToInteger(String inputString) {
        try{
            return Integer.parseInt(inputString);
        } catch(NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    private List<Integer> changeStringToInteger(String[] inputString) {
        List<Integer> retVal = new ArrayList<Integer>();

        for(String s: inputString) {
            int number = changeStringToInteger(s);
            checkNumberInRange(number);
            checkDuplicatedNumber(number, retVal);
            retVal.add(number);
        }

        return retVal;
    }

    private void checkNumberInRange(int number) {
        if(number < 1 || 45 < number) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicatedNumber(int number, List<Integer> numberList) {
        for(Integer oneNumber: numberList) {
            if(number == oneNumber) {
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
        if(price % 1000 != 0) {
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

        for(int i = 0; i < listLen; i++) {
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

        for(int i = 0; i < listLen; i++) {
            Lotto oneLotto = this.lottoList.get(i);
            printOneLotto(oneLotto);
        }
    }

    private void printOneLotto(Lotto oneLotto) {
        System.out.print('[');

        for(int i = 0; i < 5; i++) {
            System.out.print(oneLotto.getNumbers().get(i) + ", ");
        }

        System.out.print(oneLotto.getNumbers().get(5) + ']');
    }
}
