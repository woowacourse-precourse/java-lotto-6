package features;

import model.Data;

public class RunGame {
	
	public Data issueGuide(Data data) {		
		for(int i=0;i<data.getLottoCount();i++) {
			data.addLottoList();
		}
		return data;
	}
}
