package lotto.util.message;

public enum WinningStatisticsMessage implements MessageFormatter{

	TOP("당첨 통계\n---"),
    DONT_HAVE_BONUS_NUMBER("%,d개 일치 (%,d원) - %d개"),	
    HAVE_BONUS_NUMBER("%,d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    TOTAL_RETURN("총 수익률은 %.1f%%입니다.");

	private final String message;

	WinningStatisticsMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getFormattedMessage(Object... params) {
		return String.format(getMessage(), params);
	}
}