package lotto.Lotto.service;

import lotto.Lotto.entity.Lotto;
import lotto.Lotto.repository.LottoRepository;

import java.util.ArrayList;
import java.util.List;

//핵심 로직
public class LottoService {
    LottoRepository repository = LottoRepository.getInstance();
    UIService uiService = new UIService();

    //당첨 번호를 입력받는 함수
    public List<Integer> getWinningNumbers() {
        List<Integer> numbers = uiService.readLottoNumbers();
        return numbers;
    }

    //당첨 번호를 설정하는 함수
    public void setWinningNumbers(Lotto winningLotto) {
        repository.setWinningLotto(winningLotto);
    }

    //보너스 번호를 설정하는 함수
    public void setBonusNumber(int bonusNumber) {
        repository.setBonusNumber(bonusNumber);
    }

}
