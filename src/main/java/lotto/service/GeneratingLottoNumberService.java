package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.UserLottos;

public class GeneratingLottoNumberService {
    private static final int PRICE_OF_LOTTO = 1000;
    private static final int MIN_NUMBER_OF_LOTTO = 1;
    private static final int MAX_NUMBER_OF_LOTTO = 45;
    private static final int SIZE_OF_PICKING_LOTTO = 6;
	
	public static List<UserLottos> generatingLottoNumber(int buyingLottoPrice) {
		List<UserLottos> lottos = buyingLottos(getBuyingLottoTicket(buyingLottoPrice));
		return lottos;
	}
    public static int getBuyingLottoTicket(int buyingLottoPrice) {
        return buyingLottoPrice / PRICE_OF_LOTTO;
    }

    public static List<UserLottos> buyingLottos(int quantity) {
        List<UserLottos> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER_OF_LOTTO, MAX_NUMBER_OF_LOTTO, SIZE_OF_PICKING_LOTTO);
            lottos.add(new UserLottos(sortedList(lottoNumbers)));
        }
        return lottos;
    }

    public static List<Integer> sortedList(List<Integer> unsortedlottoNumbers) {
        List<Integer> sortedlottoNumbers = new ArrayList<>(unsortedlottoNumbers);
        Collections.sort(sortedlottoNumbers);
        return sortedlottoNumbers;
    }
}
