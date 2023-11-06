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
        int money = lottoView.inputMoney(); // 나중에 문자열로 바꿔서 검증유틸에서 모두 처리하도록?
        boolean isValid = validationUtils.validateUserAmount(money);

        while(!isValid) {
            money = lottoView.inputMoney();
            isValid = validationUtils.validateUserAmount(money);
        }

        UserAmount userAmount = new UserAmount(money);
        Lottos lottos = lottoNumberCreator.createLottoNumbers(userAmount.getNumberOfLotto());
        lottoView.printLottoNumbers(lottos);

        // 당첨 번호 입력 받기
        String winningNumber = lottoView.inputWinningNumber();
        isValid = validationUtils.validateWinningNumber(winningNumber);
        while(!isValid) {
            winningNumber = lottoView.inputWinningNumber();
            isValid = validationUtils.validateWinningNumber(winningNumber);
        }

        // 보너스 번호 입력 받기
        String bonusNumber = lottoView.inputBonusNumber();
        isValid = validationUtils.validateBonusNumber(bonusNumber);
        while(!isValid) {
            bonusNumber = lottoView.inputBonusNumber();
            isValid = validationUtils.validateBonusNumber(bonusNumber);
        }

        // 당첨 번호와 겹치는 번호가 없는지 확인 필요



        // 구입 로또와 당첨번호 비교해서 결과 담는 클래스 생성
        // 결과를 뷰로 넘겨서 일치여부 출력하고 수익률 출력하고 종료


    }

}
