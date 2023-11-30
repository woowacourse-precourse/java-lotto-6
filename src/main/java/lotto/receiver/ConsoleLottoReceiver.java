package lotto.receiver;

import static camp.nextstep.edu.missionutils.Console.*;

public class ConsoleLottoReceiver implements LottoReceiver {
	@Override
	public String receive() {
		return readLine();
	}
}
