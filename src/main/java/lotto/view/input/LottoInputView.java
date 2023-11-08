package lotto.view.input;

import java.util.Arrays;
import java.util.List;
import lotto.exception.Exceptions;
import lotto.view.Prompt;

public class LottoInputView extends InputView {

    @Override
    protected void Validation(String inputMessage) {
        List<String> lotto = Arrays.asList(inputMessage.replace(" ", "").split(","));
        for (String number : lotto) {
            Exceptions.checkIsNumber(number);
        }

        lottoNumbers = lotto.stream().map(Integer::parseInt).toList();
        Exceptions.checkLottoRange(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        getInput(Prompt.ANSWER_OF_LOTTO);
        return lottoNumbers;
    }
}