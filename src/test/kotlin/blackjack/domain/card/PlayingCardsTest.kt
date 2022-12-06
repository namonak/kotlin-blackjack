package blackjack.domain.card

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PlayingCardsTest {
    @Test
    fun `카드 목록 - 추가 테스트`() {
        // given
        val playingCards = PlayingCards(listOf())

        // when
        playingCards.add(PlayingCard(Suit.CLUBS, Denomination.ACE))

        // then
        assertThat(playingCards.list).isEqualTo(listOf(PlayingCard(Suit.CLUBS, Denomination.ACE)))
    }

    @Test
    fun `카드 목록 - 추가 실패 예외처리 테스트, 카드를 중복 입력하는 경우`() {
        // given
        val playingCards = PlayingCards(listOf(PlayingCard(Suit.CLUBS, Denomination.ACE)))

        // when
        val exception = assertThrows<IllegalArgumentException> {
            playingCards.add(PlayingCard(Suit.CLUBS, Denomination.ACE))
        }

        // then
        assertThat(exception.message).isEqualTo("중복된 카드는 추가할 수 없습니다.")
    }

    @Test
    fun `카드 목록 - 삭제 테스트`() {
        // given
        val playingCards = PlayingCards(listOf(PlayingCard(Suit.SPADES, Denomination.ACE)))

        // when
        playingCards.get()

        // then
        assertThat(playingCards.list).isEmpty()
    }

    @Test
    fun `카드 목록 - 삭제 실패 예외처리 테스트, 카드가 없는 경우에 삭제하는 경우`() {
        // given
        val playingCards = PlayingCards(listOf())

        // when
        val exception = assertThrows<NoSuchElementException> {
            playingCards.get()
        }

        // then
        assertThat(exception.message).isEqualTo("카드가 없습니다.")
    }
}
