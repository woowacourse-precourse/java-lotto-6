[domain]

①RandomLotto
▶️로또 구입 금액만큼 로또 리스트를 발행, 반환하는 클래스

필드
- private static final int numbersOfLotto :: 로또 구입 개수
- private static final List<List<Integer>> lottoLists :: 발행된 로또의 전체 리스트

생성자
- RandomLotto() :: 기본생성자

메서드
- [초기화] void addLottoLists(List<Integer> lottoList) :: RandomGenerator에서 발행된 랜덤번호 6개로 구성된 리스트를 추가(lottoLists.add(lottoList)
- [반환] List<List<Integer>> getLottoLists() :: lottoLists 반환


②RandomGenerator
▶️중복없는 로또번호 6개를 생성, 중복확인, 반환하는 역할을 하는 클래스

필드
- private final List<Integer> numList :: 로또번호를 저장할 리스트

생성자
- RandomGenerator() :: 기본 생성자

메서드
- [생성]int generate() :: numList 내부 중복 번호 검증 validate/validate 통과한 번호만 랜덤 로또 번호 1개 반환
- [초기화]void addRandomList(int generatedNum) :: numList.add(generatedNum)
- [검증]boolean validateNumber(int number) :: numList.stream().distinct().count() 와 numList의 크기와 같은지 확인
- [반환]List<Integer> getNumList() :: 랜덤 로또번호 6개 반환

③Lotto
▶️사용자의 당첨번호 저장, 중복확인, 반환하는 역할을 하는 클래스

필드
- private final List<Integer> numbers :: 사용자의 당첨번호를 저장할 리스트

생성자
- Lotto(List<Integer> numbers) :: validate 검증/리스트로 넘어온 값들을 numbers 초기화

메서드
- [검증]void validate(List<Integer> numbers) :: numbers의 길이가 6인지 확인
- [검증]void isDuplicated(List<Integer> numbers) :: numbers이 중복된 값으로 구성되지 않았는지 확인
- [반환]List<Integer> getUserNumbers() :: numbers 반환

④ Consistency
▶️당첨 통계를 내기 위한 일치성 여부 확인, 수익률을 계산하는 역할을 하는 클래스

필드
- private static final int lottoCoinsistency :: 로또 번호 일치 갯수
- private static final int bonusCoinsistency :: 보너스 일치 갯수
- private static final int rateMoney :: 수익금
- private static final int capital :: 자본금
- private static final long rateOfReturn :: 수익률
- private static final List<Integer> moneyList :: 수익 갯수에 따른 머니 단위를 저장하는 리스트

생성자
- public Consistency(int capital) :: moneyList 초기화 메서드(setMoneyList) 호출/setCapital 메서드 호출

메서드
- public void winnerGraph(List<List<Integer>> numList, List<Integer> userNumber) :: 순회하며 일치하는 개수 최댓값 갱신
- private void setRateOfReturn(int lottoCoinsistency, int bonusCoinsistency) :: setLottoCoinsistency, setBonusCoinsistency 호출/갯수에 따른 수익금 초기화/수익률 초기화
- private void setLottoCoinsistency(int lottoCoinsistency) :: 로또 번호 일치 갯수 초기화
- private void setBonusCoinsistency(int bonusCoinsistency) :: 보너스 일치 갯수 초기화
- private List<Integer> setMoneyList() :: 3개 일치시 5000, 4개 일치시 50000, 5개 일치시 1500000, 5개 일치 및 보너스 볼 일치시 30000000, 6개 일치시 2000000000 초기화
- private void setCapital(int capital) :: 자본금 초기화



[view]
① InputView
▶️사용자가 구입할 금액, 당첨번호와 보너스 번호의 입력을 받는 클래스

필드
-

생성자
-

메서드
- [공통 입력]public static void inputLine() :: `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용

② OutputView
▶️사용자의 출력부를 담당하는 클래스

필드
- private static final String purchasePrice = "구입금액을 입력해 주세요."
- private static final String purchaseNumber = "개를 구매했습니다."
- private static final String userNumber = "당첨 번호를 입력해 주세요."
- private static final String bonusNumber = "보너스 번호를 입력해 주세요."
- private static final String winNumberGraph = "당첨 통계"
- private static final String slash = "---"
- private static final String threeCorrect = "3개 일치 (5,000원) - " :: 6개까지 반복
- private static final String count = "개"
- private static final String rateOfReturn = "총 수익률은 "
- private static final String percent = "% 입니다."

생성자
-

메서드
- public static void purchaseComment() :: purchasePrice 출력
- public static void purchaseNumberComment() :: purchaseNumber 출력
- public static void lottoListComment(List<List<Integer> numList) :: 로또 번호 출력
- public static void userNumberComment() :: userNumber 출력
- public static void bonusNumberComment() :: bonusNumber 출력
-


출력
- private static final String형 '구입금액을 입력해 주세요.' 문자열 상수화
- private static final String형 '개를 구매했습니다.' 문자열 상수화
- 랜덤 값으로 받아온 6개 값 * 구입개수만큼 출력

입력
- int형 구입금액


[contoller]







