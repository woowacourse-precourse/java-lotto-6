package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LottoController {
    private final Input input = new Input();
    private final Output output = new Output();

    public void run() {
        /*LottoCost lottoCost = createLottoCost();
        int lottoTicket = lottoCost.getTicket();
        output.printNumberOfPurchase(lottoTicket);

        LottoGenerate lottoGenerate = new LottoGenerate(lottoTicket);
        HashMap<Integer, List<Integer>> randomLottoNumbers = lottoGenerate.getRandomLottoNumbers();
        output.printRandomLottoNumbers(randomLottoNumbers);

        Lotto winningNumber = createWinningNumber();*/
        LottoBonus bonusNumber = createBonusNumber();
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

    private LottoBonus createBonusNumber() {
        LottoBonus bonusNumber = null;
        boolean loop = true;

        while (loop) {
            String inputBonusNumber = input.bonusNumber();
            try {
                isNumber(inputBonusNumber);
                bonusNumber = new LottoBonus(Integer.parseInt(inputBonusNumber));
                loop = false;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }

        return bonusNumber;
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

    private void isNumber(String bonusNumber) {
        boolean hasOnlyNum = !bonusNumber.isEmpty() && bonusNumber.chars().allMatch(Character::isDigit);

        if (!hasOnlyNum) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_NOT_NUMBER.getMessage());
        }
    }
}
