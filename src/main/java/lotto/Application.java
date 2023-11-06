package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int price = 1000;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
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
    }
    public static List<Integer> makeLottoNumbers() {
        return pickUniqueNumbersInRange(1, 45, 6);
    }
}
