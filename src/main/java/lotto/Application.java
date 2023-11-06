package lotto;

import lotto.constant.ExceptionMessage;
import lotto.constant.LottoRanking;
import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.dto.LottoAnswer;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static lotto.constant.LottoConstant.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoInputView inputView = new LottoInputView();
        LottoOutputView outputView = new LottoOutputView();

        int userPaid;
        while (true) {
            try {
                outputView.printBuyingPriceInputRequest();
                String input = inputView.getBuyingPrice();
                validateBuyingPrice(input);
                userPaid = Integer.parseInt(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        List<Lotto> userLottos = new ArrayList<>();
        for (int i = 0; i < userPaid / LOTTO_PRICE; i++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generateLottoNumbers());
            userLottos.add(lotto);
        }
        outputView.printBoughtResult(userLottos);

        Lotto winningLotto;
        while (true) {
            try {
                outputView.printAnswerInputRequest();
                String input = inputView.getLottoWinningNumbers();
                List<Integer> numbers = validateIntegers(Arrays.asList(input.split(",")));
                winningLotto = new Lotto(numbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int bonus;
        while (true) {
            try {
                outputView.printBonusInputRequest();
                String input = inputView.getBonusNumber();
                validateBonusNumber(input);
                bonus = Integer.parseInt(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        LottoAnswer answer = new LottoAnswer(winningLotto, bonus);

        Map<LottoRanking, Integer> lottoResult = LottoController.calculateLottoResult(answer, userLottos);
        outputView.printLottoResult(lottoResult);

        int totalPrize = LottoController.calculateTotalPrize(lottoResult);
        outputView.printProfit(userPaid, totalPrize);
    }

    public static List<Integer> validateIntegers(List<String> input) {
        List<Integer> integers = new ArrayList<>();
        if (!LottoUtil.isIntegers(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER);
        }
        for (String s : input) {
            integers.add(Integer.parseInt(s));
        }
        return integers;
    }

    public static void validateBuyingPrice(String input) {
        if (!LottoUtil.isInteger(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BUYING_PRICE);
        }
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException(ExceptionMessage.NEGATIVE_BUYING_PRICE);
        }
        if (Integer.parseInt(input) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.BUYING_PRICE_NOT_DIVISIBLE);
        }
    }

    public static void validateBonusNumber(String input) {
        if (!LottoUtil.isInteger(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_NUMBER);
        }
        if (!LottoUtil.isInRange(Integer.parseInt(input), LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_BONUS_NUMBER);
        }
    }
}
