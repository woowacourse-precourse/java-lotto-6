package lotto.domain.handler.input;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.event.LottoMessageBroker;
import lotto.domain.event.LottoGameStart;
import lotto.domain.event.input.BonusNumber;
import lotto.domain.event.input.Lotto;
import lotto.domain.event.input.MoneyInputRequested;
import lotto.domain.event.output.TicketsCreated;
import lotto.exception.LottoExceptionType;
import lotto.domain.event.input.BonusNumberInputRequested;
import lotto.domain.event.input.LottoInputRequested;
import lotto.exception.LottoValidateException;
import lotto.util.input.InputRetryHandler;
import lotto.util.LottoNumberFormatter;
import lotto.util.LottoValidate;

public class LottoInputEventHandler {

    private final Reader<String> reader;

    private final LottoMessageBroker lottoMessageBroker;

    public LottoInputEventHandler(LottoMessageBroker lottoMessageBroker, Reader<String> reader) {
        this.reader = reader;
        this.lottoMessageBroker = lottoMessageBroker;
    }


    /**
     * 원시값에 유효성 검사를 받은 뒤 이벤트를 생성하는 public 메서드들입니다.
     */
    public void requestLottoNumbers(TicketsCreated ticketsCreated) {
        Lotto lotto = InputRetryHandler.retryUntilValidInput(this::readValidatedLottoNumbers, this::createLotto);
        lottoMessageBroker.enqueue(new LottoInputRequested(lotto, ticketsCreated));
    }

    public void requestLottoMoney(LottoGameStart lottoGameStart) {
        System.out.println(lottoGameStart.startMessage());
        MoneyInputRequested money = InputRetryHandler.retryUntilValidInput(this::readValidatedMoney, this::createMoney);
        lottoMessageBroker.enqueue(money);
    }

    public void requestBonusLottoNumber(LottoInputRequested lottoInputReceive) {
        BonusNumber bonusNumber = InputRetryHandler.retryUntilValidInput(this::readValidatedNumber,
                this::createBonusNumber);
        lottoMessageBroker.enqueue(new BonusNumberInputRequested(lottoInputReceive, bonusNumber));
    }

    private int readValidatedNumber() {
        int input = validateAndParse(reader.read());
        LottoValidate.validateBonusNumber(input);
        return input;
    }

    private BonusNumber createBonusNumber(int bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    private MoneyInputRequested createMoney(Integer lottoMoney) {
        return new MoneyInputRequested(lottoMoney);
    }

    private Integer readValidatedMoney() {
        Integer lottoMoney = validateAndParse(reader.read());
        LottoValidate.validateLottonMoney(lottoMoney);
        return lottoMoney;
    }

    private Lotto createLotto(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new));
    }

    private List<Integer> readValidatedLottoNumbers() {
        List<Integer> lottoNumbers = LottoNumberFormatter.splitByComma(reader.read())
                .stream()
                .map(this::validateAndParse)
                .collect(Collectors.toList());

        LottoValidate.validateLottoNumbers(lottoNumbers);
        return lottoNumbers;
    }

    private Integer validateAndParse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new LottoValidateException(LottoExceptionType.NUMBER_FORMAT_ERROR_MESSAGE.getMessage());
        }
    }
}
