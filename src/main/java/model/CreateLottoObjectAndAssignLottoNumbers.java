package model;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class CreateLottoObjectAndAssignLottoNumbers {
    public List<Lotto> generateMyLottoGroup(int LottoPaperCount) {
        List<Lotto> myLottos = new ArrayList<>();

        while (myLottos.size() < LottoPaperCount) {
            myLottos.add(generateMyLotto());
        }

        return myLottos;
    }

    public Lotto generateMyLotto() {
        MyLottoNumbersGenerator myLottoNumbersGenerator = new MyLottoNumbersGenerator();
        return new Lotto(myLottoNumbersGenerator.generateMyLottoNumbers());
    }
}