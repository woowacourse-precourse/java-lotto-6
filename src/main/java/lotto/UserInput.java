package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UserInput {
    public UserInput() {

    }
    Converter converter = new Converter();

    public int priceInput() {
        String price = Console.readLine();

        return Integer.parseInt(price);
    }

    public List<Integer> lottoNumbersInput() {
        String lottoNumbersNotConvert = Console.readLine();
        List<Integer> lottoNumbers = converter.convertLottoNumbersInput(lottoNumbersNotConvert);

        return lottoNumbers;
    }

    public int lottoBonusInput() {
        String lottoBonus = Console.readLine();

        return Integer.parseInt(lottoBonus);
    }
}
