package lotto.domain.lotto;

import lotto.domain.number.NumberUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private static final String NEXT_LINE = "\n";

    private long numberOfTheLotto;
    private NumberUtil numberUtil;
    private List<Lotto> lottos;

    public Lottos(long numberOfTheLotto, NumberUtil numberUtil) {
        this.numberOfTheLotto = numberOfTheLotto;
        this.numberUtil = numberUtil;
        this.lottos = new ArrayList<>();
        generateLottos();
        //TODO: lotto 생성 메서드 생성
    }

    public void generateLottos() {
        for(int i = 0; i< numberOfTheLotto; i++) {
            List<Integer> lottoNumbers = numberUtil.generateNumbers();

            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
    }

    public String generateLottosResult() {
        StringBuilder result = new StringBuilder();

        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            String lottoResult = lottoNumbers.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", ","[","]"));
            result.append(lottoResult).append(NEXT_LINE);
        }
        return result.toString();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
