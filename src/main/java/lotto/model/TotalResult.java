package lotto.model;

import lotto.view.OutputView;

import java.util.List;

public class TotalResult {
    private final int SIX = 6;
    private final OutputView outputView = new OutputView();

    public void print(int initMoney, List<Lotto> totalLotto, WinningNumbers winningNumbers, int bonusNumber) {
        outputView.printResult();
        int sum = compare(totalLotto, winningNumbers, bonusNumber);
        totalRate(initMoney, sum);
    }

    private void totalRate(int initMoney, int sum) {
    }

    private int compare(List<Lotto> totalLotto, WinningNumbers winningNumbers, int bonusNumber) {
        int totalMoney = 0;
        for (Lotto lotto : totalLotto) {
            int correct = 0;
            int bonus = 0;
            for (int number = 0; number < SIX; number++) {
                correct = countWinning(lotto, winningNumbers);
            }
            bonus = countBonus(lotto, bonusNumber);
            totalMoney += cal(correct, bonus);
        }
        return totalMoney;
    }

    private int countBonus(Lotto lotto, int bonusNumber) {
        String[] lottoNumbers = lotto.toString().replaceAll("[^0-9,]", "").split(",");
        for (int index = 0; index < lottoNumbers.length; index++) {
            if (stoi(lottoNumbers[index]) == bonusNumber) {
                return 1;
            }
        }
        return 0;
    }

    private int countWinning(Lotto lotto, WinningNumbers winningNumbers) {
        int result = 0;

        String[] compareWinningNumber = winningNumbers.toString().replaceAll("[^0-9,]", "").split(",");
        String[] lottoNumbers = lotto.toString().replaceAll("[^0-9,]", "").split(",");
        for (String lottoNumber : lottoNumbers) {
            for (String winning : compareWinningNumber) {
                if (stoi(winning) == stoi(lottoNumber)) {
                    result++;
                    break;
                }
            }
        }

        return result;
    }


    private int cal(int correct, int bonus) {
        return 0;
    }

    private int stoi(String input) {
        return Integer.parseInt(input);
    }
}
