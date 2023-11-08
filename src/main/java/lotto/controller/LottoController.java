package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Exception.LottoIntegerException;
import lotto.Exception.LottoListException;
import lotto.domain.Lotto;
import lotto.domain.SelectedLottoNumber;
import lotto.service.LottoService;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final LottoIntegerException lottoIntegerException = new LottoIntegerException();
    private final LottoListException lottoListException =new LottoListException();
    private final LottoService lottoService = new LottoService();

    public int LottoSetPrice() {
        String readPrice = Console.readLine();
        int lottoPrice = lottoIntegerException.checkForPriceException(readPrice);
        return lottoPrice;
    }

    public List<Lotto> makeLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumber = lottoService.makeRandomNumber();
            Lotto lotto = new Lotto(lottoNumber);

            lottos.add(lotto);
        }
        return lottos;
    }

    public SelectedLottoNumber setSelectedNumber() {

        String initialNumbers = Console.readLine();
        List<Integer> numbers = lottoListException.checkSelectedNumber(initialNumbers);

        String initialBonus = Console.readLine();
        int bonus = lottoIntegerException.checkForBonus(initialBonus);

        SelectedLottoNumber selectedLottoNumber = new SelectedLottoNumber(numbers, bonus);
        return selectedLottoNumber;
    }
}
