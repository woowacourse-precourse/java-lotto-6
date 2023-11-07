package lotto.domain;

import lotto.configure.DomainConfiguration;
import lotto.util.RandomNumberGenerator;
import lotto.util.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또를 발행하는 클래스.
 */
public class LottoGenerator {

    public static int calculateNumOfLotto(int purchasePrice) throws IllegalArgumentException {
        Validator.validateDivisibility(purchasePrice);
        return purchasePrice / DomainConfiguration.PRICE_OF_LOTTO;
    }

    /**
     * (purchasePrice / DomainConfiguration.PRICE_OF_LOTTO)만큼의 로또를 발행한다.
     * @param howMany 발행할 로또의 개수.
     * @return purchasePrice에 알맞은 장수의 로또가 담긴 리스트.
     * @throws IllegalArgumentException purchasePrice가 DomainConfiguration.PRICE_OF_LOTTO의 배수가 아닐 경우.
     */
    public static List<Lotto> generate(int howMany) throws IllegalArgumentException {
        List<Lotto> lottoContainer = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            List<Integer> numbers = RandomNumberGenerator.generateMultiple(
                    DomainConfiguration.LOTTO_NUMBER_MIN,
                    DomainConfiguration.LOTTO_NUMBER_MAX,
                    DomainConfiguration.LENGTH_OF_LOTTO
            );
            Lotto lotto = new Lotto(numbers);
            lottoContainer.add(lotto);
        }
        return lottoContainer;
    }
}
