# 로또

## 구현 기능 목록

### Application
* main: 기능을 종합하여 로또를 구매한다.

### Purchase
* makePurchase: 유효하지 않은 구입금액에 대해 입력을 반복한다.
* validatePrice: 구입금액의 유효성을 검증한다.

### Lotto
* Lotto: final로 선언된 변수를 초기화하는 생성자이다.
* validate: 로또 1장의 유효성을 검증한다.
* produceLottoTicket: 1부터 45까지의 수 중 서로 다른 6개의 수를 뽑아 오름차순으로 로또 1장을 만들어 반환한다.
* showLottoTicket: 생성된 로또 1장을 출력한다.
* gatherLottoTickets: List를 생성하여 주어진 quantity만큼 로또를 생성해 집어 넣은 후 반환한다.
* contains: 인자로 들어온 수가 포함되어있는지 여부를 반환한다.
* getNumbers: Lotto를 구성하고 있는 수의 List를 반환한다.

### UserPick
* userLottoNumbers: 유저의 당첨 번호 입력을 받고 List 형태로 반환한다.
* userBonusNumber: 유저의 보너스 번호 입력을 받고 번호를 반환한다.
* pickLottoNumbers: 유효하지 않은 당첨 번호에 대해 입력을 반복한다.
* pickBonusNumbers: 유효하지 않은 보너스 번호에 대해 입력을 반복한다.
* parseLottoNumbers: 입력한 당첨 번호를 파싱한다.
* parseBonusNumber: 입력한 보너스 번호를 파싱한다.

### Validator
* validateSeparatedLottoNumbers: 분리된 당첨 번호의 유효성을 검증한다.
* validateBonusNumber: 보너스 번호의 유효성을 검증한다.
* validateRange: 인자로 들어온 수의 범위 유효성을 검증한다.

### LottoResult
* announceLottoResult: 당첨된 로또의 전체 내용을 출력한다.
* compareToPrize: 로또당 당첨된 결과와 Prize를 대조하여 출력한다.
* repeatCheckingLotto: 로또 목록을 순회하며 로또당 당첨된 결과를 반환한다.
* initiatePrizeCounts: Prize 항목별로 당첨된 횟수가 담긴 List를 0으로 초기화한다.
* checkBonus: Prize와 대조해 보너스 번호가 사용되었는지 확인한다.
* checkLotto: Prize와 대조해 당첨 여부를 확인한다.
* countMatchedNumbersTest: 생성된 로또와 유저가 입력한 당첨 번호간 겹치는 횟수를 구한다.

### Prize
* getMatchedNumbers: 당첨 항목의 일치 개수를 반환한다.
* getFormattedPrizeMoney: 당첨 항목의 상금을 지정한 양식에 맞춰 문자열로 반환한다.
* checkBonus: 보너스 번호가 포함된 항목인지 확인한다.
* getPrizeMoney: 상금을 반환한다.

### Profit
* announceProfitResult: 메서드를 종합하여 수익률을 출력한다.
* formatProfitRate: 수익률을 소수점 둘째 자리에서 반올림한다.
* calculateProfitRate: 수익률을 계산한다.
* calculateTotalPrize: 당첨된 내용을 받아 총 상금을 계산한다.

### Result
* showTotalResult: 당첨된 로또 목록과 수익률을 출력한다.

## 요구 사항 체크리스트
### 기능 요구 사항
<ul>
    <li>입력한 금액만큼 로또를 발행했는가</li>
    <li>로또 1장의 가격은 1,000원인가</li>
    <li>당첨 번호와 보너스 번호를 입력받았는가</li>
    <li>사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료하였는가</li>
    <li>사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 "[Error]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받았는가</li>
</ul>

### 프로그래밍 요구 사항
<ul>
    <li>indent depth가 2 이하인가</li>
    <li>3항 연산자를 쓰지 않았는가</li>
    <li>함수(또는 메서드)가 한 가지 일만 하였는가</li>
    <li>구현 기능목록을 테스트 코드로 확인하였는가</li>
    <li>함수(또는 메서드)의 길이가 15라인을 넘어가지 않았는가</li>
    <li>else 예약어를 쓰지 않았는가</li>
    <li>Java Enum을 적용하였는가</li>
    <li>도메인 로직의 단위 테스트를 구현하였는가</li>
    <li>핵심 로직을 구현하는 코드와 UI를 담당하는 로직이 분리되었는가</li>
</ul>

## 공통 피드백 체크리스트
<ul>
    <li>README.md를 상세히 작성하였는가</li>
    <li>기능 목록을 재검토하였는가</li>
    <li>기능 목록을 업데이트하였는가</li>
    <li>값을 하드 코딩하지 않았는가</li>
    <li>상수, 멤버 변수, 생성자, 메서드 순으로 작성 하였는가</li>
    <li>변수 이름에 자료형을 사용하지 않았는가</li>
    <li>한 함수가 한 가지 기능만 담당했는가</li>
    <li>테스트를 작성하는 이유에 대해 생각해 보았는가</li>
    <li>핵심 기능에 가까운 부분부터 작게 테스트를 만들었는가</li>
</ul>