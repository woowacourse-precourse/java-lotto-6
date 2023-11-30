package lotto.model;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBatch {

    private List<Lotto> lottos;


    public LottoBatch(Integer lottoCount) {
        lottos = new ArrayList<>();
        while (lottos.size() < lottoCount) {
            Lotto lotto = new Lotto();
            if (!checkDuplication(lotto)) {
                lottos.add(lotto);
            }
        }
    }

    public Boolean checkDuplication(Lotto lotto) {
        if (lottos.contains(lotto)) {
            return true;
        }
        return false;
    }


    public List<String> toStrings() {
        return lottos.stream().map(Lotto::toString).collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}