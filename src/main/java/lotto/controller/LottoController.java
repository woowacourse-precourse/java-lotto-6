package lotto.controller;

import lotto.model.LottoBuySystem;
import lotto.model.LottoDrawSystem;
import lotto.utils.Utils;
import lotto.view.LottoView;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.utils.Constants.*;

public class LottoController {
    private LottoBuySystem lottoBuySystem;
    private LottoDrawSystem lottoDrawSystem;
    private LottoView view;

    public LottoController(LottoBuySystem givenLottoBuySystem, LottoDrawSystem givenLottoDrawSystem, LottoView givenView) {
        this.lottoBuySystem = givenLottoBuySystem;
        this.lottoDrawSystem = givenLottoDrawSystem;
        this.view = givenView;
    }

    public void run() {
        this.buyLottos();
        this.setWinningNumbers();
        this.compareLottos();
    }

    public void buyLottos() {
        String price;
        price = this.enterPrice();

        lottoBuySystem.buyLottos(price);

        int lottosCount = lottoBuySystem.getLottosCount();
        this.view.printBuyedLottosCount(lottosCount); // lottosCount + 개를 구매했습니다.

        int[][] lottosNumbers = lottoBuySystem.getLottosNumbers();
        for(int[] lottoNumbers: lottosNumbers) {
            this.view.printLottoNumbers(lottoNumbers); // [1, 2, 3, 4, 5]
        }
        this.view.newLine();
    }

    public void setWinningNumbers() {
        String numbers = this.enterLottoDrawNumbers();
        lottoDrawSystem.setNumbers(numbers);
    }

    public void compareLottos() {
        this.view.printDrawSummaryTitle(); // 당첨 통계\n--

        int[] grades = Arrays.stream(this.lottoBuySystem.getLottosNumbers())
                .map((lottoNumbers) -> this.lottoDrawSystem.draw(lottoNumbers))
                .mapToInt(grade -> grade).toArray();

        int[] gradesCount = new int[LOTTO_DRAW_NUMBER_COUNT];
        for(int grade: grades) {
            gradesCount[grade] += 1;
        }

        for(int i=1; i<LOTTO_DRAW_NUMBER_COUNT; i++) {
            String message = this.lottoDrawSystem.getMessage(i);
            this.view.printResult(message, gradesCount[i]);
        }

        int totalPrice = this.lottoBuySystem.getLottosCount()*LOTTO_PRICE;
        int totalProfilt = 0;
        for(int grade: grades) {
            totalProfilt += this.lottoDrawSystem.getMoney(grade);
        }

        String profitRate = Utils.getPercentage(totalProfilt, totalPrice);

        this.view.printProfitRate(profitRate);
    }



    private String enterPrice() {
        String res = "";
        boolean isValidInput = false;

        while (!isValidInput) {
            this.view.printEnterLottosCount();
            try {
                res = readLine();
                lottoBuySystem.validatePrice(res);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return res;
    }



    private String enterLottoDrawNumbers() {
        boolean validInput = false;
        String numbers = "";
        String bonusNumber = "";

        while (!validInput) {
            numbers = enterLottoDrawWiningNumbers();
            bonusNumber = enterLottoDrawBonusNumber();
            String fullInput = String.join(SEPERATOR, numbers, bonusNumber);

            try {
                lottoDrawSystem.validateNumbers(fullInput);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return String.join(SEPERATOR, numbers, bonusNumber);
    }

    private String enterLottoDrawWiningNumbers() {
        this.view.printEnterLottoWinningNumbers();
        return readLine();
    }

    private String enterLottoDrawBonusNumber() {
        this.view.printEnterBonusNumber();
        return readLine();
    }

}
