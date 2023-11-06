package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoNumberCreator;
import lotto.model.Lottos;
import lotto.model.UserAmount;
import lotto.validation.ValidationUtils;
import lotto.view.LottoView;

import java.util.List;

public class LottoController {
    private LottoView lottoView;
    private ValidationUtils validationUtils;
    private LottoNumberCreator lottoNumberCreator;

    public LottoController() {
        lottoView = new LottoView();
        validationUtils = new ValidationUtils();
        lottoNumberCreator = new LottoNumberCreator();
    }

    public void startLotto() {
        int money = lottoView.inputMoney();
        boolean isValid = validationUtils.validateUserAmount(money);

        while(!isValid) {
            money = lottoView.inputMoney();
            isValid = validationUtils.validateUserAmount(money);
        }

        UserAmount userAmount = new UserAmount(money);
        Lottos lottos = lottoNumberCreator.createLottoNumbers(userAmount.getNumberOfLotto());
        lottoView.printLottoNumbers(lottos);

        // 당첨 번호 입력 받기
        // 입력 예외 처리(잘못된 입력 시 다시 입력)
        // 보너스 번호 입력 받기
        // 입력 예외 처리(잘못된 입력 시 다시 입력)

        // 구입 로또와 당첨번호 비교해서 결과 담는 클래스 생성
        // 결과를 뷰로 넘겨서 일치여부 출력하고 수익률 출력하고 종료


    }

}
