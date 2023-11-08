package lotto.domain;

import lotto.util.ConvertorUtil;
import lotto.util.NumberUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Player {
    private final Integer amount;
    private final List<Lotto> inputs;
    private final List<String> issuedLottoMessages;

    public Player(Integer amount) {
        this.amount = amount;
        this.inputs = new ArrayList<>();
        this.issuedLottoMessages = new ArrayList<>();
        setLottoes();
        setLottoMessages();
    }

    public void addLottoes(Lotto lotto) {
        this.inputs.add(lotto);
    }

    public void setLottoes() {
        IntStream.range(0, getLotteCount())
                .forEach(this::issueLotto);
    }
    private void setLottoMessages() {
       this.inputs.forEach(this::issueLottoMessages);
    }

    private void issueLottoMessages(Lotto lotto) {
       this.issuedLottoMessages.add(
               ConvertorUtil.convertToString(lotto.getNumbers())
       );
    }

    private int getLotteCount() {
        return this.amount / 1000;
    }

    public List<Lotto> getRegularNumbers() {
        return inputs;
    }

    public List<String> getIssuedLottoMessages() {
        return issuedLottoMessages;
    }

    private void issueLotto(int rangeIndex) {
        addLottoes(new Lotto(getSortedAscendingNumber()));
    }

    private List<Integer> getSortedAscendingNumber() {
        return new NumberUtil().getRandomNumbers()
                .stream()
                .sorted()
                .toList();
    }
}