package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Function;
import lotto.constant.LottoMessage;
import lotto.dto.LottoInfoResponse;
import lotto.dto.PurchaseAmountRequest;
import lotto.dto.WinningNumberRequest;

public class LottoView {

    private final InputMapper inputMapper;
    private final OutputMaker outputMaker;

    public LottoView(InputMapper inputMapper, OutputMaker outputMaker) {
        this.inputMapper = inputMapper;
        this.outputMaker = outputMaker;
    }

    public PurchaseAmountRequest readPurchaseAmount() {
        write(LottoMessage.getPurchaseAmountInputMessage());
        return readUntilValidInput(inputMapper::inputToPurchaseAmountRequest);
    }

    public void writeLottosInfo(LottoInfoResponse lottoInfoResponse) {
        write(LottoMessage.getEmpty());
        write(LottoMessage.getPurchaseCountMessage(lottoInfoResponse.lottoCount()));
        write(outputMaker.makeLottosNumbersOutput(lottoInfoResponse.lottoNumbers()));
    }

    public WinningNumberRequest readWinningNumber() {
        write(LottoMessage.getEmpty());
        write(LottoMessage.getWinningNumberInputMessage());
        return readUntilValidInput(inputMapper::inputToWinningNumberRequest);
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
