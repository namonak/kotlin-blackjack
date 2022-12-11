# kotlin-blackjack

## 2단계 - 블랙잭

### 기능목록

- [x] 플레이어 이름 입력
  - [x] 플레이어 이름은 5자 이하만 가능하다.
  - [x] 플레이어 이름은 빈 문자열이거나 공백이 있을 수 없다.
  - [x] 플레이어 이름은 알파벳만 가능하다.
  - [x] 플레이어 이름은 쉼표(,)를 기준으로 구분한다.
  - [x] 플레이어 이름은 1개 이상 입력해야 한다.
  - [x] 플레이어 이름은 중복될 수 없다.
- [x] 카드 구성
  - [x] 카드는 52장이며, 4가지 무늬와 13가지 숫자를 가진다.
  - [x] 카드의 숫자 계산은 카드 숫자를 기본으로 한다.
    - [x] 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다.
- [x] 카드 덱
  - [x] 카드 덱은 52장의 카드로 구성된다.
  - [x] 카드 덱은 셔플이 가능하다.
  - [x] 카드 덱은 카드를 하나씩 뽑을 수 있다.
  - [x] 카드 덱에 카드가 없을 경우에, 카드를 뽑는 경우 예외를 발생시킨다.
- [x] 게임 진행
  - [x] 모든 플레이어는 최초에 2장의 카드를 받는다.
    - [x] 모든 플레이어가 최초에 받은 카드를 콘솔에 출력한다.
  - [ ] 입력된 플레이어 순서대로 카드를 추가로 받을지 여부를 묻는다.
    - [ ] 카드를 추가로 받을지 여부가 선택되면, 결과를 콘솔에 출력한다.
    - [ ] 추가로 카드를 받을 경우, 21을 초과하지 않는 한 계속 받을 수 있다. 
  - [ ] 모든 플레이어가 뽑은 카드의 합을 구할 수 있다.
  - [ ] 모든 플레이어가 카드를 받지 않는 경우, 게임을 종료한다.
    - [ ] 게임이 종료될 때 게임 결과를 출력한다.
- [ ] 게임 세부 규칙
  - [ ] 카드 총합이 21점 또는 21점에 가장 가깝게 만들면 승리한다.
  - [x] 처음 받은 2장의 카드 합이 21점이면 승리한다. - 블랙잭(Blackjack)
  - [x] 카드의 총합이 21점을 초과하면 패배한다. - 버스트(Bust)
  - [x] 처음 2장의 카드를 받은 상태에서 추가로 카드를 받을 수 있다. - 히트(Hit)
  - [x] 추가로 카드를 받지 않고 차례를 넘길 수 있다. - 스탠드(Stay)
- [x] 예외 처리
  - [x] 카드 목록에 중복된 카드를 추가하는 경우 `IllegalArgumentException`을 발생시킨다.
  - [x] 빈 카드 목록에서 카드를 꺼내려고 할 경우 `NoSuchElementException`을 발생시킨다.

### 기능 요구 사항

블랙잭 게임을 변형한 프로그램을 구현한다. 블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.
 - 카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다.
 - 게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며, 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다. 21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다.
