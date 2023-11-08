package lotto.view;

import lotto.constant.LottoMessage;
import lotto.dto.LottoInfoResponse;
import lotto.model.LottoResult;

public class OutputView {

    private final OutputMaker outputMaker;

    public OutputView(OutputMaker outputMaker) {
        this.outputMaker = outputMaker;
    }

    public void writeExceptionMessage(Exception exception) {
        write(exception.getMessage());
    }

    public void writeEmptyLine() {
        write(LottoMessage.getEmpty());
    }

    public void writePurchaseAmountInputMessage() {
        write(LottoMessage.getPurchaseAmountInputMessage());
    }

    public void writeLottosInfo(LottoInfoResponse lottoInfoResponse) {
        write(LottoMessage.getPurchaseCountMessage(lottoInfoResponse.lottoCount()));
        write(outputMaker.makeLottosNumbersOutput(lottoInfoResponse.lottoNumbers()));
    }

    public void writeWinningNumberInputMessage() {
        write(LottoMessage.getWinningNumberInputMessage());
    }

    public void writeBonusNumberInputMessage() {
        write(LottoMessage.getBonusNumberInputMessage());
    }

    public void writeLottoResultWriteStartMessage() {
        write(LottoMessage.getLottoResultWriteStartMessage());
    }

    public void writeLottoResult(LottoResult lottoResult) {
        write(outputMaker.makeLottoResultOutput(lottoResult));
    }

    private void write(String output) {
        System.out.println(output);
    }
}
