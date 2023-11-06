# 💡 로또 게임 구현하기

이 로또 게임 프로그램에서 사용자는 로또를 구매하기 위해 금액을 입력하고 예상 당첨 번호를 제출합니다. 
프로그램은 사용자의 예상 번호와 실제 당첨 번호를 비교하여 당첨 여부를 결정하고, 구매한 로또의 수익률을 계산합니다. 
유효하지 않은 입력에 대해서는 오류 메시지를 출력하여 사용자가 올바르게 입력할 수 있도록 안내합니다.


<img width="850" alt="image" src="https://github.com/2021110806/java-lotto-6/assets/104808812/3155e05f-ea66-4cbc-a521-622eb14c2ba0">


## 📁 PACKAGES & FUNCTIONS 🔧
### 📌 Model
#### Lotto class
    - lottoNumber 필드에 당첨 번호를 저장한다. ✅
    - lottoNumber 필드의 유효성을 검사한다. ✅
#### WinningLotto class extends Lotto class
    - bonusNumber 필드에 보너스 번호를 저장한다. ✅
    - bonusNumber 필드의 유효성을 검사한다. ✅
#### User class
    - money 필드에 사용자가 입력한 금액을 저장한다. ✅
    - money 필드의 유효성을 검사한다. ✅
    - 로또를 생성할 때마다 사용자의 money 필드를 감소시킨다.
#### LottoGame
    - 사용자가 입력한 금액에 따라 로또를 생성한다.
    - 각 금액 별 당첨 된 로또의 개수를 센다.
    - 수익률을 계산한다.
### 📌 Controller
#### LottoGameController
    - LottoGame을 실행한다.
#### LottoController
    - Lotto class와 LottoGame class를 매개한다.
#### UserController
    - User class와 LottoGame class를 매개한다.
### 📌 VIEW
#### InputView
    - 로또 구입 금액을 입력 받는다. 
    - 당첨 번호를 입력 받는다.
    - 보너스 번호를 입력 받는다.
#### OutputView
    - 구입 금액 입력 안내 메시지를 출력한다.
    - 구매 안내 메시지를 출력한다.
    - 당첨 번호 입력 안내 메시지를 출력한다.
    - 당첨 통계를 출력한다.
### 📌 EXCEPTION
#### ExceptionMessage
    - [ERROR] 로또 구입 금액은 1,000원 이상 1,000,000,000원 이하여야 합니다. 
    - [ERROR] 로또 구입 금액은 숫자로만 구성되어야 합니다.  
    - [ERROR] 로또 구입 금액은 1,000원으로 나누어 떨어져야 합니다. 
    - [ERROR] 당첨 번호는 숫자로만 이루어져 있어야 합니다. 
    - [ERROR] 당첨 번호는 1 이상 45 이하여야 합니다. 
    - [ERROR] 당첨 번호는 쉼표로 구분하여 6개 입력해야 합니다. 
    - [ERROR] 당첨 번호에 중복된 숫자가 입력되어서는 안됩니다. 
    - [ERROR] 보너스 번호는 숫자로만 이루어져 있어야 합니다.
    - [ERROR] 보너스 번호는 1 이상 45 이하여야 합니다.
    - [ERROR] 올바른 입력이 아닙니다.
