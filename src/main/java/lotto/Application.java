package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.enums.NoticeMessage;
import lotto.enums.PrizeMoney;

public class Application {

    public static void main(String[] args) {

        // 로또 구입 기능 입력 처리
        PrintOutput.printNoticeMessage(NoticeMessage.BUY_MONEY);
        int money = UserInput.getUserMoney();

        // 로또 구입 수 계산
        int lottoCount = money / Lotto.getPrice();

        // 구입 수만큼 로또 발행
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lotto.add(new Lotto(makeLottoNumbers()));
        }
        Lottos lottos = new Lottos(lotto);

        // 구입 로또 출력 처리
        PrintOutput.printCountOfLotto(lottoCount);
        PrintOutput.printLottos(lottos);

        // 로또 당첨 번호 입력 처리
        PrintOutput.printNoticeMessage(NoticeMessage.WINNING_NUMBERS);
        Lotto winningLotto = new Lotto(UserInput.getWinningNumbers());

        // 보너스 번호 입력 처리
        System.out.println();
        PrintOutput.printNoticeMessage(NoticeMessage.BONUS_NUMBER);
        int bonusNumber = UserInput.getBonusNumber();
        while (isBonusNumberSameWithWinningNumbers(winningLotto, bonusNumber)) {
            bonusNumber = UserInput.getBonusNumber();
        }

        // Map<n, n등인 로또 수>
        Map<Integer, Integer> winningRanks = lottos.countMatches(winningLotto, bonusNumber);

        System.out.println();
        PrintOutput.printNoticeMessage(NoticeMessage.WINNING_RESULT);
        PrintOutput.printNoticeMessage(NoticeMessage.STRAIGHT_LINE);
        PrintOutput.printLottosRank(winningRanks);

        double rateOfReturn = calculateRateOfReturn(winningRanks, money);

        PrintOutput.printRateOfReturn(rateOfReturn);
    }

    public static List<Integer> makeLottoNumbers() {
        return pickUniqueNumbersInRange(1, 45, 6);
    }

    private static boolean isBonusNumberSameWithWinningNumbers(Lotto winningNumbers, int bonusNumber) {
        return winningNumbers.contains(bonusNumber);
    }

    private static double calculateRateOfReturn(Map<Integer, Integer> winningRanks, int buyMoney) {
        long sumOfPrizeMoney = 0;
        sumOfPrizeMoney += winningRanks.get(1) * PrizeMoney.FIRST.getPrizeMoney();
        sumOfPrizeMoney += winningRanks.get(2) * PrizeMoney.SECOND.getPrizeMoney();
        sumOfPrizeMoney += winningRanks.get(3) * PrizeMoney.THIRD.getPrizeMoney();
        sumOfPrizeMoney += winningRanks.get(4) * PrizeMoney.FOURTH.getPrizeMoney();
        sumOfPrizeMoney += winningRanks.get(5) * PrizeMoney.FIFTH.getPrizeMoney();

        return (double) sumOfPrizeMoney / buyMoney;
    }
}
