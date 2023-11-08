package lotto.service;

import lotto.controller.DeliverController;
import lotto.vo.Lotto;
import lotto.domain.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class DeliverService {
    List<Lotto> lottoPackage;

    public DeliverService(int lottoNumber) {
        new DeliverController(lottoNumber, this);
    }

    public List<Lotto> generateLotto(int num) {
        List<Lotto> lottoPackage = new ArrayList<>();
        LottoGenerator generator = new LottoGenerator();

        int i = 0;
        while (i < num) {
            Lotto lotto = new Lotto(generator.generate());
            lottoPackage.add(lotto);
            i++;
        }

        this.lottoPackage = lottoPackage;
        return lottoPackage;
    }

    public List<Lotto> noticeLottoPackageForCheckWinning() {
        return lottoPackage;
    }

}
