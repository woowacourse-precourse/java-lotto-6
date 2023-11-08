package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.mockito.internal.matchers.GreaterThan;

public class LottoController {
    private final int lottoPrice = 1000;
    private static final String ERROR_INPUT_NUMBER = "[ERROR]숫자를 입력해 주세요.";
    private static final String ERROR_INPUT_UNIT_1000 = "[ERROR]금액은 1,000원 단위로 입력해 주세요.";
    private static final String ERROR_INPUT_6_NUMBER = "[ERROR]당첨 번호는 6개의 숫자를 입력해주세요.";
    private static final String ERROR_INPUT_BONUS_NUMBER_RANGE = "[ERROR]보너스 번호는 1~45 사이의 숫자 하나만 입력해 주세요.";
    private static final String ERROR_INPUT_WINNING_NUMBER_RANGE = "[ERROR]당첨 번호는 1~45 사이의 숫자를 , 구분자를 사용해서 입력해주세요.";

    private int purchaseQuantity;
    private int purchaseMoney;
    private boolean checkInitPurchaseQuantity = true;
    private boolean checkInitWinningNumber = true;
    private boolean checkBonusNumber = true;
    private Lottos lottos;
    private WinningNumber winningNumber;


    public void start() {
        while (checkInitPurchaseQuantity) {
            initPurchaseQuantity(); // 구매 수량 초기화
        }
        System.out.println();
        outputPurchaseQuantity(); // 구매 수량 출력
        makeLottos(); // 로또 생성
        printLotto(); // 생성한 로또 출력
        System.out.println();

        while (checkInitWinningNumber) {
            initWinningNumber(); // 당첨 번호 초기화
        }

        while (checkBonusNumber) {
            initBonusNumber();
        }
        calculateStatistics();
    }

    public void calculateStatistics() {
        StatisticsController statisticsController = new StatisticsController(lottos, winningNumber, purchaseMoney);
        statisticsController.process();
    }

    public void initPurchaseQuantity() {
        try {
            String input = InputView.inputAmountOfMoney();
            validateInputMoney(input);
            calculateQuantity(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void initWinningNumber() {
        try {
            String winningNumber = InputView.inputWinningNumber();
            validateWinningNumbers(winningNumber);
            System.out.println();
            saveWinningNumber(winningNumber);
            checkInitWinningNumber = false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void initBonusNumber() {
        try {
            String bonusNumber = InputView.inputBonusNumber();
            validateBonusNumber(bonusNumber);
            saveBonusNumber(bonusNumber);

            checkBonusNumber = false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveWinningNumber(String number) {
        winningNumber = new WinningNumber();
        String[] split = number.split(",");
        List<Integer> integers = Arrays.stream(split).map(Integer::parseInt).toList();
        validateWinningNumberLength(integers.size());
        winningNumber.setWinningNumbers(integers); // 클래스에 저장.
    }

    public void saveBonusNumber(String number) {
        int num = Integer.parseInt(number);
        winningNumber.setBonusNumber(num);
    }


    private void calculateQuantity(String input) { // 로또 구매 수량 계산.
        try {
            purchaseMoney = Integer.parseInt(input);
            validatePurchaseQuantity(purchaseMoney);
            purchaseQuantity = purchaseMoney / lottoPrice;
            checkInitPurchaseQuantity = false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void outputPurchaseQuantity() {
        OutputView.printPurchaseQuantity(purchaseQuantity);
    }

    public void makeLottos() {
        Lotto lotto;
        lottos = new Lottos();
        for (int i = 0; i < purchaseQuantity; i++) {
            List<Integer> randomNumbers = generateRandomNumber();
            lotto = new Lotto(randomNumbers);
            lottos.addLotto(lotto);
        }
    }

    public void printLotto() {
        lottos.printLottosNumbers();
    }

    public List<Integer> generateRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 24, 6);
        return numbers;
    }

    public void validateInputMoney(String input) {
        String regex = "^[0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.find()) {
            checkInitPurchaseQuantity = true;
            throw new IllegalArgumentException(ERROR_INPUT_NUMBER);
        }
    }

    public void validatePurchaseQuantity(int money) {
        if (money == 0 || money % 1000 != 0) {
            checkInitPurchaseQuantity = true;
            throw new IllegalArgumentException(ERROR_INPUT_UNIT_1000);
        }
    }

    public void validateWinningNumberLength(int size) {
        if (size != 6) {
            throw new IllegalArgumentException(ERROR_INPUT_6_NUMBER);
        }

    }

    public void validateBonusNumber(String number) {
        String regex = "^(?:[1-9]|[1-3][0-9]|4[0-5])$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        if (!matcher.find()) {
            throw new IllegalArgumentException(ERROR_INPUT_BONUS_NUMBER_RANGE);
        }
    }

    public void validateWinningNumbers(String number) {
        String regex = "^(?:[1-9]|[1-3][0-9]|4[0-5])(?:,(?:[1-9]|[1-3][0-9]|4[0-5]))*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        if (!matcher.find()) {
            throw new IllegalArgumentException(ERROR_INPUT_WINNING_NUMBER_RANGE);
        }
    }


}
