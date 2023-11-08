package lotto.exception.lottojudge;

import lotto.exception.common.CustomStateException;

public class JudgeNotConfiguredException extends CustomStateException {
    private static final String MESSAGE = "아직 추첨 결과가 발표되지 않았습니다.";

    public JudgeNotConfiguredException() {
        super(MESSAGE);
    }
}
