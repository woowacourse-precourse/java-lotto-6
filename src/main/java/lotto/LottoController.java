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
    public static final int LOTTO_PRICE = 1000;
    public static final int MIN_NUMBER_LOTTO = 1;
    public static final int MAX_NUMBER_LOTTO = 45;
    public static final int COUNT_OF_LOTTO = 6;
    public Statistics statistics;
    public int price;

    public void run() {
        price = buyLotto();
        int lottoCount = getLottoCount(price);

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
                price = validationPrice(inputPrice);
                break;
            } catch (IllegalArgumentException e) {}
        }
        return price;
    }

    private int validationPrice(String inputPrice) {
        int price = 0;

        Error.CHECK.isAllInteger(inputPrice);
        price = Integer.parseInt(inputPrice);
        Error.CHECK.isUnder1000Price(price);

        return price;
    }

    public int getLottoCount(int price) {
        return price / LOTTO_PRICE;
    }

    public List<Lotto> userLotto(int lottoCount) {
        OUTPUT_VIEW.enterMessage();
        OUTPUT_VIEW.printBuyLottoMessage(lottoCount);
        List<Lotto> lottos = publishLotto(lottoCount);
        OUTPUT_VIEW.printLottoMessage(lottos);

        return lottos;
    }

    public List<Lotto> publishLotto(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottoCount > 0) {
            List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(MIN_NUMBER_LOTTO, MAX_NUMBER_LOTTO, COUNT_OF_LOTTO);
            List<Integer> lotto = new ArrayList<>(randomNumber);
            Collections.sort(lotto);
            lottos.add(new Lotto(lotto));
            lottoCount--;
        }
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
                winnerNumbers = validationWinNumber(inputNumbers);
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

    public List<Integer> validationWinNumber(String[] inputNumbers) {
        Error.CHECK.isAllInteger(inputNumbers);
        List<Integer> winnerNumbers = arrayToList(stringArrayToInteger(inputNumbers));
        Error.CHECK.isCollect6Number(winnerNumbers);
        Error.CHECK.isRange45(winnerNumbers);
        Error.CHECK.isDuplicate(winnerNumbers);
        return winnerNumbers;
    }

    public int[] stringArrayToInteger(String[] array) {
        return Stream.of(array).mapToInt(Integer::parseInt).toArray();
    }

    public List<Integer> arrayToList(int[] array) {
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }

    public int getBonusNumber(Lotto number) {
        OUTPUT_VIEW.enterMessage();
        int bonusNumber = 0;
        while (true) {
            try {
                OUTPUT_VIEW.printInsertBonusMessage();
                String input = Console.readLine();
                Error.CHECK.isAllInteger(input);
                bonusNumber = Integer.parseInt(input);
                Error.CHECK.isDuplicate(number, bonusNumber);
                Error.CHECK.isRange45(List.of(bonusNumber));
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
