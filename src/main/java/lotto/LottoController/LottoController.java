package lotto.LottoController;

import lotto.Lotto;
import lotto.LottoView.LottoView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private final LottoView view;
    private final InputCheck inpubCheck;
    private final GeneratorLotto generatorLotto;

    public LottoController(){
        this.view = new LottoView();
        this.inpubCheck = new InputCheck(view);
        this.generatorLotto = new GeneratorLotto();
    }

    public void run(){
        int purchaseAmount = inpubCheck.inputAmount();
        List<Lotto> lottos = generatorLotto.generatorLotto(purchaseAmount);
        view.showLottos(purchaseAmount, lottos.stream().map(Lotto::getNumbers).collect(Collectors.toList()));
        Lotto winNumbers = inpubCheck.inputNumbers();
        int bonusNumber = inpubCheck.inputBonus(winNumbers);
    }


}