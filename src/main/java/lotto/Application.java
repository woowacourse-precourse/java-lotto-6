package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int buyAmount = inputBuyAmount();
        List<Lotto> lottos = generateRandomLottoTickets(buyAmount);

        printLottoTickets(lottos);

        LottoResult result = playLottoGame(lottos);
        printGameResults(result);
    }

    private static void printGameResults(LottoResult result) {

    }

    private static LottoResult playLottoGame(List<Lotto> lottos) {
        return null;
    }

    private static void printLottoTickets(List<Lotto> lottos) {

    }

    private static List<Lotto> generateRandomLottoTickets(int buyAmount) {
        return null;
    }

    private static int inputBuyAmount() {
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
