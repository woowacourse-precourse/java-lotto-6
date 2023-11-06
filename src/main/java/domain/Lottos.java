package domain;

import static constant.ConstantNumber.LOTTO_SIZE;
import static constant.ConstantNumber.MAX_NUMBER;
import static constant.ConstantNumber.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public static Lottos makeLottos(long ticketCount) {
        List<Lotto> list = LongStream.range(0, ticketCount)
                .mapToObj(lotto -> new Lotto(chooseRandomLottoNumbers()))
                .peek(Lotto::printNumbers)
                .collect(Collectors.toList());

        return new Lottos(list);
    }

    private static List<Integer> chooseRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getNumber(), MAX_NUMBER.getNumber(), LOTTO_SIZE.getNumber());
    }
}
