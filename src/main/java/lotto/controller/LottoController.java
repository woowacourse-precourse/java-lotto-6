package lotto.controller;

import lotto.model.LottoBuySystem;
import lotto.model.LottoDrawSystem;
import lotto.view.LottoView;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        // 로또 번호를 뽑고 추첨을 하는 모든 과정을 호출하는 최상단의 함수
        this.buyLottos();
        this.setWinningNumbers();
        this.compareLottos();
    }

    public void buyLottos() {
        String price = this.enterPrice();
        this.view.newLine();

        lottoBuySystem.validatePrice(price);
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
        lottoDrawSystem.validateNumbers(numbers);
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
            System.out.println(message + " - " + gradesCount[i] + "개");
        }

        int totalPrice = this.lottoBuySystem.getLottosCount()*LOTTO_PRICE;
        int totalProfilt = 0;
        for(int grade: grades) {
            totalProfilt += this.lottoDrawSystem.getMoney(grade);
        }

        BigDecimal biTotalPrice = new BigDecimal(totalPrice);
        BigDecimal biTotalProfit = new BigDecimal(totalProfilt);

        BigDecimal profit = (biTotalProfit.divide(biTotalPrice, 4, RoundingMode.HALF_DOWN)).multiply(new BigDecimal(100));

        System.out.println("총 수익률은 " + profit + "%");
    }


    private String enterPrice() {
        this.view.printEnterLottosCount(); // 구입금액을 입력해 주세요.
        return readLine();
    }

    private String enterLottoDrawNumbers() {
        this.view.printEnterLottoWinningNumbers(); // 당첨 번호를 입력해 주세요.
        String numbers = readLine();
        this.view.newLine();

        this.view.printEnterBonusNumber(); // 보너스 번호를 입력해 주세요.
        String bonusNumber = readLine();
        this.view.newLine();

        return String.join(SEPERATOR, numbers, bonusNumber);
    }
}
