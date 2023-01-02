package blackjack.domain.card.state.rule

import blackjack.domain.card.PlayingCards
import blackjack.domain.card.state.Finished

class Stay(cards: PlayingCards) : Finished(cards) {
    override val rate: Double = 1.0

    init {
        require(cards.isStay()) { "스테이가 아닙니다." }
    }
}
