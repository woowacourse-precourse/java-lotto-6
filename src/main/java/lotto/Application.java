package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoChecker;
import lotto.domain.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int money = inputView.getMoney();

        List<Integer> winNumbers = inputView.getWinNumbers();
        Lotto winTicket = new Lotto(winNumbers);

        int bonusNumber = inputView.getBonusNumber();

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> tickets = lottoGenerator.getTickets(money);

        outputView.printAllTickets(tickets);

        LottoChecker lottoChecker = new LottoChecker();
        int totalReward = 0;
        for (int i = 0; i < tickets.size() ; i++) {
            totalReward = lottoChecker.checkReward(tickets.get(i), winTicket, bonusNumber);
        }

        int[] rankCount = lottoChecker.getRankCount();

        DecimalFormat df = new DecimalFormat("#.##"); // 소수점 둘째 자리까지 표시
        double profitability = ((double) totalReward / money) * 100;

        outputView.printRankResult(rankCount, profitability);

    }
}
