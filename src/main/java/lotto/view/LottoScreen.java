package lotto.view;

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
        writer.writeLine("구입 금액을 입력해주세요");
        return new UserMoneyDTO(reader.readLine().trim());
    }
}
