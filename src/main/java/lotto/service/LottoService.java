package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Parser parser = new Parser();

    private final LottoRepository lottoRepository = new LottoRepository();
    int lottoCount;

    public void setLottoCount(){
        lottoCount = parser.parseLottoCount(inputView.inputUserAmount());
    }

    public void setUserLotto() {
        for(int i=0; i<lottoCount;i++) {
            getNewLotto();
        }
    }

    private void getNewLotto() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() != 6) {
            int number = Randoms.pickNumberInRange(1, 45);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        Collections.sort(numbers);
        lottoRepository.save(new Lotto(numbers));
    }

    public void getUserLotto() {
        outputView.printLottoCount(lottoCount);
        List<Lotto> lottoList = lottoRepository.getUserLottoList();

        for(Lotto lotto : lottoList) {
            outputView.printLotto(lotto.getNumbers());
        }
    }
}
