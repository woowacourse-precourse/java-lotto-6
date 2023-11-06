package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int price = 1000;

    public static void main(String[] args) {

        // 로또 구입 기능 입력 처리
        PrintOutput.printNoticeMessage(NoticeMessage.BUY_MONEY);
        int money = UserInput.getUserMoney();

        // 로또 구입 수 계산
        int lottoCount = money / price;

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
        PrintOutput.printNoticeMessage(NoticeMessage.BONUS_NUMBER);
        int bonusNumber = UserInput.getBonusNumber();
        while (isBonusNumberSameWithWinningNumbers(winningLotto, bonusNumber)) {
            bonusNumber = UserInput.getBonusNumber();
        }

        // TODO: 당첨 통계 계산


        // TODO: 당첨 통계 출력
        // PrintOutput.printNoticeMessage(NoticeMessage.WINNING_RESULT);
        // PrintOutput.printNoticeMessage(NoticeMessage.STRAIGHT_LINE);

        // TODO: 수익률 계산 처리

        // TODO: 수익률 출력 처리

    }

    public static List<Integer> makeLottoNumbers() {
        return pickUniqueNumbersInRange(1, 45, 6);
    }

    private static boolean isBonusNumberSameWithWinningNumbers(Lotto winningNumbers, int bonusNumber) {
        return winningNumbers.contains(bonusNumber);
    }
}
