package lotto.ui;

import static lotto.constant.GameMessage.INPUT_BONUS_NUMBERS;
import static lotto.constant.GameMessage.INPUT_BUY_PRICE;
import static lotto.constant.GameMessage.INPUT_WIN_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Price;

public class Input {

    public static Price readBuyPrice() {
        while (true) {
            System.out.println(INPUT_BUY_PRICE.getMessage());
            try {
                return new Price(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Lotto readWinningNumbers() {
        while (true) {
            System.out.println(INPUT_WIN_NUMBERS.getMessage());
            try {
                String input = Console.readLine();
                return new Lotto(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Bonus readBonusNumber(Lotto winLotto) {
        while (true) {
            System.out.println(INPUT_BONUS_NUMBERS.getMessage());
            try {
                String input = Console.readLine();
                return new Bonus(input, winLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}