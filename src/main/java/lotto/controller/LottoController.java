package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.enumerate.ConfigInteger;
import lotto.model.Amount;
import lotto.model.Cash;
import lotto.model.Lotto;
import lotto.model.LottoNumbers;
import lotto.model.WinningInfo;
import lotto.model.WinningList;
import lotto.model.WinningNumber;
import lotto.record.AmountRecord;
import lotto.record.LottoNumberRecord;
import lotto.record.ProfitRate;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final int LOTTO_PRICE = ConfigInteger.LOTTO_PRICE.getInt();
    private static final int LOTTO_START_NUMBER = ConfigInteger.LOTTO_START_NUMBER.getInt();
    private static final int LOTTO_END_NUMBER = ConfigInteger.LOTTO_END_NUMBER.getInt();
    private static final int LOTTO_NUMBER_COUNT = ConfigInteger.LOTTO_NUMBER_COUNT.getInt();
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Amount amount = inputAmount();
        List<Lotto> lottos = buyLotto(amount.getAmountCash());
        printLotto(lottos);
        WinningList winningList = calculateWinning(lottos);
        printWinningList(winningList);
        calculateAndPrintProfitRate(winningList, amount);
    }

    private Amount inputAmount() {
        System.out.println();
        return new Amount(inputView.inputAmount());
    }

    private List<Lotto> buyLotto(Cash amountCash) {
        ArrayList<Lotto> list = new ArrayList<>();
        long lottoVolume = amountCash.cash() / LOTTO_PRICE;
        getLottoList(lottoVolume, list);
        return list;
    }

    private void getLottoList(long lottoVolume, List<Lotto> list) {
        for (int i = 0; i < lottoVolume; i++) {
            getLottoNumber(list);
        }
    }

    private void getLottoNumber(List<Lotto> list) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER,
                LOTTO_NUMBER_COUNT);
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        list.add(new Lotto(lottoNumbers));
    }

    private void printLotto(List<Lotto> lottos) {
        List<String> lottoList = lottos.stream()
                .map(Lotto::makeLottoNumberString)
                .toList();
        outputView.printLottoList(lottos.size(), lottoList);
    }

    private WinningList calculateWinning(List<Lotto> lottos) {
        WinningNumber winningNumber = new WinningNumber(inputView.inputWinningNumber(), inputView.inputBonusNumber());
        List<LottoNumberRecord> numberRecordList = lottos.stream().map(Lotto::toRecord).toList();
        WinningInfo winningInfo = new WinningInfo(numberRecordList, winningNumber);
        return new WinningList(winningInfo);
    }

    private void printWinningList(WinningList winningList) {
        outputView.printWinningList(winningList.printWinningListString());
    }

    private void calculateAndPrintProfitRate(WinningList winningList, Amount amount) {
        AmountRecord amountRecord = amount.toRecord();
        ProfitRate profitRate = winningList.calculateProfitRate(amountRecord);
        String printProfitRate = profitRate.printProfitRate();
        outputView.printProfitRate(printProfitRate);
    }
}
