package lotto.view;

import lotto.dto.input.UserBonusDTO;
import lotto.dto.input.UserLottoDTO;
import lotto.dto.input.UserMoneyDTO;
import lotto.io.Reader;
import lotto.io.Writer;
import lotto.repository.LottoRepository;

public class LottoScreen {
    private final Reader reader;
    private final Writer writer;

    public LottoScreen(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void displayGeneratedLotto(LottoRepository lottoRepository) {
        // String.Join으로 ", "를 입력해야 한다
        // FORMAT "[ %s ]" 로 진행한다
    }

    public UserBonusDTO registerBonus() {
        writer.writeLine("보너스 번호를 입력해 주세요");
        return new UserBonusDTO(reader.readLine().trim());
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
