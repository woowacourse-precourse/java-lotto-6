package lotto.utils;

//파싱 관련 기능 클래스
public class ParserFromStringImpl implements ParserFromString {

	@Override
	public int toIntPaser(String lottoString) {
		return Integer.parseInt(lottoString);
	}

	@Override
	public char toCharacterParser(String lottoString, int index) {
		return lottoString.charAt(index);
	}
}
