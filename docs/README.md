# 미션 - 로또

## 개요

> 미션 **"로또"** 는 1~45 숫자 중 랜덤 수 6개를 사용자 금액에 맞게 6개의 수를 각각 자동으로 받으며, 이후 당첨번호 6개 그리고
> 보너스 번호를 통해서 구매한 로또 번호와 당첨번호를 비교해서 당첨 내역
> 및 수익률을 알려주는 게임이다.

하나의 도메인 테스트시 <mark>작은 단위 테스트 부터 시작하며, 통합 테스트까지 구현 후, 예외 테스트를 추가</mark>하여 기능 구현에 만족한다.
________

## 🚀 기능 구현 과정

> main `README` 를 기준으로 요구사항 테스트 및 기능 구현을 하고, TDD 원칙을 따른다.

## 게임 흐름

- `게임시작 & 입력 -> 출력` 과정을 통해 `로또 당첨 내역과 수익률`을 알 수 있다.

### 게임 시작 & 입력

- `InputView` 클래스 - <b> 입력</b>
    - [x] 로또를 구매하기 위한 사용자 입력 기능
    - [x] 로또 재구매 기능


- `LottoController` 클래스 `run`메서드를 통해 게임 진행 - <b>게임시작 </b>
    - [x] `divisionLottoPrice()` 로또 금액이 1000으로 나누어 떨어지는 확인 이후 나눈 값을 리턴
    - [x] `createLottoGenerate()` 메서드는  `divisionLottoPrice()`에서 리턴 받은 값 만큼 순회하면서 `로또 번호를 받은 이후`, 오름차순으로 정렬해서 `LottoDto`
      해서 저장 참조값 생성


- `LottoService` 클래스
    - [x] `createwinningNumbers()` 중복 제거 및 당첨 번호 입력 기능
    - [x] `createBonusNumber()` 보너스 번호 입력 기능
        - [x] 보너스 번호 와 당첨 번호 중복 체크
        - [x] 재입력 기능 추가
    - [x] `findWinners()`는 당첨번호, 보너스 번호를 매개변수로 받아, `LottoDto`안에 넣어두었던 `랜덤 로또 번호` 와 비교하여 값을 체크하는 기능
        - 비교하는 기능은 `LottoDto`안에서 시작
        - `LottoDto`안에 `랜덤 로또 값`이랑 비교
        - [x] 랜덤 로또 값을 하나씩 순회하며 당첨 번호 와 비교
            - [x] 만약 보너스 번호가 포함 되어 있으면 `bonusCount` 1증가
            - [x] 만약 `matchLottoCount`의 값 5 와 `bonusCount` 의 값이 1일때 임의로 bonusCount는 값을 0 으로 하고 matchLottoCount는 7로 변경한다.
            - [x] 구한 값 들을 `Map` 안에 넣어준다.

### 로또 상수화

- [x] ErrorMsg eunm 클래스 추가
- [x] `default` 로또 상수 메시지 클래스 추가
- [x] `Lotto` 출력 관련 enum 클래스 추가
- [x] `LottoCount`로또 당첨 가격 관련 `enum` - `OutView` 출력을 위한 주요 EnumClass
    - `String priceMsg`- 당첨내역 출력 메시지
    - `count` - 메세지에 해당하는 숫자
    - `matchesCount` - `Map<Integer,Integer>`에 `Key` 값 과 비교하여 같으면 증가하는 값
    - `multiple` - `LottoCount`의 values 를 `outView`에서 순회하게되는데 하나의 순회가 끝날때 쯤 `matchesCount`
      값과 `priceMsg`안에 가격을 서로 곱해준다. -`LottoCount.calculateTotalPrizeAmount()`
        - ex) ...3000 * 2)

### 입력 및 출력

- `OutView` 클래스 - <b>출력</b>
    - [x] `winnerMsg`는 `findWinners`에서 리턴받은 값, 구매했을 당시 값을 매개변수로 받는다.
        - 이후 리턴받은 `Map<Integer,Integer>` 를 순회하면서 체크 시작
        - `countMatchesAndIncrementLottoCount()` - Map 순회 메서드 시작
            - 먼저 `keySet`을 통해 Key 값과 `LottoCount 안에 Enum 필드인`의 `count`랑 비교후 일치하면 해당 `priceMsg`
              출력하고 당첨내역은`priceMsg`를 통해 당첨 내역 출력 이후,몇개 당첨 되었는지 개수 `matchesCount`를 통해 보여진다. -
        - 총 수익률은 `showLateMsg` 메서드를 실행
            - 해당 값은 `LottoCount`를 순회하며 `multiple` 값을  `getAllSumMultiple`변수에 다 더한다.
            - `(getAllSumMultiple * 로또 구매한 가격) * 100`  -> 왼쪽 과 같은 공식을 통해 `수익률 측정`
    - [x] 출력 공통 메시지 메서드 추가
    - [x] 당첨 통계 메시지 추가
    - [x] 총 수익률 메시지 추가

### 로또 Utils

- [x] 로또 구매 기능 구현
- [x] 1~45까지 랜덤 수 6개 가져오는 기능 구현

---

## 테스트 목록 및 예외 테스트

### 사용자 입력 및 출력

- 사용자 입력 테스트 `test/java/view/InputViewTest`
    1. 입력으로 받는 공통
        - [x] 숫자 외 문자 출력
    2. 로또 구입 금액 입력
        - [x] 입력한 금액이 1000원 이하일 경우 <mark>예외 처리</mark>
        - [x] 입력한 금액이 1000원으로 나누어 떨어지지 않았을 경우 <mark>예외 처리</mark>
        - [x] 당첨금액 재입력 처리
    3. 당첨 번호 입력
        - [x] 입력 된 숫자가 45 이상일 경우 <mark>예외 처리 </mark>
- 사용자 출력 테스트 `test/java/view/OutViewTest`
    1. [x] 총 수익률

### 로또 기능 구현

- 로또 도메인 테스트 `test/java/lotto/LottoTest`
    - [x] 로또 중복 테스트 기능 구현
    - [x] 로도 번호가 45이상일 경우 <mark>예외 처리 </mark>
    - [x] 로또 번호랑 매치되는 숫자의 합계를 구하는 기능 구현

