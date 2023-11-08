package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoController {

    public static final OutputView OUTPUT_VIEW = new OutputView();
    public final LottoPublisher LOTTO_PUBLISHER = new LottoPublisher();
    public Statistics statistics;
    public int price;

    public void run() {
        price = buyLotto();
        int lottoCount = LOTTO_PUBLISHER.getLottoCount(price);

        List<Lotto> userLottos = userLotto(lottoCount);

        Lotto winLotto = getWinNumber();
        int bonusNumber = getBonusNumber(winLotto);

        winnerStatistics(userLottos, winLotto, bonusNumber);
    }

    private int buyLotto() {
        int price = 0;

        while (true) {
            try {
                OUTPUT_VIEW.printPriceMessage();
                String inputPrice = Console.readLine();
                price = LOTTO_PUBLISHER.validationPrice(inputPrice);
                break;
            } catch (IllegalArgumentException e) {}
        }
        return price;
    }

    public List<Lotto> userLotto(int lottoCount) {
        OUTPUT_VIEW.enterMessage();
        OUTPUT_VIEW.printBuyLottoMessage(lottoCount);
        List<Lotto> lottos = LOTTO_PUBLISHER.publishLotto(lottoCount);
        OUTPUT_VIEW.printLottoMessage(lottos);

        return lottos;
    }

    public Lotto getWinNumber() {
        OUTPUT_VIEW.enterMessage();
        List<Integer> winnerNumbers = null;
        while (true) {
            OUTPUT_VIEW.printInsertNumberMessage();
            try {
                String input = removeSpace(Console.readLine());
                String[] inputNumbers = input.split(",");
                winnerNumbers = LOTTO_PUBLISHER.validationWinNumber(inputNumbers);
                break;
            } catch (IllegalArgumentException e) {}
        }
        return new Lotto(winnerNumbers);
    }

    public String removeSpace(String number) {
        if (!number.contains(" ")) {
            return number;
        }
        return number.replace(" ", "");
    }

    public int getBonusNumber(Lotto number) {
        OUTPUT_VIEW.enterMessage();
        int bonusNumber = 0;
        while (true) {
            try {
                OUTPUT_VIEW.printInsertBonusMessage();
                String input = Console.readLine();
                LOTTO_PUBLISHER.validationBonusNumber(number, input);
                break;
            } catch (IllegalArgumentException e) {}
        }
        return bonusNumber;
    }

    public void winnerStatistics(List<Lotto> userLottos, Lotto winLotto, int bonusNumber) {
        OUTPUT_VIEW.enterMessage();
        OUTPUT_VIEW.printWinningMessage();
        OUTPUT_VIEW.printDivisionMessage();
        statistics = new Statistics(userLottos, winLotto, bonusNumber);
        OUTPUT_VIEW.print3NumberMessage(statistics.getThreeNumberMatch());
        OUTPUT_VIEW.print4NumberMessage(statistics.getFourNumberMatch());
        OUTPUT_VIEW.print5NumberMessage(statistics.getFiveNumberMatch());
        OUTPUT_VIEW.print5BonusMessage(statistics.getFiveBonusNumberMatch());
        OUTPUT_VIEW.print6BonusMessage(statistics.getSixNumberMatch());
        OUTPUT_VIEW.printRateOfReturnMessage(statistics.getRateOfReturn(price));
    }

}
