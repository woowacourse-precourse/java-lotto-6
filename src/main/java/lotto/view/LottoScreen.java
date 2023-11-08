package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoFinalResult;
import lotto.domain.UserMoney;
import lotto.dto.UserBonusDTO;
import lotto.dto.UserLottoDTO;
import lotto.dto.UserMoneyDTO;
import lotto.io.Reader;
import lotto.io.Writer;
import lotto.repository.LottoRepository;

public class LottoScreen {
    private static final String INPUT_MONEY_MESSAGE= "구입 금액을 입력해 주세요.";
    private static final String INPUT_BONUS_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_MESSAGE = "\n당첨 번호를 입력해 주세요.";

    private static final String REWIND_FORMAT = "\n%d개를 구매했습니다.\n";
    private static final String DISPLAY_LOTTO_FORMAT = "[%s]\n";

    private static final String LOTTO_RESULT_MESSAGE = "\n당첨 통계\n---";
    private static final String LOTTO_RESULT_FORMAT = "%s (%,d원) - %d개\n";

    private static final String RATE_FORMAT = "%.1f";
    private static final String RESULT_PREFIX = "총 수익률은";
    private static final String RESULT_SUFFIX = "%입니다.\n";
    private static final String RESULT_FORMAT = "%s " + RATE_FORMAT +"%s";

    private static final String DELIMITER = ", ";

    private static final int SKIP_RESULT_AMOUNT = 3;

    private final Reader reader;
    private final Writer writer;

    public LottoScreen(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public UserMoneyDTO inputUserMoney() {
        writer.writeLine(INPUT_MONEY_MESSAGE);
        return new UserMoneyDTO(reader.readLine().trim());
    }

    public UserLottoDTO registerLotto() {
        writer.writeLine(INPUT_LOTTO_MESSAGE);
        return new UserLottoDTO(reader.readLine().trim());
    }

    public UserBonusDTO registerBonus() {
        writer.writeLine(INPUT_BONUS_MESSAGE);
        return new UserBonusDTO(reader.readLine().trim());
    }

    public void displayGeneratedLotto(UserMoney userMoney, LottoRepository lottoRepository) {
        writer.writeFormat(REWIND_FORMAT, userMoney.getLottoChances());

        List<Lotto> allLottos = lottoRepository.getAllLottos();
        List<String> convertedLottos = allLottos.stream()
                .map((lotto) -> String.join(DELIMITER, convertNumbers(lotto.getLotto())))
                .toList();

        convertedLottos.forEach((lotto -> writer.writeFormat(DISPLAY_LOTTO_FORMAT, lotto)));
    }

    public void displayLottoResult(LottoFinalResult lottoFinalResult) {
        writer.writeLine(LOTTO_RESULT_MESSAGE);

        lottoFinalResult.getFinalResultMap()
                .entrySet()
                .stream().skip(SKIP_RESULT_AMOUNT)
                .forEach((set) -> {
                    writer.writeFormat(LOTTO_RESULT_FORMAT, set.getKey().getDescription(),
                            set.getKey().getWinningAmount(), set.getValue());
                });
    }

    public void displayRateOfReturn(float rateOfReturn) {
        writer.writeFormat(RESULT_FORMAT, RESULT_PREFIX, rateOfReturn, RESULT_SUFFIX);
        reader.close();
    }

    private List<String> convertNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map((number) -> number.toString())
                .toList();
    }
}
