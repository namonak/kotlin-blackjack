package blackjack.dto

import blackjack.domain.player.Participants

@JvmInline
value class ParticipantsDto(val players: List<ParticipantDto>) {
    fun getNames(): List<String> {
        return players.map { it.name }
    }

    companion object {
        fun from(participants: Participants): ParticipantsDto {
            return ParticipantsDto(participants.values.map { ParticipantDto.from(it) })
        }
    }
}
