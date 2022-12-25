package blackjack.domain.player

import blackjack.domain.card.PlayingCard
import blackjack.domain.card.state.State
import blackjack.domain.player.state.role.DealerRole

data class Dealer(override val state: State) : DealerRole() {
    override fun draw(playingCard: PlayingCard): Player {
        TODO("Not yet implemented")
    }

    override fun stay(): Player {
        TODO("Not yet implemented")
    }
}
