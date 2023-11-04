package lotto.controller;

import java.util.List;
import lotto.constance.PrintConst;
import lotto.exceptionhandler.ExceptionHandler;
import lotto.exceptionhandler.RetryExceptionHandler;
import lotto.model.LottoStore;
import lotto.model.Lottos;
import lotto.model.domain.LottoAnswer;
import lotto.model.lottogenerator.AnswerGenerator;
import lotto.ui.Reader;
import lotto.ui.Writer;
import lotto.model.lottogenerator.RandomLottoGenerator;

public class LottoController {

    private ExceptionHandler retryHandler = new RetryExceptionHandler();
    private LottoStore store = new LottoStore(new RandomLottoGenerator());

    //TODO 1. 로또 구매
    public Lottos purchaseLotto() {
        int money = retryHandler.getResult(
                () -> {
                    Writer.printGuide(PrintConst.GUIDE_PURCHASE);
                    return Reader.getMoney();
                });

        Lottos lottos = store.purchase(money);
        Writer.printModelsInList(lottos.getLottosDTO());

        return lottos;
    }

    public LottoAnswer getAnswer(){
        LottoAnswer lottoAnswer = (LottoAnswer) retryHandler.getResult(()-> {
            Writer.printGuide(PrintConst.GUIDE_LOTTO_NUMBERS);
            List<Integer> answers = Reader.getAnswerNumbers();
            Writer.printGuide(PrintConst.GUIDE_BONUS_NUMBERS);
            Integer bonusNumber = Reader.getBonusNumber();
            AnswerGenerator answerGenerator = new AnswerGenerator(answers, bonusNumber);
            return answerGenerator.generate();
        });

        return lottoAnswer;
    }

    //TODO 4. 보너스 번호 입력

    //TODO 5. 결과 생성 및 처리
}
