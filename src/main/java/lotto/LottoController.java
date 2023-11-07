package lotto;


import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.enums.NoticeMessage;
import lotto.enums.PrizeMoney;

public class LottoController {
    private Lottos lottos;
    private int bonusNumber;
    private int money;
    private Lotto winningLotto;

    public LottoController() {
    }

    public void run() {
        purchaseLotto();
        drawWinningNumbers();
        drawBonusNumbers();
        announceResultOfLotto();
    }


    public void purchaseLotto() {
        PrintOutput.printNoticeMessage(NoticeMessage.BUY_MONEY);
        money = UserInput.getUserMoney();

        int lottoCount = money / Lotto.getPrice();

        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lotto.add(new Lotto(new ArrayList<>(makeLottoNumbers())));
        }
        lottos = new Lottos(lotto);

        PrintOutput.printCountOfLotto(lottoCount);
        PrintOutput.printLottos(lottos);
    }

    public void drawWinningNumbers() {
        PrintOutput.printNoticeMessage(NoticeMessage.WINNING_NUMBERS);
        winningLotto = new Lotto(UserInput.getWinningNumbers());
    }

    public void drawBonusNumbers() {
        System.out.println();
        PrintOutput.printNoticeMessage(NoticeMessage.BONUS_NUMBER);
        bonusNumber = UserInput.getBonusNumber(winningLotto);
    }

    public void announceResultOfLotto() {
        // Map<n, n등인 로또 수>
        Map<Integer, Integer> winningRanks = lottos.countMatches(winningLotto, bonusNumber);

        System.out.println();
        PrintOutput.printNoticeMessage(NoticeMessage.WINNING_RESULT);
        PrintOutput.printNoticeMessage(NoticeMessage.STRAIGHT_LINE);
        PrintOutput.printLottosRank(winningRanks);

        double rateOfReturn = calculateRateOfReturn(winningRanks, money);

        PrintOutput.printRateOfReturn(rateOfReturn);
    }

    public List<Integer> makeLottoNumbers() {
        return pickUniqueNumbersInRange(1, 45, 6);
    }

    private double calculateRateOfReturn(Map<Integer, Integer> winningRanks, int buyMoney) {
        long sumOfPrizeMoney = 0;
        sumOfPrizeMoney += winningRanks.get(1) * PrizeMoney.FIRST.getPrizeMoney();
        sumOfPrizeMoney += winningRanks.get(2) * PrizeMoney.SECOND.getPrizeMoney();
        sumOfPrizeMoney += winningRanks.get(3) * PrizeMoney.THIRD.getPrizeMoney();
        sumOfPrizeMoney += winningRanks.get(4) * PrizeMoney.FOURTH.getPrizeMoney();
        sumOfPrizeMoney += winningRanks.get(5) * PrizeMoney.FIFTH.getPrizeMoney();

        return (double) sumOfPrizeMoney / buyMoney * 100;
    }
}
