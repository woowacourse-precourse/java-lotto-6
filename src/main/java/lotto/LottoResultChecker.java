package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultChecker {

    private final static String SEPARATOR = ",";


    public List<Lotto> lottoBundle;
    public List<Integer> winNumbers;
    public Integer bonusNumber;
    public Map<Winning, Integer> lottoResultMemo = new HashMap<>();


    public LottoResultChecker(List<Lotto> lottoBundle) {
        this.lottoBundle = lottoBundle;
    }

    public void lottoResultCheckerInput() {
        winNumbersInput();
        bonusNumberInput();
    }

    public void winNumbersInput() {
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            setWinNumbers(Console.readLine());
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            winNumbersInput();
        }
    }

    public void setWinNumbers(String input) {
        Exception.validateSeparator(input);
        List<String> separatedNumbersInString = List.of(input.split(SEPARATOR));

        List<Integer> separatedNumbers = new ArrayList<Integer>();
        for (String number : separatedNumbersInString) {
            Exception.notParsableNumber(number);
            separatedNumbers.add(Integer.parseInt(number));
        }

        Exception.validateLottoNumbers(separatedNumbers);
        winNumbers = separatedNumbers;
    }

    public void bonusNumberInput() {
        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            setBonusNumber(Console.readLine());
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bonusNumberInput();
        }
    }

    public void setBonusNumber(String input) {
        Exception.notParsableNumber(input);
        bonusNumber = Integer.parseInt(input);
        Exception.validateBonusNumber(winNumbers, bonusNumber);
    }

    public void lottoResultCheckerOutput() {
        checkLottoBundle();

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        printResultOfCheck();
        System.out.printf("총 수익률은 %.1f%%입니다.", calculatePortfolio());
    }

    public void checkLottoBundle() {
        for (Lotto l : lottoBundle) {
            Integer label = l.compareWithWinNumbers(winNumbers, bonusNumber);
            Winning winning = Winning.getWinning(label);
            lottoResultMemo.put(winning, lottoResultMemo.getOrDefault(winning, 0) + 1);
        }
    }

    public void printResultOfCheck() {
        System.out.println("3개 일치 (5,000원) - " + lottoResultMemo.getOrDefault(Winning.THREE, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResultMemo.getOrDefault(Winning.FOUR, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResultMemo.getOrDefault(Winning.FIVE, 0) + "개");
        System.out.println(
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResultMemo.getOrDefault(Winning.FIVE_AND_BONUS, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResultMemo.getOrDefault(Winning.SIX, 0) + "개");
    }

    public float calculatePortfolio() {
        float portfolio = 0;
        portfolio += lottoResultMemo.getOrDefault(Winning.THREE, 0) * Winning.THREE.getPrize();
        portfolio += lottoResultMemo.getOrDefault(Winning.FOUR, 0) * Winning.FOUR.getPrize();
        portfolio += lottoResultMemo.getOrDefault(Winning.FIVE, 0) * Winning.FIVE.getPrize();
        portfolio += lottoResultMemo.getOrDefault(Winning.FIVE_AND_BONUS, 0) * Winning.FIVE_AND_BONUS.getPrize();
        portfolio += lottoResultMemo.getOrDefault(Winning.SIX, 0) * Winning.SIX.getPrize();
        portfolio = portfolio / (lottoBundle.size() * 1000) * 100;
        return portfolio;
    }


}
