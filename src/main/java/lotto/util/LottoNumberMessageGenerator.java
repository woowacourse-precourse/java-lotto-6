package lotto.util;

import java.util.List;
import java.util.StringJoiner;
import lotto.domain.LottoNumber;

public enum LottoNumberMessageGenerator {
    INSTANCE;

    private static final String SEPERATOR = ", ";
    private static final String FRONT = "[";
    private static final String BACK = "]";

    public String generateNumberMessage(List<LottoNumber> lottoNumbers) {
        StringJoiner numberMessage = new StringJoiner(SEPERATOR, FRONT, BACK);
        lottoNumbers.stream()
                .map(LottoNumber::getNumberMessage)
                .forEach(numberMessage::add);

        return numberMessage.toString();
    }
}
