package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.utils.NumberParser;

import java.util.List;

import static lotto.utils.NumberParser.*;

public class InputServiceImpl implements InputService {
    @Override
    public Lotto inputWinningNumbers (){
        String inputNumber = Console.readLine();
        List<Integer> numbers = toList(inputNumber);
        return new Lotto(numbers);
    }

    @Override
    public BonusNumber inputBonusNumber() {
        String inputBonusNumber = Console.readLine();
        int bonusNumber = toInteger(inputBonusNumber);
        return new BonusNumber(bonusNumber);
    }

    @Override
    public int inputPrice() {
        String inputPrice = Console.readLine();
        int price = toInteger(inputPrice);
        return price;
    }
}
