package lotto;

import java.util.Arrays;
import java.util.List;

public class LottoController {
    public void run() {
        Output output = new Output();

        int lottoTicket = getNumberOfTicket();

        output.printNumberOfPurchase(lottoTicket);

        output.printRandomLottoNumbers(lottoTicket);

        List<Integer> winningNumbers = getWinningNumbers();
    }

    private int getNumberOfTicket() {
        Input input = new Input();
        String cost;
        LottoCost lottoCost = null;
        boolean loop = true;

        while (loop) {
            cost = input.buyLotto();
            try {
                lottoCost = new LottoCost(cost);
                loop = false;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
        return lottoCost.getTicket();
    }

    private List<Integer> getWinningNumbers() {
        Input input = new Input();
        List<String> inputWinningNumbers = Arrays.asList(input.winningNumbers().split(","));

        List<Integer> winningNumbers = inputWinningNumbers.stream().map(Integer::valueOf).toList();
        Lotto lotto = new Lotto(winningNumbers);

        return List.of(1);
    }
}
