package lotto.controller;

import lotto.dto.LottoDrawNumbersEnter;
import lotto.dto.PriceEnter;
import lotto.model.LottoBuySystem;
import lotto.model.LottoDrawSystem;
import lotto.utils.Utils;
import lotto.view.LottoView;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.utils.Constants.*;

public class LottoController {
    private final LottoBuySystem lottoBuySystem;
    private final LottoDrawSystem lottoDrawSystem;
    private final LottoView view;

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
        this.view.printBuyedLottosCount(lottosCount);

        int[][] lottosNumbers = lottoBuySystem.getLottosNumbers();
        for(int[] lottoNumbers: lottosNumbers) {
            this.view.printLottoNumbers(lottoNumbers);
        }
        this.view.newLine();
    }

    public void setWinningNumbers() {
        String numbers = this.enterLottoDrawNumbers();
        lottoDrawSystem.setNumbers(numbers);
    }

    public void compareLottos() {
        this.view.printDrawSummaryTitle();

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
        PriceEnter dto = new PriceEnter("", false);

        while (!dto.isInputValid()) {
            _enterPrice(dto);
        }

        return dto.getPrice();
    }




    private String enterLottoDrawNumbers() {
        boolean validInput = false;
        String numbers = "";
        String bonusNumber = "";

        LottoDrawNumbersEnter dto = new LottoDrawNumbersEnter(numbers, bonusNumber, validInput);

        while (!dto.isValidInput()) {
            _enterLottoDrawNumbers(dto);
        }
        return String.join(SEPERATOR, dto.getNumbers(), dto.getBonusNumber());
    }

    private String enterLottoDrawWiningNumbers() {
        this.view.printEnterLottoWinningNumbers();
        return readLine();
    }

    private String enterLottoDrawBonusNumber() {
        this.view.printEnterBonusNumber();
        return readLine();
    }

    private void _enterLottoDrawNumbers(LottoDrawNumbersEnter dto) {
        dto.setNumbers(enterLottoDrawWiningNumbers());
        dto.setBonusNumber(enterLottoDrawBonusNumber());
        String fullInput = String.join(SEPERATOR, dto.getNumbers(), dto.getBonusNumber());

        try {
            lottoDrawSystem.validateNumbers(fullInput);
            dto.setValidInput(true);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void _enterPrice(PriceEnter dto) {
        this.view.printEnterLottosCount();
        try {
            String price = readLine();
            dto.setPrice(price);
            lottoBuySystem.validatePrice(dto.getPrice());

            dto.setInputValid(true);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


}
