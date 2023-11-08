# [domain]

## ①RandomLotto
▶️로또 구입 금액만큼 로또 리스트를 발행, 반환하는 클래스

### 필드
- private static int numbersOfLotto :: 로또 구입 개수
- private static List<List<Integer>> lottoLists :: 발행된 로또의 전체 리스트

### 생성자
- RandomLotto(int numberOfLotto) :: numberOfLotto 초기화

### 메서드
- [초기화] public void addLottoLists(List<Integer> lottoList) :: RandomGenerator에서 발행된 랜덤번호 6개로 구성된 리스트를 추가(lottoLists.add(lottoList)
- [반환] public List<List<Integer>> getLottoLists() :: lottoLists 반환


## ②RandomGenerator
▶️중복없는 로또번호 6개를 생성, 중복확인, 반환하는 역할을 하는 클래스

### 필드
- private static List<Integer> numList :: 로또번호를 저장할 리스트

### 생성자
- RandomGenerator() :: 기본 생성자/generate 메서드 호출

### 메서드
- [초기화]public void generate() :: randomMachine메서드 호출로 numList 초기화
- [반환] private List<Integer> randomMachine() :: Randoms 라이브러리 랜덤 리스트 생성
- [반환] private List<Integer> getNumList() :: numList 반환


## ③Lotto
▶️사용자의 당첨번호 저장, 중복확인, 반환하는 역할을 하는 클래스

### 필드
- private final List<Integer> numbers :: 사용자의 당첨번호를 저장할 리스트

### 생성자
- Lotto(List<Integer> numbers) :: validate 검증/리스트로 넘어온 값들을 numbers 초기화

### 메서드
- [검증]void validate(List<Integer> numbers) :: numbers의 길이가 6인지 확인
- [반환]List<Integer> getUserNumbers() :: numbers 반환

## ④BonusLotto
▶️보너스 번호를 저장, 반환하는 역할을 하는 클래스

### 필드
- private static int bonusNumber :: 사용자의 보너스 번호를 저장

### 생성자
- Bonus() :: 기본 생성자

### 메서드
- public void setBonusNumber(int bonusNumber) :: 보너스 번호 초기화
- public int getBonusNumber() :: 보너스 번호 반환

## ⑤UserLotto
▶️Lotto, BonusLotto를 필드로 갖는 클래스

### 필드
- private Lotto lotto :: 로또 클래스
- private BonusLotto bonusLotto :: 보너스로또 클래스

### 생성자
- public UserLotto(Lotto lotto, BonusLotto bonusLotto) :: lotto, bonusLotto 초기화

### 메서드
- public Lotto getLotto() :: 로또 반환
- public BonusLotto getBonusLotto() :: 보너스로또 반환

## ④ Consistency
▶️당첨 통계를 내기 위한 일치성 여부 확인, 수익률을 계산하는 역할을 하는 클래스

### 필드
- private static int lottoCoinsistency :: 로또 번호 일치 갯수
- private static int bonusCoinsistency :: 보너스 일치 갯수
- private static int rateMoney :: 수익금
- private static int capital :: 자본금
- private static long rateOfReturn :: 수익률
- private static List<Integer> moneyList :: 수익 갯수에 따른 머니 단위를 저장하는 리스트
- private static UserLotto userLotto :: Lotto와 BonusLotto의 집합

### 생성자
- public Consistency(int capital, UserLotto userLotto) :: capital, userLotto 초기화

### 메서드
- public void winnerGraph(List<List<Integer>> numList) :: 순회하며 일치하는 개수 최댓값 갱신(setLottoConsistency), isContains 메서드 호출
- private void setLottoConsistency(List<Integer> list) :: lottoConsistency 최대값 갱신
- private boolean isContains(List<Integer> list):: bonusLotto가 있는지 여부 반환
- public void setRateMoney() :: lottoConsistency의 값에 따라 if문으로 rateMoney 초기화
- private void setRateOfReturn() :: 수익률 공식으로 rateMoney와 capital 값에 따라 rateOfReturn 초기화
- public long getRateOfReturn() :: rateOfReturn 반환

---

# [view]
## ① InputView
▶️사용자가 구입할 금액, 당첨번호와 보너스 번호의 입력을 받는 클래스

### 필드
-

### 생성자
-

### 메서드
- [공통 입력]public static void inputLine() :: `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용

## ② OutputView
▶️사용자의 출력부를 담당하는 클래스

### 필드
- private static final String purchasePrice = "구입금액을 입력해 주세요."
- private static final String purchaseNumber = "개를 구매했습니다."
- private static final String userNumber = "당첨 번호를 입력해 주세요."
- private static final String bonusNumber = "보너스 번호를 입력해 주세요."
- private static final String winNumberGraph = "당첨 통계"
- private static final String slash = "---"
- private static final String threeCorrect = "3개 일치 (5,000원) - " :: 6개까지 반복

```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

- private static final String count = "개"
- private static final String rateOfReturn = "총 수익률은 "
- private static final String percent = "% 입니다."

### 생성자
-

### 메서드
- public static void purchaseComment() :: purchasePrice 출력
- public static void purchaseNumberComment(int num) :: purchaseNumber 출력
- public static void lottoListsComment(List<List<Integer> lottoLists) :: 로또 번호 출력
- public static void userNumberComment() :: userNumber 출력
- public static void bonusNumberComment() :: bonusNumber 출력
-  public void winnerGraphComment(List<Integer> correctList, Long rateOfReturn) :: 당첨 통계 출력

---

# [service]
## ① LottoService
▶️ 로또 관련 서비스를 제공하는 클래스

### 필드
- private static OutputView outputView :: 출력 담당 클래스
- private static RandomGenerator rg :: 랜덤 로또 발행 클래스
- private static RandomLotto rl :: 랜덤 로또 리스트 클래스
- private static int number :: 구매금액 저장
- private static UserLotto userLotto :: 사용자의 로또번호와 보너스 번호 저장 클래스
- private static Lotto lotto :: 사용자의 로또번호 저장 클래스
- private static ConsistencyService consistencyService :: 일치성 모델 클래스
- private static int capital :: 자본금을 저장
- private static String purchaseNum :: 사용자 입력 로또번호
- private static String bonusNum :: 사용자 입력 보너스 번호

### 생성자
- public LottoService() :: outputView, rl 주입

### 메서드
- public void purchase() :: 로또 구매 서비스(입출력/로또 발행 매수 저장), getString()으로 입력 검증
- private static void getString() :: 올바르지 않은 경우 재입력(try-catch)
- public void lottoLists() :: 랜덤 로또 발행 서비스(구매 매수만큼 발행), generateLotto() 호출
- private void generateLotto() :: 구매매수만큼 rl에 리스트 입력
- public void userNumber() :: 사용자의 번호 입력 서비스(사용자의 로또 번호, 보너스 번호 입출력), Lotto와 UserLotto 초기화
- private static void getBonus() :: 보너스 입력 및 검증
- public int setBonusNumber() :: 보너스 검증 및 int형 변환, 반환
- public List<Integer> setLottoNumberList() :: 입력받은 사용자의 로또번호 검증 및 반환
- public void winner() :: Consistency 모델 초기화와 당첨 통계 계산 및 출력
- public void setPurchaseNum(String input) :: 로또번호 초기화
- public void setBonusNum(String input) :: 보너스번호 초기화

## ② ConsistencyService
▶️ 당첨이 되었는지 여부를 확인하며 총 수익률을 제공하는 클래스

### 필드
- private static List<Integer> totalConsistency = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0)) :: 당첨번호와 보너스번호의 당첨 갯수에 따른 당첨갯수 저장 리스트
- private static int bonusConsistency = 0 :: 보너스번호가 일치하는 지 여부 저장
- private static int rateMoney :: 수익금 저장
- private static int capital :: 자본금 저장
- private static List<Integer> moneyList = new ArrayList<>(Arrays.asList(5000, 50000, 1500000, 30000000, 2000000000)) :: 당첨갯수에 따른 당첨금액 저장 리스트
- private static UserLotto userLotto :: UserLotto 클래스

### 생성자
- public ConsistencyService(int capital, UserLotto userLotto) :: 자본금, UserLotto 주입

### 메서드
- public List<Integer> winnerGraph(List<List<Integer>> numList) :: 전체  랜덤 당첨번호를 이용해 사용자의 로또번호 및 보너스번호와 일치여부 확인, setTotalConsistency, getLottoConsistency 호출
- private static void setTotalConsistency(int lottoCount) :: 전체 당첨여부에 대해 수정
- private int getLottoConsistency(List<Integer> list) :: 넘어온 리스트에 대해 사용자의 로또번호와 일치 여부 확인
- private boolean isContains(List<Integer> list) :: 보너스 번호를 가지고 있는지 여부 확인
- public void setRateMoney() :: 수익금 저장
- public double getRateOfReturn() :: 수익률 계산 및 반환

---

# [contoller]
## ① LottoController
▶️ 로또 서비스를 제공하는 클래스

### 필드
- private final LottoService lottoService :: 로또 서비스

### 생성자
- public LottoController() :: 로또 서비스 주입

### 메서드
- public void playLotto() :: 로또 구입, 랜덤 로또 발행, 사용자 로또 입력, 당첨 확률



