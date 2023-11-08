package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final String PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_QUANTITY_MESSAGE = "개를 구매했습니다.\n";
    private static final int PRICE_PER_QUANTITY = 1000;
    private static final int LOTTO_NUMBER_MINIMUM = 1;
    private static final int LOTTO_NUMBER_MAXIMUM = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public Game() {
    }

    public void play() {
        Integer price = getPriceInput();
        Integer quantity = getPurchaseQuantity(price);
        List<Lotto> lottos = makeLottoNumbers(quantity);
        printPurchasedLotto(lottos);
    }

    public Integer getPriceInput() {
        printMessage(PRICE_INPUT_MESSAGE);
        Integer price = Integer.parseInt(readLine());
        printMessage("");
        return price;
    }

    public Integer getPurchaseQuantity(Integer price) {
        Integer quantity = price / PRICE_PER_QUANTITY;
        printMessage(quantity + PURCHASE_QUANTITY_MESSAGE);
        return quantity;
    }

    public List<Lotto> makeLottoNumbers(Integer quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < quantity; i++){
            Lotto lotto = makeLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    public Lotto makeLotto() {
        List<Integer> randomNumbers = pickUniqueNumbersInRange(LOTTO_NUMBER_MINIMUM, LOTTO_NUMBER_MAXIMUM, LOTTO_NUMBER_COUNT);
        Lotto lotto = new Lotto(randomNumbers);
        return lotto;
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void printPurchasedLotto(List<Lotto> lottos) {
        for(Lotto lotto : lottos){
            System.out.print("[");
            List<Integer> numbers = lotto.getNumbers();
            printNumberList(numbers);
            System.out.println("]");
        }
    }

    private void printNumberList(List<Integer> numbers) {
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            System.out.print(numbers.get(i));
            if (i != numbers.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
