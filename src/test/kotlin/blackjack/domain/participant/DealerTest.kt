package blackjack.domain.participant

import blackjack.domain.card.Denomination
import blackjack.domain.card.PlayingCard
import blackjack.domain.card.PlayingCards
import blackjack.domain.card.Suit
import blackjack.domain.card.state.rule.Blackjack
import blackjack.domain.card.state.rule.Hit
import blackjack.domain.participant.state.Name
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DealerTest {
    @Test
    fun `딜러 - 생성 테스트, 블랙잭`() {
        // given
        val cards = PlayingCards(PlayingCard(Suit.CLUBS, Denomination.ACE), PlayingCard(Suit.CLUBS, Denomination.JACK))
        val dealer = ParticipantFactory.create(Name("딜러"), cards)

        // when, then
        assertThat(dealer.state is Blackjack).isTrue
    }

    @Test
    fun `딜러 - 생성 테스트, 히트`() {
        // given
        val cards = PlayingCards(PlayingCard(Suit.CLUBS, Denomination.TEN), PlayingCard(Suit.CLUBS, Denomination.JACK))
        val dealer = ParticipantFactory.create(Name("딜러"), cards)

        // when, then
        assertThat(dealer.state is Hit).isTrue
    }
}