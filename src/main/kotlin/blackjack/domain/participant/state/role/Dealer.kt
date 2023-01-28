package blackjack.domain.participant.state.role

import blackjack.domain.bet.Money
import blackjack.domain.card.PlayingCards
import blackjack.domain.card.state.State
import blackjack.domain.participant.state.Name
import blackjack.domain.participant.state.result.Result

data class Dealer(override val state: State) : Role() {
    override val name: Name = Name(DEALER_NAME)

    override val money: Money = Money(0)

    override val isDealer: Boolean = true

    constructor(cards: PlayingCards) : this(initState(cards))

    init {
        require(state.cards.size >= NUMBER_OF_STARTING_CARDS) { "딜러는 2장의 카드를 가지고 시작해야 합니다." }
    }

    fun calculateResult(player: Role): Result {
        return when {
            isBlackjack && player.isBlackjack -> Result.Draw
            isBlackjack && !player.isBlackjack -> Result.Lose
            isBust && player.isBust -> Result.Lose
            isBust && !player.isBust -> Result.Win
            else -> this.compareScore(player.score)
        }
    }

    private fun compareScore(playerScore: Int): Result {
        return when {
            playerScore > score -> Result.Win
            playerScore == score -> Result.Draw
            else -> Result.Lose
        }
    }

    companion object {
        const val STOP_SCORE = 16
        const val DEALER_NAME = "딜러"
    }
}
