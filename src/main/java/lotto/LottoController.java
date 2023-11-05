package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LottoController {
    final Input input = new Input();
    final Output output = new Output();

    public void run() {
        LottoCost lottoCost = createLottoCost();
        int lottoTicket = lottoCost.getTicket();
        output.printNumberOfPurchase(lottoTicket);

        LottoGenerate lottoGenerate = new LottoGenerate(lottoTicket);
        HashMap<Integer, List<Integer>> randomLottoNumbers = lottoGenerate.getRandomLottoNumbers();
        output.printRandomLottoNumbers(randomLottoNumbers);

        Lotto lotto = createWinningNumber();
    }

    private LottoCost createLottoCost() {
        LottoCost lottoCost = null;
        boolean loop = true;

        while (loop) {
            String cost = input.buyLotto();
            try {
                lottoCost = new LottoCost(cost);
                loop = false;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }

        return lottoCost;
    }

    private Lotto createWinningNumber() {
        Lotto lotto = null;
        boolean loop = true;

        while (loop) {
            List<String> inputWinningNumbers = Arrays.asList(input.winningNumbers().split(Config.SPLIT_SYMBOL));
            System.out.println(inputWinningNumbers);
            try {
                isNumber(inputWinningNumbers);
                lotto = new Lotto(inputWinningNumbers.stream().map(Integer::valueOf).toList());
                loop = false;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }

        return lotto;
    }

    public void isNumber(List<String> inputWinningNumbers) {
        boolean hasOnlyNum;

        for (String number : inputWinningNumbers) {
            hasOnlyNum = !number.isEmpty() && number.chars().allMatch(Character::isDigit);
            if (!hasOnlyNum) {
                throw new IllegalArgumentException(ErrorMessages.ERROR_NOT_NUMBER.getMessage());
            }
        }
    }
}
