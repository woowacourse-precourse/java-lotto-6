package lotto.model;

import lotto.view.OutputView;

import java.util.List;

public class TotalResult {
    private final int SIX = 6;
    private final OutputView outputView = new OutputView();
    public void print(int initMoney, List<Lotto> totalLotto, WinningNumbers winningNumbers) {
        outputView.printResult();
        int sum = compare(totalLotto, winningNumbers);
        totalRate(initMoney, sum);
    }

    private void totalRate(int initMoney, int sum) {
    }

    private int compare(List<Lotto> totalLotto, WinningNumbers winningNumbers) {
        int totalMoney = 0;
        for(int lottoIndex = 0; lottoIndex < totalLotto.size(); lottoIndex++){
            int correct = 0;
            int bonus = 0;
            for(int number = 0; number < SIX ; number++){
                correct = countWinning(totalLotto.get(lottoIndex) , winningNumbers);
                bonus = countBonus(totalLotto.get(lottoIndex) , winningNumbers);
            }
            totalMoney += cal(correct, bonus);
        }
        return totalMoney;
    }

    private int countBonus(Lotto lotto, WinningNumbers winningNumbers) {

        return 1;
    }

    private int countWinning(Lotto lotto, WinningNumbers winningNumbers) {
        int result = 0;

        String[] parts = lotto.toString().replaceAll("[^0-9,]", "").split(",");

        return 1;
    }


    private int cal(int correct, int bonus) {
        return 0;
    }
}
