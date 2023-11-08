package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public UserInput() {

    }

    public int priceInput() {
        String price = Console.readLine();

        return Integer.parseInt(price);
    }

    public String lottoNumbersInput() {
        String lottoNumbers = Console.readLine();

        return lottoNumbers;
    }

    public int lottoBonusInput() {
        String lottoBonus = Console.readLine();

        return Integer.parseInt(lottoBonus);
    }
}
