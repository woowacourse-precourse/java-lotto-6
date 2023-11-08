## 🎰 로또 기능 명세서

### 📃구현 기능 목록
- 로또 생성
  - ✅ 로또 구입 금액을 입력받는다.
    - <span style="color:orange">[예외 사항]</span> 숫자가 아닌 경우 exception 발생시킨다.
    - <span style="color:orange">[예외 사항]</span> 음수인 경우 exception 발생시킨다.
    - <span style="color:orange">[예외 사항]</span> 1000원 단위가 아닌 경우 exception 발생시킨다.
    - <span style="color:orange">[예외 사항]</span> 공백을 입력할 경우 exception 발생시킨다.
    - exception이 발생하면 다시 입력을 받는다.
  - ✅ 로또 금액만큼 로또 객체를 할당한다.
    - 로또 번호가 오름차순이 아니라면 오름차순으로 정렬한다.
  - ✅ 할당한 로또 번호를 출력한다.
  - ✅ 당첨 번호와 보너스 번호를 입력받는다.
    - <span style="color:orange">[예외 사항]</span> 공백이 들어가면 exception 발생시킨다.
    - <span style="color:orange">[예외 사항]</span> 숫자가 아닌 값이 입력되면 exception 발생시킨다.
    - <span style="color:orange">[예외 사항]</span> 중복된 숫자가 입력되면 exception 발생시킨다.
    - <span style="color:orange">[예외 사항]</span> 숫자가 허용된 범위에서 벗어나면 exception 발생시킨다.
    - exception이 발생하면 다시 입력을 받는다.
-✅ 로또 게임 생성
  - 입력받은 당첨 번호와 보너스 번호를 가지는 로또 객체를 생성한다.
- 당첨 통계 출력
  - ✅ 로또 객체와 게임 객체의 값을 비교한다.
  - ✅ 당첨 결과를 출력한다
  - ✅ 결과를 바탕으로 수익률을 계산한다.
  - ✅ 수익률을 출력한다.

## 📚 구현 기능 명세
### LottoController
| Method | Description                                 |
|:------:|---------------------------------------------|
|  run   | 다양한 비지니스 로직과 view를 호출하고 값을 전달하는 flow를 담당한다. |

### InputController
|          Method          | Description                                 |
|:------------------------:|---------------------------------------------|
| inputLottoPurchaseAmount | 올바른 구매 금액을 입력받는다면, lottoDto에 구매 금액을 저장한다.   |
|     getInputPurchase     | inputView에서 구매 금액을 입력받아 반환한다.               |
|   inputWinningNumbers    | 올바른 당첨 번호를 입력받는다면, lottoDto에 당첨 번호를 저장한다.   |
|     getInputWinning      | inputView에서 당첨 번호를 입력받아 반환한다.               |
|     inputBonusNumber     | 올바른 보너스 번호를 입력받는다면, lottoDto에 보너스 번호를 저장한다. |
|      getInputBonus       | inputView에서 보너스 번호를 입력받아 반환한다.              |

### LottoService
|             Method              | Description                                    |
|:-------------------------------:|------------------------------------------------|
|          createLottos           | 로또 구매 금액만큼 로또 객체를 할당한다.                        |
|          getLottoCount          | 로또 구매 금액에 따라 할당할 로또 객체의 개수를 계산해 반환한다.          |
|            getLottos            | lottos를 반환한다.                                  |
|           createGame            | saveGame을 호출해 game 객체를 생성한다.                   |
| compareLottosWithWinningNumbers | 모든 로또 객체를 당첨 번호와 비교한다.                         |
|      compareWinningNumbers      | lotto의 로또 번호와 당첨 번호를 비교하고 LotteryResultState을 update한다. |
|            getResult            | 각 LotteryResultState을 가지는 lotto의 개수를 저장하는 result를 반환한다. |
|          getProfitRate          | 수익률을 계산해 반환한다.                                 |

### LottoRepository
|   Method   | Description             |
|:----------:|-------------------------|
| saveLotto  | lotto 객체를 lottos에 저장한다. |
| findLottos | lottos를 반환한다.           |
|  saveGame  | Game 객체를 생성한다.          |
|  findGame  | Game 객체를 반환한다.          |

### Validator
|             Method             | Description                           |
|:------------------------------:|---------------------------------------|
|  lottoPurchaseAmountValidator  | 구매 금액 입력값의 유효성을 검사한다                  |
|    isCorrectPurchaseAmount     | 구매 금액이 미리 컴파일된 정규 표현식과 일치하는 지 검사한다.   |
|      lottoNumberValidator      | 로또 번호의 유효성을 검사한다.                     |
|     isCorrectLottoNumbers      | 로또 번호가 미리 컴파일된 정규 표현식과 일치하는 지 검사한다.   |
|      isDuplicatedNumbers       | 로또 번호에 중복이 없는 지 검사한다.                 |
|      bonusNumberValidator      | 보너스 번호 입력값의 유효성을 검사한다.                |
|   isCorrectInputBonusNumber    | 보너스 번호가 미리 컴파일 된 정규 표현식과 일치하는 지 검사한다. |
| isDuplicatedWithWinningNumbers | 당첨 번호와 중복이 있는 지 검사한다.                 |

### Lottos
|       Method       | Description                                                       |
|:------------------:|-------------------------------------------------------------------|
|      addLotto      | 매개변수로 받은 로또 번호를 가지는 로또 객체를 지역 변수 list에 저장한다.                      |
|    isSortedList    | 매개변수로 받은 로또 번호를 오름차순으로 정렬한다.                                      |
|    getAllLotto     | 로또 객체를 저장하고 있는 list를 반환한다.                                        |
| increaseStateCount | 매개변수로 받은 LotteryResultState에 매칭되는 countByState의 Count을 1 증가시킨다.   |
|    getAllResult    | LotteryResultState를 몇개의 로또 객체가 가지는 지를 count하는 countByState를 반환한다. |

### Lotto
|   Method   | Description              |
|:----------:|--------------------------|
|  validate  | 로또 객체의 로또 번호의 유효성을 검사한다. |
| getNumbers | 저장된 로또 번호를 반환한다.         |

### Game
|        Method         | Description              |
|:---------------------:|--------------------------|
| isSortedWinningNumber | 매개변수 당첨 번호를 오름차순으로 정렬한다. |
|   getWinningNumbers   | 저장된 당첨 번호를 반환한다.         |
|    getBonusNumber     | 저장된 보너스 번호를 반환한다.        |

### LotteryResultState
| Method  | Description                                         |
|:-------:|-----------------------------------------------------|
| valueOf | 당첨 번호와 일치하는 번호 개수와 보너스 번호와 일치 여부를 통해 해당되는 상태를 반환한다. |


### LottoDto
|         Method         | Description         |
|:----------------------:|---------------------|
| getLottoPurchaseAmount | 저장된 로또 구매 금액을 반환한다. |
| setLottoPurchaseAmount | 로또 구매 금액을 저장한다.     |
|   getWinningNumbers    | 저장된 당첨 번호를 반환한다.    |
|   setWinningNumbers    | 당첨 번호를 저장한다.        |
|     getBonusNumber     | 저장된 보너스 번호를 반환한다.   |
|     setBonusNumber     | 보너스 번호를 저장한다.       |

