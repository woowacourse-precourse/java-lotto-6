package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import constValue.ConstMessage;
import constValue.ConstNumber;
import constValue.LottoPrize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGame {
    private Integer lottoGameCount;
    private Lotto correctLotto;
    private Integer bonusNumber;
    private List<Lotto> lottos;

    public LottoGame() {
        this.lottos = new ArrayList<>();
        System.out.println("구입금액을 입력해 주세요.");
        setLottoGameCount(enterPurchaseAmount());
        addLottos(getLottoGameCount());
        System.out.println(getLottoGameCount() + "개를 구매했습니다.");
        printLottos();
        System.out.println("당첨 번호를 입력해 주세요.");
        this.correctLotto = enterCorrectNumber();
        System.out.println("보너스 번호를 입력해 주세요.");
        this.bonusNumber = enterBonusNumber();
        printResult(calculateResult());
    }

    private Integer enterPurchaseAmount() {
        try {
            return Integer.parseInt(validatePurchaseAmount(Console.readLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return enterPurchaseAmount();
        }
    }

    private Lotto enterCorrectNumber() {
        try {
            return new Lotto(stringToIntegerList(validateCorrectNumber(Console.readLine())));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return enterCorrectNumber();
        }
    }

    public Integer enterBonusNumber() {
        try {
            return Integer.parseInt(validateBonusNumber(Console.readLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return enterBonusNumber();
        }
    }

    private String validatePurchaseAmount(String purchaseAmount) throws IllegalArgumentException {
        if (purchaseAmount.matches("[1-9]+000")) {
            return purchaseAmount;
        }
        throw new IllegalArgumentException(ConstMessage.PURCHASE_AMOUNT_INPUT_ERROR_MESSAGE.getMessage());
    }

    private String validateCorrectNumber(String correctNumber) throws IllegalArgumentException {
        if (correctNumber.split(",").length != 6) {
            throw new IllegalArgumentException(ConstMessage.CORRECT_NUMBER_INPUT_COUNT_ERROR_MESSAGE.getMessage());
        }
        if (Arrays.stream(correctNumber.split(","))
                .filter(number -> Integer.parseInt(number) > 45 || Integer.parseInt(number) < 1).count() > 0) {
            throw new IllegalArgumentException(ConstMessage.NUMBER_INPUT_RANGE_ERROR_MESSAGE.getMessage());
        }
        return correctNumber;
    }

    private String validateBonusNumber(String bonusNumber) throws IllegalArgumentException {
        if (bonusNumber.matches("[^1-9]+") || Integer.parseInt(bonusNumber) > 45
                || Integer.parseInt(bonusNumber) < 1) {
            throw new IllegalArgumentException(ConstMessage.NUMBER_INPUT_RANGE_ERROR_MESSAGE.getMessage());
        }
        if (this.correctLotto.findNumber(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ConstMessage.BONUS_NUMBER_INPUT_ERROR_MESSAGE.getMessage());
        }
        return bonusNumber;
    }

    private Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(ConstNumber.MINIMUM_LOTTO_NUMBER.getValue(),
                ConstNumber.MAXIMUM_LOTTO_NUMBER.getValue(),
                ConstNumber.LOTTO_NUMBER_COUNT.getValue()));
    }

    private Integer getLottoGameCount() {
        return this.lottoGameCount;
    }

    private void setLottoGameCount(Integer lottoGameCount) {
        this.lottoGameCount = lottoGameCount / ConstNumber.LOTTO_PRICE.getValue();
    }

    private List<Lotto> getLottos() {
        return this.lottos;
    }

    private void addLottos(Integer lottoGameCount) {
        for (int index = 0; index < lottoGameCount; index++) {
            this.lottos.add(createLotto());
        }
    }

    private void printLottos() {
        for (Lotto lotto : this.lottos) {
            System.out.println(lotto.toString());
        }
    }

    private List<Integer> stringToIntegerList(String correctNumber) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : correctNumber.split(",")) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    private void printResult(Integer[] results) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(ConstMessage.FIFTH_PRIZE_MESSAGE.getMessage() + results[4] + "개");
        System.out.println(ConstMessage.FOURTH_PRIZE_MESSAGE.getMessage() + results[3] + "개");
        System.out.println(ConstMessage.THIRD_PRIZE_MESSAGE.getMessage() + results[2] + "개");
        System.out.println(ConstMessage.SECOND_PRIZE_MESSAGE.getMessage() + results[1] + "개");
        System.out.println(ConstMessage.FIRST_PRIZE_MESSAGE.getMessage() + results[0] + "개");
        System.out.println("총 수익률은 " + calculateBenefitRate(results) + "%입니다.");
    }

    private Integer[] calculateResult() {
        Integer[] results = new Integer[ConstNumber.RESULT_ARRAY_SIZE.getValue()];
        Arrays.fill(results, 0);

        for (Lotto lotto : getLottos()) {
            Integer index = lotto.calculateGrade(this.correctLotto, this.bonusNumber) - 1;
            if (index > 0 && index < results.length) {
                results[index]++;
            }
        }

        return results;
    }

    private String calculateBenefitRate(Integer[] results) {
        Double sum = 0.0;
        Integer purchaseAmount = getLottoGameCount() * ConstNumber.LOTTO_PRICE.getValue();

        for(LottoPrize prize : LottoPrize.values()){
            sum += results[prize.getGrade()-1] * prize.getValue();
        }

        Double benefitRate = Math.round(sum/purchaseAmount * 1000) / 10.0;

        return String.format("%.1f", benefitRate);
    }
}
