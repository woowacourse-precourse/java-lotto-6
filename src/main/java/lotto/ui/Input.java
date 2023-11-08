package lotto.ui;

import static lotto.global.common.GameMessage.BONUS_NUMBER_MESSAGE;
import static lotto.global.common.GameMessage.PURCHASE_PRICE_MESSAGE;
import static lotto.global.common.GameMessage.WINNING_NUMBERS_MESSAGE;
import static lotto.global.common.LottoConstant.LOTTO_TICKET_PRICE;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.global.Validator;

public class Input {

    private final static String SEPARATOR = ",";
    private String input;
    private List<String> winningNumbers;

    public int purchasePrice() {
        boolean isValid = false;

        while (!isValid) {
            try {
                readPurchasePrice();
                isValid = Validator.purchasePriceFormat(this.input);

            } catch (IllegalArgumentException e) {
                System.out.print("[ERROR] " + e.getMessage());
            }
        }

        return getLottoTicketsNumber();
    }

    public void winningNumbers() {
        boolean isValid = false;

        while (!isValid) {
            try {
                readWinningNumbers();
                isValid = Validator.lottoNumbersWithString(this.winningNumbers);

            } catch (IllegalArgumentException e) {
                System.out.print("[ERROR] " + e.getMessage());
            }
        }
    }

    public void BonusNumber() {
        boolean isValid = false;

        while (!isValid) {
            try {
                readBonusNumber();
                isValid = Validator.bonusNumber(this.input, this.winningNumbers);

            } catch (IllegalArgumentException e) {
                System.out.print("[ERROR] " + e.getMessage());
            }
        }

        this.winningNumbers.add(this.input); // 당첨 번호에 보너스 번호도 추가
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void readPurchasePrice() {
        System.out.print(PURCHASE_PRICE_MESSAGE.message);
        this.input = Console.readLine().trim();
    }

    private void readWinningNumbers() {
        System.out.print(WINNING_NUMBERS_MESSAGE.message);
        this.input = Console.readLine().trim();

        this.winningNumbers = new ArrayList<>(List.of(this.input.split(SEPARATOR)));
    }

    private void readBonusNumber() {
        System.out.print(BONUS_NUMBER_MESSAGE.message);
        this.input = Console.readLine().trim();
    }

    private int getLottoTicketsNumber() {
        return Integer.parseInt(this.input) / LOTTO_TICKET_PRICE;
    }
}
