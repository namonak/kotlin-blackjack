package blackjack.controller

import blackjack.application.Deck
import blackjack.domain.card.strategy.ShuffledDeckGenerateStrategy
import blackjack.domain.player.Player
import blackjack.domain.player.PlayerFactory
import blackjack.domain.player.Players
import blackjack.dto.PlayerDto
import blackjack.dto.PlayersDto
import blackjack.view.ResultView

object Controller {
    private const val MINIMUM_NUMBER_OF_CARDS = 2

    fun start() {
        val deck = Deck(ShuffledDeckGenerateStrategy())
        val names = InputFilter.inputPlayer()
        val players = PlayerFactory.create(names, deck)

        init(players)
        checkBlackjack(players)
        play(players, deck)
        end(players)
    }

    private fun init(players: Players) {
        ResultView.printGameStartMessage(PlayersDto(players).getNames())
        PlayersDto(players).getPlayers().forEach {
            ResultView.printPlayerCards(it)
        }
        ResultView.printLineFeed()
    }

    private fun checkBlackjack(players: Players) {
        if (hasBlackjack(players)) {
            end(players)
        }
    }

    private fun hasBlackjack(players: Players): Boolean {
        var result = false
        players.values.forEach {
            result = result or it.cards.isBlackjack()
        }
        return result
    }

    private fun play(players: Players, deck: Deck) {
        players.values.forEach { player ->
            doHitOrStay(player, deck)
        }
    }

    private fun doHitOrStay(player: Player, deck: Deck) {
        while (InputFilter.inputHitOrStay(PlayerDto(player).getName())) {
            player.draw(deck.getCard())
            ResultView.printPlayerCards(PlayerDto(player))
        }
        if (player.cards.size() == MINIMUM_NUMBER_OF_CARDS) {
            ResultView.printPlayerCards(PlayerDto(player))
        }
    }

    private fun end(players: Players) {
        ResultView.printLineFeed()
        players.values.forEach {
            ResultView.printResultWithScore(PlayerDto(it))
        }
    }
}
