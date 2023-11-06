package lotto.model;

import lotto.view.LottoWin;
import lotto.view.OutputView;

import java.util.List;

public class TotalResult {
    private final int SIX = 6;
    private final double HUNDRED = 100.0;
    private int third = 0;
    private int fourth = 0;
    private int fifth = 0;
    private int sixthBonus = 0;
    private int sixth = 0;
    private final OutputView outputView = new OutputView();

    public void print(int initMoney, List<Lotto> totalLotto, WinningNumbers winningNumbers, int bonusNumber) {
        outputView.startResult();
        compare(totalLotto, winningNumbers, bonusNumber);
        double sum = result();
        totalRate(initMoney, sum);
    }

    private double result() {
        outputView.printResult(LottoWin.THREE.getPrize(), LottoWin.THREE.getMatchingNumbers(), third);
        outputView.printResult(LottoWin.FOUR.getPrize(), LottoWin.FOUR.getMatchingNumbers(), fourth);
        outputView.printResult(LottoWin.FIVE.getPrize(), LottoWin.FIVE.getMatchingNumbers(), fifth);
        outputView.printBonus(LottoWin.BONUS.getMatchingNumbers(), sixthBonus);
        outputView.printResult(LottoWin.SIX.getPrize(), LottoWin.SIX.getMatchingNumbers(), sixth);

        return totalMoney();
    }

    private double totalMoney() {
        double sum = 0;

        sum += LottoWin.THREE.getPrize() * third;
        sum += LottoWin.FOUR.getPrize() * fourth;
        sum += LottoWin.FIVE.getPrize() * fifth;
        sum += LottoWin.BONUS.getPrize() * sixthBonus;
        sum += LottoWin.SIX.getPrize() * sixth;

        return sum;
    }


    private void totalRate(int initMoney, double sum) {
        double result = (sum * HUNDRED) / initMoney;
        result = Math.round(result * HUNDRED) / HUNDRED;

        outputView.printRate(result);
    }

    private void compare(List<Lotto> totalLotto, WinningNumbers winningNumbers, int bonusNumber) {
        for (Lotto lotto : totalLotto) {
            int correct = 0;
            int bonus = 0;

            correct = countWinning(lotto, winningNumbers);
            bonus = countBonus(lotto, bonusNumber);
            count(correct, bonus);
        }
    }

    private void count(int correct, int bonus) {
        if (correct == LottoWin.THREE.getMatchingNumbers()) {
            third++;
        } else if (correct == LottoWin.FOUR.getMatchingNumbers()) {
            fourth++;
        } else if (correct == LottoWin.FIVE.getMatchingNumbers() && bonus == 1) {
            sixthBonus++;
        } else if (correct == LottoWin.FIVE.getMatchingNumbers()) {
            fifth++;
        } else if (correct == LottoWin.SIX.getMatchingNumbers()) {
            sixth++;
        }
    }

    private int countBonus(Lotto lotto, int bonusNumber) {
        List<Integer> parts = lotto.getNumbers();
        for (int lottoNumber : parts) {
            if (lottoNumber == bonusNumber) {
                return 1;
            }
        }
        return 0;
    }

    private int countWinning(Lotto lotto, WinningNumbers winningNumbers) {
        int result = 0;

        List<Integer> lottoParts = lotto.getNumbers();
        List<Integer> winningParts = winningNumbers.getWinningNumbers();
        for (int lottoNumber : lottoParts) {
            for (int winning : winningParts) {
                if (winning == lottoNumber) {
                    result++;
                    break;
                }
            }
        }

        return result;
    }
}
