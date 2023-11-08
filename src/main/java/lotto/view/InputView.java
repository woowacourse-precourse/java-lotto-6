package lotto.view;

import static lotto.view.LottoConsole.*;
import static lotto.view.LottoConstants.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.PurchasePrice;

public class InputView {
    public PurchasePrice readPurchasePrice() {
        print(MSG_PURCHASE_MONEY_PROMPT);
        int price = Integer.parseInt(Console.readLine());
        return new PurchasePrice(price);
    }

    public Lotto readWinningNumbers() {
        System.out.println(LottoConstants.MSG_WINNING_NUMBERS_PROMPT);
        String line = Console.readLine();
        List<Integer> winningNumbers = Arrays.stream(line.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(winningNumbers);
    }
    public int readBonusNumber() {
        System.out.println(LottoConstants.MSG_BONUS_NUMBER_PROMPT);
        return Integer.parseInt(Console.readLine());
    }


}
