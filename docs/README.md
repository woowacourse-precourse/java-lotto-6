# 로또 게임

## 로또 게임 규칙
1. 로또 번호의 숫자 범위는 1 ~ 45
2. 로또 1장의 가격은 1,000원
3. 1개의 로또의 숫자는 중복되지 않는 6개의 숫자로 이루어짐
4. 당첨 번호는 중복되지 않는 숫자 6개와 보너스 번호 1개로 이루어짐
5. 당첨은 1등부터 5등까지 존재
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원

## 기능 구현 목록
- [v] 로또 구입 금액 유효성 체크(1,000원 단위)
- [v] 로또 구입 금액 만큼의 게임 횟수 셋팅
- [v] 로또 구입 금액만큼 로또 생성
- [v] 로또 번호 입력 -> 쉼표(,)를 기준으로 구분, 숫자범위 중 중복되지 않는 숫자 6개
- [v] 보너스 번호 입력 -> 로또 번호와 중복되지 않아야함
- [v] 발행된 로또 출력 -> 로또 수량 및 번호 출력, 로또 번호는 오름차순으로 정렬
- [v] 당첨 내역 출력 -> 실행결과와 같이 출력
- [v] 수익률 출력 -> 소수점 둘째 자리에서 반올림
- [v] Lotto 클래스 상속 받아 로또 번호 생성하도록 수정
- [v] 로또 번호 에러/예외 설정 및 출력 -> 에러 문구는 "[ERROR]"로 시작할 것
- [v] else, switch 문 사용하지 않고 메소드 15라인 안쪽으로 하도록 할 것
- [v] Java Enum을 적용할 것
- [v] 여러 테스트 케이스 작성

# 클래스 별 변수와 메소드
### Lotto 클래스:
- **인스턴스 변수:**
  - `numbers`: 로또 번호를 나타내는 정수 리스트입니다.

- **메서드:**
  - `public Lotto(List<Integer> numbers)`: 로또 번호를 검증하고 초기화하는 생성자입니다.
  - `private void validate(List<Integer> numbers)`: 로또 번호의 길이, 범위 및 고유성을 검증합니다.
  - `public Lotto()`: 빈 로또 인스턴스를 초기화하는 기본 생성자입니다.
  - `public List<Integer> getNumbers()`: 로또 번호 리스트를 반환합니다.
  - `public boolean containsNumber(int number)`: 번호가 로또 번호에 포함되어 있는지 확인합니다.
  - `public void add(Integer number)`: 번호를 로또 번호에 추가합니다.
  - `public static Lotto createLottoFromUserInput()`: 사용자 입력을 읽어 검증하고 로또 인스턴스를 생성합니다.
  - `public static void validateNumberRange(int num)`: 범위(1에서 45까지) 내의 단일 숫자를 검증합니다.
  - `public static void validateUniqueNumber(List<Integer> numbers, int num)`: 리스트 내에서 고유한 숫자를 검증합니다.

### LottoWin 클래스:
- **인스턴스 변수:**
  - `winNumbers`: 로또의 당첨 번호를 나타내는 Lotto 클래스의 인스턴스입니다.
  - `bonusNumber`: 로또 보너스 번호입니다.

- **메서드:**
  - `public LottoWin()`: 빈 Lotto 인스턴스로 LottoWin을 초기화하는 생성자입니다.
  - `public Lotto getWinNumbers()`: 당첨 로또 번호를 반환합니다.
  - `public int getBonusNumber()`: 보너스 번호를 반환합니다.
  - `public void setLottoWinNumbers()`: 사용자 입력을 읽어 검증하고 당첨 번호를 설정합니다.
  - `public void setWinBonusNumber()`: 사용자 입력을 읽어 검증하고 보너스 번호를 설정합니다.
  - `private void validateUniqueBonusNumber(int input)`: 보너스 번호의 고유성을 검증합니다.

### LottoGame 클래스:
  **인스턴스 변수:**
  - `private static final int LOTTO_PRICE = 1000;`: 로또 한 장의 가격을 나타내는 상수
  - `private static final int MIN_NUMBER = 1;`: 로또 번호의 최소값을 나타내는 상수
  - `private static final int MAX_NUMBER = 45;`: 로또 번호의 최대값을 나타내는 상수
  - `private static final int LOTTO_NUMBERS_COUNT = 6;`: 한 게임당 선택할 수 있는 로또 번호 개수를 나타내는 상수
  - `private static final int LOTTO_TOTAL_NUMBERS_COUNT = 7;`: 전체 로또 번호 개수(보너스 번호 포함)를 나타내는 상수

  - `private int gameCount;`: 구매한 로또 게임의 개수를 저장하는 변수
  - `public List<Lotto> lottogame;`: 로또 번호를 담는 리스트

  **메소드:**
  - `public LottoGame()`: LottoGame 클래스의 생성자. 로또 번호 리스트를 초기화한다.
  - `public void setLottoGame(int number)`: 구매한 로또 게임의 개수를 설정하는 메소드
  - `public void validatePurchaseAmount()`: 구매 금액이 유효한지 검증하고 게임의 개수를 설정하는 메소드
  - `public void generateLottoNumbers()`: 지정된 개수만큼 로또 번호를 생성하고 출력하는 메소드
  - `public void printLotto()`: 현재 로또 번호 리스트를 출력하는 메소드
  - `public void printLottoWin(LottoWin lottoWin)`: 당첨 번호와 보너스 번호를 기반으로 로또 번호를 당첨 번호와 비교하고 결과를 출력하는 메소드
  - `private int[] calculatePrizeCounts(LottoWin lottoWin)`: 당첨 번호와 비교하여 각 등수별 일치한 번호 개수를 계산하는 메소드
  - `private int calculateTotalPrize(int[] prizeCounts)`: 각 등수별로 얻을 수 있는 총 상금을 계산하는 메소드
  - `private void printPrizeCounts(int[] prizeCounts)`: 각 등수별 일치한 번호 개수와 상금을 출력하는 메소드
  - `private int countMatchingNumbers(Lotto userNumbers, Lotto winNumbers)`: 사용자가 선택한 로또 번호와 당첨 번호를 비교하여 일치한 번호 개수를 계산하는 메소드

### 실행 결과 예시

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

---
