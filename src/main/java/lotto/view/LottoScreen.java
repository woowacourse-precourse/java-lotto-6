package lotto.view;

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
    public static final String RESULT_SUFFIX = "입니다.";
    private static StringBuilder stringbuilder = new StringBuilder();

    private final Reader reader;
    private final Writer writer;

    public LottoScreen(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
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

    public void displayGeneratedLotto(UserMoney userMoney, LottoRepository lottoRepository) {
        // 9개 구매했습니다
        List<Lotto> allLottos = lottoRepository.getAllLottos();
        List<String> convertedLottos = allLottos.stream()
                .map((lotto) -> String.join(", ", convertNumbers(lotto.getLotto())))
                .toList();

        // FORMAT "[" + %s +"]" 로 진행한다
        convertedLottos.forEach((lotto -> writer.writeFormat("[%s]", lotto)));
    }

    public void displayLottoResult(LottoFinalResult lottoFinalResult) {
        writer.writeLine("당첨 통계");
        writer.writeLine("---");
        // %s 일치 (%s) - %d개
        // entryset -> set.getValue() + "일치" + "(" + set.getKey().getWinningAmount() + )"
        // 일치하는 것도 ENUM에서 관리하는 방향으로 진행

    }

    public void displayRateOfReturn(float rateOfReturn) {
        stringbuilder.append(RESULT_PREFIX);
        stringbuilder.append(String.format(RATE_FORMAT, rateOfReturn));
        stringbuilder.append(RESULT_SUFFIX);
        writer.writeLine(stringbuilder.toString());
    }

    private String convertNumbers(List<Integer> numbers) {
        numbers.stream()
                .map((number) -> number.toString())
                .forEach((stringbuilder::append)); // 중간에 공백 넣어줘야 한다
        return stringbuilder.toString();
    }
}
