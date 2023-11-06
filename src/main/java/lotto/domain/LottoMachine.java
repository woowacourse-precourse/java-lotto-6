package lotto.domain;

import static lotto.config.LottoConfig.LOTTO_UNIT_PRICE;
import static lotto.config.LottoConfig.LOTTO_NUMBER_COUNT;
import static lotto.config.LottoConfig.LOTTO_NUMBER_MIN;
import static lotto.config.LottoConfig.LOTTO_NUMBER_MAX;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private final String NUMBER_DELIMITER = ",";
    private final List<Lotto> lottos;
    private int lottosCount;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    private int[] winningDetails;
    private boolean pass;

    public LottoMachine() {
        lottos = new ArrayList<>();
    }

    public void start() {
        setLottosCount(getPurchasePrice());
        setLottos();

        OutputView.printLottoCount(lottosCount);
        OutputView.printLottos(lottos);

        setWinningNumbers();
        setBonusNumber();

        winningDetails = compareLottoNumber();
        System.out.println(Arrays.toString(winningDetails));

        OutputView.printLottoResult(winningDetails);
        OutputView.printLottoProfit(computeProfit());
    }

    private double computeProfit() {
        final int[] PRIZE_MONEY = {30000000, 5000, 50000, 1500000, 2000000000};
        double totalPrize = 0;
        for(int i = 0; i < winningDetails.length; i++){
            totalPrize += (long) winningDetails[i] * PRIZE_MONEY[i];
        }

        return (double) Math.round(totalPrize / (lottosCount * LOTTO_UNIT_PRICE.getNumber()) * 1000) / 10;
    }

    private void setBonusNumber() {
        this.bonusNumber = getBonusNumber();
    }

    private int getBonusNumber() {
        String inputNumber;
        inputNumber = InputView.inputLottoBonusNumber();
        try {
            bonusNumberValidate(inputNumber);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getBonusNumber();
        }
        return Integer.parseInt(inputNumber);
    }

    private void setWinningNumbers() {
        this.winningNumbers = getWinningNumbers();
    }

    private List<Integer> getWinningNumbers() {
        String inputNumbers;
        pass = true;
        do {
            inputNumbers = InputView.inputLottoWinningNumbers();
            try {
                pass = false;
                winningNumbersValidate(inputNumbers);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
                pass = true;
            }
        } while (pass);
        return getIntegerList(inputNumbers, ",");
    }

    private int getPurchasePrice() {
        String inputPrice;
        pass = true;
        do {
            inputPrice = InputView.inputLottoPurchasePrice();
            try {
                pass = false;
                purchasePriceValidate(inputPrice);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
                pass = true;
            }
        } while (pass);
        return Integer.parseInt(inputPrice);
    }

    private void setLottosCount(int purchasePrice) {
        this.lottosCount = purchasePrice / LOTTO_UNIT_PRICE.getNumber();
    }

    private void setLottos() {
        for(int i = 1; i <= lottosCount; i++) {
            pass = true;
            do {
                List<Integer> lottoNumbers = new ArrayList<>(
                        Randoms.pickUniqueNumbersInRange(
                                LOTTO_NUMBER_MIN.getNumber()
                                , LOTTO_NUMBER_MAX.getNumber()
                                , LOTTO_NUMBER_COUNT.getNumber()
                        )
                );
                try {
                    pass = false;
                    Collections.sort(lottoNumbers);
                    Lotto lotto = new Lotto(lottoNumbers);
                    lottos.add(lotto);
                } catch (IllegalArgumentException illegalArgumentException) {
                    System.out.println(illegalArgumentException.getMessage());
                    pass = true;
                }
            } while (pass);
        }
    }

    private void purchasePriceValidate(String inputPrice) {
        if (InputValidator.isNotNumeric(inputPrice)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 금액을 입력했습니다.");
        }
        if (InputValidator.isNotRemainderZero(inputPrice, LOTTO_UNIT_PRICE.getNumber())) {
            throw new IllegalArgumentException("[ERROR] 금액이 맞아떨어지지 않습니다.");
        }
    }


    private void winningNumbersValidate(String inputNumbers) {
        if(InputValidator.isNotMatchNumbersCount(inputNumbers, NUMBER_DELIMITER, LOTTO_NUMBER_COUNT.getNumber())) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 6개가 아닙니다.");
        }
        if(Arrays.stream(inputNumbers.split(NUMBER_DELIMITER)).anyMatch(InputValidator::isNotNumeric)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 번호를 입력했습니다1.");
        }
        if(Arrays.stream(inputNumbers.split(NUMBER_DELIMITER)).anyMatch(n -> InputValidator.isNumberNotInRange(n, LOTTO_NUMBER_MIN.getNumber(), LOTTO_NUMBER_MAX.getNumber()))) {
            throw new IllegalArgumentException("[ERROR] 잘못된 번호를 입력했습니다2.");
        }
        if(InputValidator.isDuplicateNumber(List.of(inputNumbers.split(NUMBER_DELIMITER)))) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 중복 입력되었습니다.");
        }
    }

    private void bonusNumberValidate(String inputNumber) {
        if(InputValidator.isNotNumeric(inputNumber)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 번호를 입력했습니다1.");
        }
        if(InputValidator.isDuplicateNumber(this.winningNumbers, Integer.parseInt(inputNumber))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복 입력되었습니다.");
        }
    }

    private List<Integer> getIntegerList(String inputNumbers, String delimiter) {
        return Arrays.stream(inputNumbers.split(delimiter))
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList());
    }

    private int[] compareLottoNumber() {
        int[] lottoDetails = new int[5];

        lottos.forEach(lotto ->
                {
                    int matchCount = (int) lotto.getNumbers().stream()
                                            .filter(number -> winningNumbers.contains(number))
                                            .count();
                    if(matchCount >= 3) {
                        lottoDetails[matchCount-2]++;
                        if(lottosCount == 5 && lotto.isMatchBonusNumber(bonusNumber)) {
                            lottoDetails[0]++;
                            lottoDetails[matchCount-2]--;
                        }
                    }
                }
        );
        return lottoDetails;
    }


}
