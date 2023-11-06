package lotto.view;

import lotto.dto.input.UserLottoDTO;
import lotto.dto.input.UserMoneyDTO;
import lotto.io.Reader;
import lotto.io.Writer;

public class LottoScreen {
    private final Reader reader;
    private final Writer writer;

    public LottoScreen(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public UserMoneyDTO inputUserMoney() {
        writer.writeLine("구입 금액을 입력해 주세요");
        return new UserMoneyDTO(reader.readLine().trim());
    }

    public UserLottoDTO registerLotto() {
        writer.writeLine("당첨 번호를 입력해 주세요");
        return new UserLottoDTO(reader.readLine().trim());
    }
}
