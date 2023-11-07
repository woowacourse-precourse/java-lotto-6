package model;

public enum Announcement {

	PURCHASE_GUIDE("구입금액을 입력해 주세요."),
	FEEDBACK_PURCHASE("개를 구매했습니다."),
	
	WINNGIN_NUM_GUIDE("당첨 번호를 입력해 주세요."),
	BONUS_GUIDE("\n보너스 번호를 입력해 주세요."),
	
	STATISTICS_START("당첨 통계\n---"),
	
	CORRES_THREE("3개 일치 (5,000원) - "),
	CORRES_FOUR("4개 일치 (50,000원) - "),
	CORRES_FIVE("5개 일치 (1,500,000원) - "),
	CORRES_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
	CORRES_ALL("6개 일치 (2,000,000,000원) - ");
	
	private final String msg;
	
	Announcement(String msg) {
		this.msg=msg;
	}

	public String getAnnouncement() {
		return msg;
	}
}
