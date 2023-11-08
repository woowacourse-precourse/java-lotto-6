package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Exception.LottoIntegerException;
import lotto.Exception.LottoListException;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Price;
import lotto.domain.SelectedLottoNumber;
import lotto.service.LottoService;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    final int lottoLength = 6;

    private final LottoIntegerException lottoIntegerException = new LottoIntegerException();
    private final LottoListException lottoListException =new LottoListException();
    private final LottoService lottoService = new LottoService();

    public int lottoSetPrice() {
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

    public List<Integer> selectedNumber() {

        String initialNumbers = Console.readLine();
        List<Integer> numbers = lottoListException.checkSelectedNumber(initialNumbers);

        return numbers;
    }

    public int bonusNumber() {

        String initialBonus = Console.readLine();
        int bonus = lottoIntegerException.checkForBonus(initialBonus);

        return bonus;
    }

    public int[] correct(Price price, Lottos lottos, SelectedLottoNumber selectedLottoNumber) {
        int[] corrections = new int[6];

        for (int i = 0; i < price.getPrice(); i++) {
            List<Integer> lotto = lottos.getLottos().get(i).getNumbers();
            long correctCount = lotto.stream()
                    .filter(selectedLottoNumber.getNumbers()::contains)
                    .count();

            int index = checkIndex(correctCount, lotto, selectedLottoNumber);
            corrections[index] += 1;
        }

        return corrections;
    }

    public int checkIndex(long correctCount, List<Integer> lotto, SelectedLottoNumber selectedLottoNumber) {

        if (correctCount == 6) {return 0;}
        if (correctCount == 5) {
            fiveCase(lotto, selectedLottoNumber);
        }
        if (correctCount == 4) {return 3;}
        if (correctCount == 3) {return 4;}
        return 5;
    }

    public int fiveCase(List<Integer> lotto, SelectedLottoNumber selectedLottoNumber) {
        boolean isContain = lotto.contains(selectedLottoNumber.getBonusNumber());

        if (isContain == true) {
            return 1;
        }
        return 2;
    }
}
