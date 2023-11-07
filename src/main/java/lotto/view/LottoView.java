package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Function;
import lotto.constant.LottoMessage;
import lotto.dto.LottoInfoResponse;
import lotto.dto.PurchaseAmountRequest;

public class LottoView {

    private final InputMapper inputMapper;

    public LottoView(InputMapper inputMapper) {
        this.inputMapper = inputMapper;
    }

    public PurchaseAmountRequest readPurchaseAmount() {
        write(LottoMessage.getPurchaseAmountInputMessage());
        return readUntilValidInput(inputMapper::inputToPurchaseAmountRequest);
    }

    public void writeLottosInfo(LottoInfoResponse lottoInfoResponse) {
        write(LottoMessage.getEmpty());
        write(LottoMessage.getPurchaseCountMessage(lottoInfoResponse.lottoCount()));
    }

    private void write(String output) {
        System.out.println(output);
    }

    private String read() {
        return Console.readLine();
    }

    private <T> T readUntilValidInput(Function<String, T> mapper) {
        T input = null;
        boolean isInValidInput = true;

        while (isInValidInput) {
            try {
                input = mapper.apply(read());
                isInValidInput = false;
            } catch (IllegalArgumentException e) {
                write(e.getMessage());
            }
        }

        return input;
    }
}
