package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGame {
    private List<Lotto> lottos;
    private MoneyToBuy moneyToBuy;
    private WinningLotto winningLotto;

    public LottoGame() {
        lottos = new ArrayList<Lotto>();
    }

    public void run() {
        requestMoneyToBuy();
        requestWinningLotto();
        generateLottos();
        printBoughtLottos();
        printLottoGrades();
    }

    private void requestMoneyToBuy() {
        System.out.println(OutputMessage.REQUEST_MONEY_TO_BUY.getMessage());
        String string = Console.readLine();
        moneyToBuy = new MoneyToBuy(Integer.parseInt(string));
    }

    private void requestWinningLotto() {
        System.out.println(OutputMessage.REQUEST_WINNING_NUMBERS.getMessage());
        String winningLottoNumbers = Console.readLine();

        System.out.println(OutputMessage.REQUEST_BONUS_NUMBER.getMessage());
        String bonusNumber = Console.readLine();

        winningLotto = new WinningLotto(convertStringToList(winningLottoNumbers), Integer.parseInt(bonusNumber));
    }

    private List<Integer> convertStringToList(String string) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(string.split(",")).toList().forEach(str -> {
            list.add(Integer.parseInt(str));
        });

        return list;
    }

    private void generateLottos() {
        for (int i = 0; i < moneyToBuy.getLottosSize(); i++) {
            lottos.add(Lotto.generateLotto());
        }
    }

    private void printBoughtLottos() {
        System.out.printf(OutputMessage.BUY_LOTTO_RESULT.getMessage() + "\n", moneyToBuy.getLottosSize());
        lottos.forEach(lotto -> System.out.println(lotto));
    }

    private void printLottoGrades() {
        int threeMatch = 0;
        int fourMatch = 0;
        int fiveMatch = 0;
        int fiveAndBonusMatch = 0;
        int sixMatch = 0;

        for (int i = 0; i < lottos.size(); i++) {
            LottoGrade lottoGrade = winningLotto.determineLottoGrade(lottos.get(i));
            if (lottoGrade == LottoGrade.SIX_MATCH) {
                sixMatch += 1;
            } else if (lottoGrade == LottoGrade.FIVE_AND_BONUS_MATCH) {
                fiveAndBonusMatch += 1;
            } else if (lottoGrade == LottoGrade.FIVE_MATCH) {
                fiveMatch += 1;
            } else if (lottoGrade == LottoGrade.FOUR_MATCH) {
                fourMatch += 1;
            } else if (lottoGrade == LottoGrade.THREE_MATCH) {
                threeMatch += 1;
            }
        }

        System.out.printf(OutputMessage.LOTTO_GRADE_RESULT.getMessage(), threeMatch, fourMatch, fiveMatch,
                fiveAndBonusMatch, sixMatch);
        printRateOfReturn(threeMatch, fourMatch, fiveMatch,
                fiveAndBonusMatch, sixMatch);
    }

    private void printRateOfReturn(int threeMatch, int fourMatch, int fiveMatch, int fiveAndBonusMatch, int sixMatch) {
        Integer totalIncome = Prize.getTotalIncome(threeMatch, fourMatch, fiveMatch,
                fiveAndBonusMatch, sixMatch);
        Double rateOfReturn = totalIncome.doubleValue() / moneyToBuy.getValue() * 100;
        System.out.printf(OutputMessage.RATE_OF_RETURN.getMessage(), String.format("%.1f", rateOfReturn));
    }
}
