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

    private static final int RETRY = -1;

    public LottoInput(){
    }

    public int lottoPurchaseInput(){
        System.out.println(PURCHASE_MESSAGE);
        int lottoPurchase = RETRY;
        while(lottoPurchase == RETRY){
            try{
                lottoPurchase = NumberHandler.parseLottoPurchase(Console.readLine());
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return lottoPurchase;
    }

    public WinningLotto winningLottoInput(){
        List<Integer> lottoNumbers = getInputWiningLotto();
        int bonusNumber = getInputBonusNumberAndCheckDuplicate(lottoNumbers);
        return new WinningLotto(lottoNumbers, bonusNumber);
    }

    private List<String> parseByComma(String input){
        List<String> parsedInput = Arrays.stream(input.split(",")).map(String::trim).toList();
        InputValidator.lottoNumbersEmptyCheck(parsedInput);
        parsedInput.forEach(InputValidator::isInputValid);
        return parsedInput;
    }

    private List<Integer> getInputWiningLotto(){
        List<Integer> lottoNumbers = null;
        while(lottoNumbers == null){
            try{
                System.out.println(WINNING_LOTTO_MESSAGE);
                lottoNumbers = parseByComma(Console.readLine()).stream()
                        .mapToInt(NumberHandler::parseLottoNumber)
                        .boxed().toList();
                InputValidator.lottoLengthCheck(lottoNumbers);
                InputValidator.lottoNumbersDuplicatedCheck(lottoNumbers);
            }catch(IllegalArgumentException e){
                lottoNumbers = null;
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        return lottoNumbers;
    }

    private int getInputBonusNumberAndCheckDuplicate(List<Integer> lottoNumbers){
        int bonusNumber = RETRY;
        while(bonusNumber == RETRY){
            try{
                System.out.println(BONUS_NUMBER_MESSAGE);
                bonusNumber = NumberHandler.parseLottoNumber(Console.readLine());
                InputValidator.bonusDuplicateCheck(lottoNumbers, bonusNumber);
            }catch(IllegalArgumentException e){
                bonusNumber = RETRY;
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        return bonusNumber;
    }

}
