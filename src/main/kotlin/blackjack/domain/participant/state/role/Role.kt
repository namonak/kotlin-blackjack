package blackjack.domain.participant.state.role

import blackjack.domain.bet.Money
import blackjack.domain.card.PlayingCard
import blackjack.domain.card.PlayingCards
import blackjack.domain.card.state.State
import blackjack.domain.card.state.rule.Blackjack
import blackjack.domain.card.state.rule.Hit
import blackjack.domain.participant.state.Name

sealed class Role {
    abstract val name: Name

    abstract val state: State

    abstract val money: Money

    abstract val isDealer: Boolean

    val score: Int
        get() = state.cards.getScore()

    val isBlackjack: Boolean
        get() = state.cards.isBlackjack()

    val isBust: Boolean
        get() = state.cards.isBust()

    val cards: List<String>
        get() = state.cards.toListString()

    val hasOnlyTwoCards: Boolean
        get() = state.cards.size == NUMBER_OF_STARTING_CARDS

    val earningRate: Double
        get() = state.earningRate(money)

    fun draw(playingCard: PlayingCard): Role {
        if (isDealer) {
            return Dealer(state.draw(playingCard))
        }
        return Player(name, state.draw(playingCard), money)
    }

    fun stay(): Role {
        if (!isBust && !isBlackjack) {
            return doStay()
        }
        return this
    }

    private fun doStay(): Role {
        if (isDealer) {
            return Dealer(state.stay())
        }
        return Player(name, state.stay(), money)
    }

    companion object {
        internal const val NUMBER_OF_STARTING_CARDS = 2

        fun initState(cards: PlayingCards): State {
            if (cards.isBlackjack()) {
                return Blackjack(cards)
            }
            return Hit(cards)
        }
    }
}
