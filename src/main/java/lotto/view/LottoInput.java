package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;

public class LottoInput {

    private static final String PURCHASE_MESSAGE = "구입금액을 입려해 주세요.";

    public LottoInput(){
    }

    public int lottoPurchaseInput(){
        System.out.println(PURCHASE_MESSAGE);
        String lottoPurchasePrice = Console.readLine();
        return Integer.parseInt(lottoPurchasePrice);
    }

    public WinningLotto winningLottoInput(){
        List<Integer> lottoNumbers = parseByComma(Console.readLine()).stream()
                .mapToInt(Integer::parseInt).boxed().toList();
        int bonusNumber = Integer.parseInt(Console.readLine());
        return new WinningLotto(lottoNumbers, bonusNumber);
    }

    private List<String> parseByComma(String input){
        List<String> parsedInput = Arrays.stream(input.split(",")).map(String::trim).toList();
        InputValidator.lottoNumbersEmptyCheck(parsedInput);
        parsedInput.forEach(InputValidator::isInputValid);
        return parsedInput;
    }
}
