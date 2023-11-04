package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Supplier;
import lotto.domain.ComputeLottoGenerator;
import lotto.domain.Lotto;
import lotto.domain.LottoBonusNumber;
import lotto.domain.LottoFactory;
import lotto.domain.Price;
import lotto.domain.Quantity;
import lotto.view.LottoInputView;

public class LottoController {

    public static final String PREFIX = "[ERROR]" + " ";
    private final LottoInputView lottoInputView;


    public LottoController(LottoInputView lottoInputView) {
        this.lottoInputView = lottoInputView;
    }

    // 가격을 입력받아 복권 갯수만큼 복권 출력
    public void executePayment() {
        lottoInputView.priceInfoLog();
        Price price = initValidInputReadLine(() -> new Price(Console.readLine()));

        Quantity quantity = initValidInputReadLine(() -> new Quantity(price));
        lottoInputView.purchaseInfoLog(quantity.getQuantity());
        new ComputeLottoGenerator(quantity).generatorLottoList()
                .forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    // 로또번호 + 보너스 번호 입력받기
    public Lotto enterLottoNumber() {
        lottoInputView.initLottoNumberLog();
        Lotto lotto = initValidInputReadLine(() -> LottoFactory.createLottoFrom(Console.readLine()));

        lottoInputView.initLottoBonusNumberLog();
        LottoBonusNumber lottoBonusNumber = initValidInputReadLine(
                () -> LottoBonusNumber.validateLottoNumDuplicate(lotto, new LottoBonusNumber(Console.readLine())));
        lotto.getNumbers().add(lottoBonusNumber.getBonusNumber());

        return lotto;
    }

    private <T> T initValidInputReadLine(final Supplier<T> readLine) {
        try {
            return readLine.get();
        } catch (IllegalArgumentException e) {
            System.out.println(PREFIX + e.getMessage());
            return initValidInputReadLine(readLine);
        }
    }


}
