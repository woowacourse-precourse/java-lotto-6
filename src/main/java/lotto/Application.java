package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Application {

    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int buyAmount = inputBuyAmount();
        List<Lotto> lottos = generateRandomLottoTickets(buyAmount);

        printLottoTickets(lottos);

        LottoResult result = playLottoGame(lottos);
        printGameResults(result);
    }

    public static void printGameResults(LottoResult result) {

    }

    public static LottoResult playLottoGame(List<Lotto> lottos) {
        return null;
    }

    public static void printLottoTickets(List<Lotto> lottos) {

    }

    public static List<Lotto> generateRandomLottoTickets(int buyAmount) {
        int buyLottoNumber = buyAmount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyLottoNumber; i++) {
            lottos.add(generateRandomLottoTicket());
        }
        return lottos;
    }

    public static Lotto generateRandomLottoTicket() {
        List<Integer> numbers = new ArrayList<>();
        int randomNumber;
        for (int i = 0; i < LOTTO_SIZE; i++) {
            do {
                randomNumber = Randoms.pickNumberInRange(1, 45);
            } while (numbers.contains(randomNumber));
            numbers.add(randomNumber);
        }
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);
        return new Lotto(numbers);
    }

    public static int inputBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                String inputBuyAmount = Console.readLine();
                LottoGameValidator.validateInputAmount(inputBuyAmount);
                return Integer.parseInt(inputBuyAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
