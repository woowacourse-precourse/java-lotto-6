## 로또 프로그램
### 로또 프로그램의 흐름
1. 구입 금액 입력받아서 1000으로 나누기 -> 구입횟수에 저장
2. 1~45의 pool에서 구입횟수만큼 6개 번호세트 랜덤으로 생성하기 -> 1회마다 번호들 리스트에 저장후, 출력하기
3. 당첨번호 입력받기 -> 당첨번호 리스트에 저장
4. 보너스 번호 입력받기 -> 보너스 번호에 저장
5. 당첨 통계 계산하기 -> 번호들 리스트 순회하면서 .contains로 당첨번호랑 보너스 숫자랑 일치 갯수 세기
6. 당첨 결과 출력하기 -> 소숫점 2자리 수에서 반올림 
- 3개 일치 (5,000원) - 1개 
- 4개 일치 (50,000원) - 0개
- 5개 일치 (1,500,000원) - 0개
- 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
- 6개 일치 (2,000,000,000원) - 0개

### LottoGame
- LottoGame(String) :
  구입 금액을 입력받아 1000으로 나눈 결과를 lottoQuantity에 저장한다.
  입력 스트링에서 숫자가 아닌 문자 포함시 "[ERROR] 숫자로만 입력해 주세요."가 출력된다.
  1000으로 나눠떨어지지 않으면 "[ERROR] 금액이 1000원으로 나누어 떨어지지 않아요."가 출력된다.
- validateDigit(char) : 입력값이 숫자가 아니라면 IllegalArgumentException을 발생시킨다.
- validateRemainder(int) : 입력값이 1000으로 나눴을 때 나머지가 0이 아니라면 IllegalArgumentException을 발생시킨다.

- createLottos() : 
  구입 횟수에서 1씩 차감하며 Lotto를 생성해 lottos에 저장한다.
  1씩 차감하는 이유는 해당 메서드가 public이기 때문에 다시 어딘가에서 원치 않는 호출로 다시 로또 번호가 생성됨을 막기 위함이다.
  lottoQuantity가 0이면 "[ERROR] 구입 금액이 0이면 로또번호를 생성할 수 없습니다."가 출력된다.

- setWinNumbers(List<Integer>) :
  정수형 리스트을 입력으로 받아 당첨번호를 저장한다.
- setBonusNumber(int) :
  정수를 입력으로 받아 보너스 번호를 저장한다.
  당첨번호와 비교해서 중복되는 것이 있으면 "[ERROR] 보너스 번호는 당첨번호와 중복될 수 없어요."가 출력된다.
- validateBonusNumber(int) : 입력값이 당첨 번호와 중복되면 IllegalArgumentException을 발생시킨다.

- findWinnerLottos : 3,4,5,6개 일치하는 것과 5개와보너스1개 일치하는거 합쳐서 string으로 변환
- countWithWinNumber : 3,4,5,6개 일치하는 것 세서 winnerQuantity<종류, 갯수>로 저장하기 
- countWithBonusNumber : 5개와 보너스 1개 일치하는 것 세서 winnerQuantity<종류, 갯수>로 저장하기

### Lotto
- Lotto(List<Integer>) : 
  정수형 리스트를 받아 검증한 뒤 numbers에 저장한다.
  입력 받은 리스트의 길이가 6이 아니면 "[ERROR] 로또 번호는 6개로 이루어져 있어야 해요."가 출력된다.
  입력 받은 리스트에 중복된 숫자가 포함되면 "[ERROR] 로또 번호는 중복된 숫자가 있으면 안돼요."가 출력된다.

### GameScreen
- runGame() : 
  로또 게임의 입출력 UI를 담당한다. 
  에러가 발생하면 정상적인 입력이 들어올 때까지 입력을 다시 받는다.
- initialize() : 구입급액을 입력받아 LottoGame을 생성한다. 
- printLottos() : 구매한 횟수만큼 로또를 출력한다.

- inputWinNumbers(String) : 쉼표로 구분되는 정수가 나열된 문자열을 쉼표로 나눠 List<Integer>형태의 리스트를 반환한다.
  나열된 문자열이 각각 숫자가 아니면 "[ERROR] 당첨 번호는 숫자로 입력해 주세요."가 출력된다.
  나열된 문자열의 길이가 6이 아니면 "[ERROR] 당첨 번호는 6개여야 해요."가 출력된다.
  나열된 문자열의 각 요소가 1~45 범위 안에 있지 않으면 "[ERROR] 각 번호는 1에서 45의 범위 안으로 입력해 주세요."가 출력된다.
  입력된 문자열에 에러가 없을 때까지 다시 입력을 받는다.
- validateWinNumberLength(String[]) : 입력값의 길이가 6이 아니라면 IllegalArgumentException을 발생시킨다.
- validateWinNumberType(String[]) : 입력값이 숫자로 표현된 것이 아니라면 IllegalArgumentException을 발생시킨다.
- validateWinNumberRange(String[]) : 입력값이 1~45 범위 안에 있지 않으면 IllegalArgumentException을 발생시킨다.

- inputBonusNumber : 정수로 표현된 문자열을 받아 정수로 반환한다. 
  입력받은 문자열의 길이가 1이 아니면 "[ERROR] 보너스 번호는 1개여야 해요."가 출력된다.
  입력받은 문자열이 숫자로 표현되지 않으면 "[ERROR] 보너스 번호는 숫자로 입력해 주세요."가 출력된다.
  입력받은 문자열이 1~45 범위 안에 있지 않으면 "[ERROR] 보너스 번호는 1에서 45의 범위 안으로 입력해 주세요."가 출력된다. 
  입력된 문자열에 에러가 없을 때까지 다시 입력을 받는다.
- validateBonusNumberLength(String[]) : 입력값의 길이가 1이 아니라면 IllegalArgumentException을 발생시킨다.
- validateBonusNumberType(String[]) : 입력값이 숫자로 표현된 것이 아니라면 IllegalArgumentException을 발생시킨다.
- validateBonusNumberRange(String[]) : 입력값이 1~45 범위 안에 있지 않으면 IllegalArgumentException을 발생시킨다.
