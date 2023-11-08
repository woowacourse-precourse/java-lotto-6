package controller;

import java.util.List;

import lotto.LottoMoney;
import lotto.LuckeyLotto;
import view.OutputView;

public class LottoController {
    private static final int REWARD_SIZE = 5;
    private static final int LOTTO_BONUS_NUMBER_INDEX = 5;
    private static final int MINIMUM_LOTTO_NUMBER = 2;
    private static final int START_WINNER_NUMBER = 3;
    private static final int END_WINNER_NUMBER = 6;
    private static final int[] REWARD = { 5000, 50000, 1500000, 30000000, 2000000000 };

    LuckeyLotto luckeyLotto;
    LottoMoney lottoMoney;

    OutputView outputView = new OutputView();
    int lottoWinnerCount;
    int[] lottoWinners = new int[REWARD_SIZE];

    public LottoController(LottoMoney lottoMoney, LuckeyLotto luckeyLotto) {
        this.lottoMoney = lottoMoney;
        this.luckeyLotto = luckeyLotto;
    }

    public void playGame(List<List<Integer>> lottonumbers) {
        outputView.printLottoResultMessage();
        decideLottoWinner(lottonumbers);
        infoLottoWinner();
        double revenuePercentage = decideRevenuePercentage();
        outputView.printRevenuePercentage(revenuePercentage);
    }

    private void decideLottoWinner(List<List<Integer>> randomlottoNumbers) {
        for (List<Integer> lottoNumbers : randomlottoNumbers) {
            lottoWinnerCount = getLottoWinnerCount(lottoNumbers);
            increaseLottoWinnerCount(lottoNumbers, lottoWinnerCount);
        }
    }

    private int getLottoWinnerCount(List<Integer> lottoNumbers) {
        int lottoCount = 0;
        for (int lottoIndex = 0; lottoIndex < lottoNumbers.size(); lottoIndex++) {
            if (luckeyLotto.getluckeyNumbers().contains(lottoNumbers.get(lottoIndex))) {
                lottoCount++;
            }
        }
        return lottoCount;
    }

    private void increaseLottoWinnerCount(List<Integer> lottoNumbers, int lottoWinnerCount) {
        if (lottoWinnerCount == LOTTO_BONUS_NUMBER_INDEX && lottoNumbers.contains(luckeyLotto.getLuckeyBonusNumber())) {
            lottoWinners[lottoWinnerCount - 2]++;
        } else if (lottoWinnerCount > MINIMUM_LOTTO_NUMBER) {
            lottoWinners[lottoWinnerCount - 3]++;
        }
    }

    private void infoLottoWinner() {
        int rewardIndex = 0;
        String bonusMessage = "";
        boolean bonusState = false;
        for (int matchNumber = START_WINNER_NUMBER; matchNumber <= END_WINNER_NUMBER; matchNumber++) {
            bonusMessage = isBonusMessage(matchNumber, bonusMessage, bonusState);
            matchNumber = isBonusMatchNumber(matchNumber, bonusState);
            outputView.printLottoResult(matchNumber, rewardIndex, bonusMessage, lottoWinners[matchNumber - 3]);
            bonusState = cheackBonusLottoTime(matchNumber, bonusState);
            rewardIndex++;
        }
    }

    private String isBonusMessage(int matchNumber, String bonusMessage, boolean bonusState) {
        bonusMessage = "";
        if (bonusState == true) {
            bonusMessage = ", 보너스 볼 일치";
        }
        return bonusMessage;
    }

    private int isBonusMatchNumber(int matchNumber, boolean bonusState) {
        if (bonusState == true) {
            matchNumber--;
        }
        return matchNumber;
    }

    private boolean cheackBonusLottoTime(int matchNumber, boolean bonusState) {
        return matchNumber == LOTTO_BONUS_NUMBER_INDEX && bonusState == false;
    }

    private double decideRevenuePercentage() {
        double investRevenue = getInvestRevenue();
        double revenuePercentage = investRevenue / lottoMoney.getLottoMoney() * 100;
        return revenuePercentage;
    }

    private double getInvestRevenue() {
        double InvestRevenue = 0.0;
        for (int i = 0; i < lottoWinners.length; i++) {
            InvestRevenue += lottoWinners[i] * REWARD[i];
        }
        return InvestRevenue;
    }
}
