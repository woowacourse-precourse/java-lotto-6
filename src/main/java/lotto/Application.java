package lotto;

import lotto.constant.LottoRanking;
import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static lotto.constant.LottoConstant.LOTTO_PRICE;

public class Application {
    private static LottoInputView inputView;
    private static LottoOutputView outputView;


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        inputView = new LottoInputView();
        outputView = new LottoOutputView();

        LottoTicket ticket = getInputUntilValid(Application::getBoughtTicket);
        List<Lotto> userLottos = buyLottos(ticket);

        outputView.printBoughtResult(userLottos);

        Lotto winningLottoNumbers = getInputUntilValid(Application::getWinningLottoNumbers);
        BonusNumber bonusNumber = getInputUntilValid(Application::getBonusNumber);

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

        List<LottoRanking> rankings = winningLotto.checkLottoRanking(userLottos);
        outputView.printLottoResult(convertRankingListToMap(rankings));

        int totalPrize = WinningLotto.calculateTotalPrize(rankings);
        outputView.printProfit(ticket.amount() * LOTTO_PRICE, totalPrize);
    }

    public static <T> T getInputUntilValid(Supplier<T> inputMethod) {
        try {
            return inputMethod.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputUntilValid(inputMethod);
        }
    }

    public static LottoTicket getBoughtTicket() {
        outputView.printBuyingPriceInputRequest();
        String input = inputView.getBuyingPrice();
        return LottoTicket.buyTicket(input);
    }

    public static List<Lotto> buyLottos(LottoTicket ticket) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticket.amount(); i++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generateLottoNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    public static Lotto getWinningLottoNumbers() {
        outputView.printAnswerInputRequest();
        String input = inputView.getLottoWinningNumbers();
        return Lotto.create(input);
    }

    public static BonusNumber getBonusNumber() {
        outputView.printBonusInputRequest();
        String input = inputView.getBonusNumber();
        return BonusNumber.create(input);
    }

    public static Map<LottoRanking, Integer> convertRankingListToMap(List<LottoRanking> rankings) {
        Map<LottoRanking, Integer> statistic = new HashMap<>();
        for (LottoRanking ranking : rankings) {
            statistic.put(ranking, statistic.getOrDefault(ranking, 0) + 1);
        }
        return statistic;
    }
}
