package lotto.view.output;

import static java.util.stream.Collectors.joining;

import java.util.List;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class OutputView {
    private static final String PURCHASED_LOTTO_SIZE_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    private static final String PURCHASED_LOTTO_NUMBERS_MESSAGE_FORMAT = "[%s]";
    private static final String LOTTO_NUMBERS_JOINING_DELIMETER = ", ";

    private OutputView() {
    }

    public static void printPurchasedLottos(Customer customer) {
        List<Lotto> purchasedLottos = customer.purchasedLottos();
        System.out.printf(PURCHASED_LOTTO_SIZE_MESSAGE_FORMAT, purchasedLottos.size());

        for (Lotto purchasedLotto : purchasedLottos) {
            String joinedLottoNumbers = joiningLottoNumbers(purchasedLotto.numbers());
            System.out.printf(PURCHASED_LOTTO_NUMBERS_MESSAGE_FORMAT, joinedLottoNumbers);
        }
    }

    private static String joiningLottoNumbers(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.value()))
                .collect(joining(LOTTO_NUMBERS_JOINING_DELIMETER));
    }
}
