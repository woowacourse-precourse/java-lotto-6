package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoFinalResult;
import lotto.domain.UserMoney;
import lotto.dto.input.UserBonusDTO;
import lotto.dto.input.UserLottoDTO;
import lotto.dto.input.UserMoneyDTO;
import lotto.io.Reader;
import lotto.io.Writer;
import lotto.repository.LottoRepository;

public class LottoScreen {
    public static final String RATE_FORMAT = "%.1f";
    public static final String RESULT_PREFIX = "총 수익률은";
    public static final String RESULT_SUFFIX = "%입니다.\n";
    public static final String RESULT_FORMAT = "%s " + RATE_FORMAT +"%s";
    public static final String REWIND_FORMAT = "\n%d개를 구매했습니다.\n";

    public static final String LOTTO_RESULT_FORMAT = "%s (%,d원) - %d개\n";

    private final Reader reader;
    private final Writer writer;

    public LottoScreen(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public UserMoneyDTO inputUserMoney() {
        writer.writeLine("구입 금액을 입력해 주세요.");
        String line = reader.readLine();
        writer.writeLine("line = " + line);

        return new UserMoneyDTO(line.trim());
    }

    public UserBonusDTO registerBonus() {
        writer.writeLine(("\n보너스 번호를 입력해 주세요."));
        String line = reader.readLine();
        return new UserBonusDTO(line.trim());
    }

    public UserLottoDTO registerLotto() {
        writer.writeLine("\n당첨 번호를 입력해 주세요.");
        return new UserLottoDTO(reader.readLine().trim());
    }

    public void displayGeneratedLotto(UserMoney userMoney, LottoRepository lottoRepository) {
        System.out.printf(REWIND_FORMAT, userMoney.getLottoChances());

        List<Lotto> allLottos = lottoRepository.getAllLottos();
        List<String> convertedLottos = allLottos.stream()
                .map((lotto) -> String.join(", ", convertNumbers(lotto.getLotto())))
                .toList();

        convertedLottos.forEach((lotto -> writer.writeFormat("[%s]\n", lotto)));
    }

    public void displayLottoResult(LottoFinalResult lottoFinalResult) {
        writer.writeLine("\n당첨 통계");
        writer.writeLine("---");

        lottoFinalResult.getFinalResultMap()
                .entrySet()
                .stream().skip(3)
                .forEach((set) -> {
                    writer.writeFormat(LOTTO_RESULT_FORMAT, set.getKey().getDescription(),
                            set.getKey().getWinningAmount(), set.getValue());
                });
    }

    public void displayRateOfReturn(float rateOfReturn) {
        writer.writeFormat(RESULT_FORMAT, RESULT_PREFIX, rateOfReturn, RESULT_SUFFIX);
    }

    private List<String> convertNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map((number) -> number.toString())
                .toList();
    }
}
