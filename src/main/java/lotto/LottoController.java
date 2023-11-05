package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LottoController {
    private final Input input = new Input();
    private final Output output = new Output();

    public void run() {
        LottoCost lottoCost = createLottoCost();
        int lottoTicket = lottoCost.getTicket();
        output.printNumberOfPurchase(lottoTicket);

        LottoGenerate lottoGenerate = new LottoGenerate(lottoTicket);
        HashMap<Integer, List<Integer>> randomLottoNumbers = lottoGenerate.getRandomLottoNumbers();
        output.printRandomLottoNumbers(randomLottoNumbers);

        Lotto winningNumber = createWinningNumber();
        LottoBonus bonusNumber = createBonusNumber(winningNumber);
    }

    private LottoCost createLottoCost() {
        LottoCost lottoCost = null;
        boolean loop = true;

        while (loop) {
            String cost = input.buyLotto();
            try {
                lottoCost = new LottoCost(toNumber(cost));
                loop = false;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }

        return lottoCost;
    }

    private int toNumber(String inputValue) {
        isNumber(inputValue);
        return Integer.parseInt(inputValue);
    }

    private void isNumber(String number) {
        boolean hasOnlyNum = !number.isEmpty() && number.chars().allMatch(Character::isDigit);

        if (!hasOnlyNum) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_NOT_NUMBER.getMessage());
        }
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

    public void isNumber(List<String> numbers) {
        boolean hasOnlyNum;

        for (String number : numbers) {
            hasOnlyNum = !number.isEmpty() && number.chars().allMatch(Character::isDigit);
            if (!hasOnlyNum) {
                throw new IllegalArgumentException(ErrorMessages.ERROR_NOT_NUMBER.getMessage());
            }
        }
    }

    private LottoBonus createBonusNumber(Lotto lotto) {
        LottoBonus bonusNumber = null;
        boolean loop = true;

        while (loop) {
            String inputBonusNumber = input.bonusNumber();
            try {
                hasSameNumberBetweenWinningAndBonusNumber(lotto, inputBonusNumber);
                bonusNumber = new LottoBonus(Integer.parseInt(inputBonusNumber));
                loop = false;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }

        return bonusNumber;
    }

    private void hasSameNumberBetweenWinningAndBonusNumber(Lotto lotto, String bonusNumber) {
        if (lotto.getLotto().contains(toNumber(bonusNumber))) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_BOUS_NUMBER_DUPLICATE.getMessage());
        }
    }
}
