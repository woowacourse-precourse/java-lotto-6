package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningLotto;
import lotto.global.ResponseStatus;
import lotto.global.error.ErrorMessage;
import lotto.utils.NumberHandler;

import java.util.Arrays;
import java.util.List;

public class LottoInput {

    private static final String PURCHASE_MESSAGE = "구입금액을 입려해 주세요.";
    private static final String WINNING_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public LottoInput(){
    }

    public int lottoPurchaseInput(){
        System.out.println(PURCHASE_MESSAGE);
        return NumberHandler.parseLottoPurchase(Console.readLine());
    }

    public WinningLotto winningLottoInput(){
        System.out.println(WINNING_LOTTO_MESSAGE);
        List<Integer> lottoNumbers = parseByComma(Console.readLine()).stream()
                .mapToInt(NumberHandler::parseLottoNumber)
                .boxed().toList();
        InputValidator.lottoLengthCheck(lottoNumbers);
        System.out.println();

        System.out.println(BONUS_NUMBER_MESSAGE);
        int bonusNumber = NumberHandler.parseLottoNumber(Console.readLine());
        System.out.println();
        return new WinningLotto(lottoNumbers, bonusNumber);
    }

    private List<String> parseByComma(String input){
        List<String> parsedInput = Arrays.stream(input.split(",")).map(String::trim).toList();
        InputValidator.lottoNumbersEmptyCheck(parsedInput);
        parsedInput.forEach(InputValidator::isInputValid);
        return parsedInput;
    }

    private boolean handleInputValid(ResponseStatus responseStatus){
        if(ResponseStatus.BAD == responseStatus) {
            return false;
        }
        if(ResponseStatus.ERROR == responseStatus){
            throw new RuntimeException(ErrorMessage.INTERNAL_SERVER_ERROR.getMessage());
        }
        return true;
    }
}
