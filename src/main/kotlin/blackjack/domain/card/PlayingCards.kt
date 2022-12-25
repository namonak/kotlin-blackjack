package blackjack.domain.card

import blackjack.domain.card.strategy.ShuffleStrategy

@JvmInline
value class PlayingCards(private val list: List<PlayingCard>) {
    constructor(vararg playingCards: PlayingCard) : this(playingCards.toList())

    fun add(card: PlayingCard): PlayingCards {
        if (list.contains(card)) {
            throw IllegalArgumentException("중복된 카드는 추가할 수 없습니다.")
        }
        return PlayingCards(list + card)
    }

    fun isBust(): Boolean {
        return list.sumOf { it.score() } > BLACKJACK_NUMBER
    }

    fun isBlackjack(): Boolean {
        val isSizeOfBlackjack = list.size == BLACKJACK_SIZE
        val isAceAndTen = list.any { it.isAce() } && list.any { it.score() == TEN }
        return isSizeOfBlackjack && isAceAndTen
    }

    fun isStay(): Boolean {
        val isBiggerThanBlackjackSize = list.size >= BLACKJACK_SIZE
        val isLessThanWinningNumber = list.sumOf { it.score() } <= BLACKJACK_NUMBER
        return isBiggerThanBlackjackSize && isLessThanWinningNumber
    }

    fun getScore(): Int {
        if (isBlackjack()) {
            return BLACKJACK_NUMBER
        }
        return list.sumOf { it.score() }
    }

    fun size(): Int {
        return list.size
    }

    fun toListString(): List<String> {
        return list.map { it.toString() }
    }

    companion object {
        fun shuffle(shuffleStrategy: ShuffleStrategy): List<PlayingCard> {
            return shuffleStrategy.shuffle()
        }

        private const val BLACKJACK_NUMBER = 21
        private const val BLACKJACK_SIZE = 2
        private const val TEN = 10
    }
}
