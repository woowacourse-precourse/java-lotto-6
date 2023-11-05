package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LottoController {
    public void run() {
        Output output = new Output();

        LottoCost lottoCost = createLottoCost();
        int lottoTicket = lottoCost.getTicket();
        output.printNumberOfPurchase(lottoTicket);

        LottoGenerate lottoGenerate = new LottoGenerate(lottoTicket);
        HashMap<Integer, List<Integer>> randomLottoNumbers = lottoGenerate.getRandomLottoNumbers();
        output.printRandomLottoNumbers(randomLottoNumbers);

        List<Integer> winningNumbers = getWinningNumbers();
    }

    private LottoCost createLottoCost() {
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
        return lottoCost;
    }

    private List<Integer> getWinningNumbers() {
        Input input = new Input();
        List<String> inputWinningNumbers = Arrays.asList(input.winningNumbers().split(","));

        List<Integer> winningNumbers = inputWinningNumbers.stream().map(Integer::valueOf).toList();
        Lotto lotto = new Lotto(winningNumbers);

        return List.of(1);
    }
}
