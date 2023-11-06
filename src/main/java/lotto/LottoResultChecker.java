package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Exception.LottoNumbersException;

public class LottoResultChecker {

    private List<Integer> winNumbers;
    private Integer bonusNumber;
    private List<Lotto> lottoBundle;
    private Map<Winning, Integer> lottoResultMemo = new HashMap<>();

    public void startLottoResultCheckerView(List<Lotto> lottoBundle) {
        setWinNumbers();
        setBonusNumber();
        this.lottoBundle = lottoBundle;
    }

    public void showLottoResultView() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Lotto l : lottoBundle) {
            Integer label = l.compareWithWinNumbers(winNumbers, bonusNumber);
            Winning winning = Winning.getWinning(label);
            lottoResultMemo.put(winning, lottoResultMemo.getOrDefault(winning, 0) + 1);
        }

        System.out.println("3개 일치 (5,000원) - " + lottoResultMemo.getOrDefault(Winning.THREE, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResultMemo.getOrDefault(Winning.FOUR, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResultMemo.getOrDefault(Winning.FIVE, 0) + "개");
        System.out.println(
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResultMemo.getOrDefault(Winning.FIVE_AND_BONUS, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResultMemo.getOrDefault(Winning.SIX, 0) + "개");

        System.out.printf("총 수익률은 %.1f%%입니다.", calculatePortfolio());

    }

    private float calculatePortfolio() {
        float portfolio = lottoResultMemo.getOrDefault(Winning.THREE, 0) * Winning.THREE.getPrize();
        portfolio += lottoResultMemo.getOrDefault(Winning.FOUR, 0) * Winning.FOUR.getPrize();
        portfolio += lottoResultMemo.getOrDefault(Winning.FIVE, 0) * Winning.FIVE.getPrize();
        portfolio += lottoResultMemo.getOrDefault(Winning.FIVE_AND_BONUS, 0) * Winning.FIVE_AND_BONUS.getPrize();
        portfolio += lottoResultMemo.getOrDefault(Winning.SIX, 0) * Winning.SIX.getPrize();
        portfolio = portfolio / (lottoBundle.size() * 1000) * 100;
        return portfolio;
    }

    private void setWinNumbers() {
        try {
            System.out.println();
            System.out.println("당첨 번호를 입력해 주세요.");
            winNumbers = numbersSeparator(Console.readLine());
            LottoNumbersException.validateLottoNumbers(winNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setWinNumbers();
        }
    }

    private void setBonusNumber() {
        try {
            System.out.println();
            System.out.println("보너스 번호를 입력해 주세요.");
            bonusNumber = Integer.parseInt(Console.readLine());
            LottoNumbersException.validateBonusNumber(winNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setBonusNumber();
        }
    }

    private List<Integer> numbersSeparator(String numberString) {
        List<String> separatedNumbersInString = List.of(numberString.split(","));

        List<Integer> separatedNumbers = new ArrayList<Integer>();
        for (String number : separatedNumbersInString) {
            separatedNumbers.add(Integer.parseInt(number));
        }

        return separatedNumbers;
    }

}
