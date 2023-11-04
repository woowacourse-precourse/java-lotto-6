package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.WinningCondition;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoController {

    private static final int LOTTO_PRICE = 1000;
    private static final String NUMBER_FORMAT_EXCEPTION = "숫자가 아닙니다.";

    private final Output output = new Output();
    private final Input input = new Input();

    public void run() {
        output.showMoneyInputMessage();
        int money = toInt(input.readMoney());

        LottoTickets lottoTickets = makeLottoTickets(money);
        output.showLottoTickets(lottoTickets);

        WinningCondition winningCondition = makeWinningCondition();
        Map<Lotto, Rank> rankByLotto = winningCondition.findRankByLotto(lottoTickets);
        Map<Rank, Integer> winningResult = makeWinningResult(rankByLotto);
        output.showWinningStats(winningResult);
    }

    private Map<Rank, Integer> makeWinningResult(Map<Lotto, Rank> rankByLotto) {
        Map<Rank, Integer> winningResult = Arrays.stream(Rank.values())
                .collect(Collectors.toMap(rank -> rank, rank -> 0));

        for (Rank rank : rankByLotto.values()) {
            winningResult.put(rank, winningResult.get(rank) + 1);
        }

        return winningResult;
    }

    private WinningCondition makeWinningCondition() {
        output.showWinningNumbersInputMessage();
        Lotto winningLotto = makeWinningLotto(input.readWinningNumbers());

        output.showBonusNumberInputMessage();
        int bonusNumber = toInt(input.readBonusNumber());

        return new WinningCondition(winningLotto, bonusNumber);
    }

    private Lotto makeWinningLotto(String winningNumbers) {
        return Lotto.makeWinningLotto(winningNumbers);
    }

    private LottoTickets makeLottoTickets(int money) {
        int count = money / LOTTO_PRICE;

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(makeLotto());
        }

        return new LottoTickets(lottos);
    }

    private int toInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
        }
    }

    private Lotto makeLotto() {
        return new Lotto(makeLottoNumbers());
    }

    private List<Integer> makeLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
