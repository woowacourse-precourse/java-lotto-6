package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.validator.ValidateBonusNumber;
import lotto.validator.ValidatePurchaseAmount;
import lotto.validator.ValidateWinningNumber;

public class InputView {

    private String console(){
       return Console.readLine();
    }
    public int requestPurchaseAmount(){
        String buyerInput = console();
        ValidatePurchaseAmount.validatePurchaseAmount(buyerInput);
        return Integer.parseInt(buyerInput);
    }

    public List<Integer> requestWinningNumber(){
        String buyerInput = console();
        ValidateWinningNumber.validateWinningNumber(buyerInput);
        return Arrays.stream(buyerInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int requestBonusNumber(){
        String buyerInput = console();
        ValidateBonusNumber.validateBonusNumber(buyerInput);
        return Integer.parseInt(buyerInput);
    }
}
