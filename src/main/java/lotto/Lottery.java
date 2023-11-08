package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Constant.LottoConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {
    private final int cost;
    private final int numberOfLotto;
    private final List<Lotto> lotto;

    public Lottery(int cost)
    {
        this.cost = cost;
        this.numberOfLotto = (int) cost / LottoConstant.TICKET_PRICE;
        this.lotto = pickLotto(this.numberOfLotto);
    }

    public int getNumberOfLotto()
    {
        return this.numberOfLotto;
    }

    public List<Lotto> getLotto()
    {
        return this.lotto;
    }

    private List<Lotto> pickLotto(int numberOfLotto)
    {
        return IntStream.range(0, numberOfLotto)
                        .mapToObj(i ->
                                Randoms.pickUniqueNumbersInRange(LottoConstant.MINIMUM_NUMBER,
                                        LottoConstant.MAXIMUM_NUMBER, LottoConstant.LOTTO_NUMBER_LENGTH))
                            .map(lotto -> lotto.stream()
                            .sorted()
                            .collect(Collectors.toList()))
                        .map(Lotto::new)
                        .collect(Collectors.toList());
    }

}
