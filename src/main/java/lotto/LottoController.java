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

    public void run() {
        int price = buyLotto();
        int lottoCount = getLottoCount(price);

        List<Lotto> userLottos = userLotto(lottoCount);

        Lotto winLotto = getWinNumber();
    }

    private int buyLotto() {
        OUTPUT_VIEW.printPriceMessage();
        String inputPrice = Console.readLine();
        return validationPrice(inputPrice);
    }

    private int validationPrice(String inputPrice) {
        int price = 0;

        try {
            Error.CHECK.isAllInteger(new String[]{inputPrice});
            price = Integer.parseInt(inputPrice);
            Error.CHECK.isUnder1000Price(price);
        } catch (IllegalArgumentException e) {
            buyLotto();
        }
        return price;
    }

    public int getLottoCount(int price) {
        return price / LOTTO_PRICE;
    }

    public List<Lotto> userLotto(int lottoCount) {
        OUTPUT_VIEW.printBuyLottoMessage(lottoCount);
        List<Lotto> lottos = publishLotto(lottoCount);
        OUTPUT_VIEW.printLottoMessage(lottos);

        return lottos;
    }

    public List<Lotto> publishLotto(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottoCount > 0) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(MIN_NUMBER_LOTTO, MAX_NUMBER_LOTTO, COUNT_OF_LOTTO);
            Collections.sort(lotto);
            lottos.add(new Lotto(lotto));
            lottoCount--;
        }
        return lottos;
    }

    public Lotto getWinNumber() {
        List<Integer> winnerNumbers = null;
        while (true) {
            OUTPUT_VIEW.printInsertNumberMessage();
            try {
                String input = removeSpace(Console.readLine());
                String[] inputNumbers = input.split(",");
                winnerNumbers = validationWinNumber(inputNumbers);
                break;
            } catch (IllegalArgumentException e) {
            }
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

}
