object StarterBoxFactory {
    private const val warbandname = "Starter Set"

    fun kalani(): Unit {
        val unit = Unit(
            "Kalani, Super Tactical Robot",
            "Kalani",
            UnitType.Secondary,
            UnitCardColor.Red,
            5,
            10,
            2
        ).apply {
            mainCardUrl = "https://shatterpointdb.com/media/gtbfzv2n/star-wars-shatterpoint-kalani-unit-card.png"
            abilityCardUrl = "https://shatterpointdb.com/media/2mykdrxq/star-wars-shatterpoint-kalani-abilities.png"
            stanceCardUrl1 = "https://shatterpointdb.com/media/rsnodu4s/kalani-stance-card.png"
            keyWords = listOf(KeyWords.BattleDroid, KeyWords.Droid, KeyWords.SeparatistAlliance)
            warBandName = warbandname
        }

        unit.abilities = listOf(
            Ability(
                unit,
                "Roger, Roger",
                AbilityType.Tactic,
                0,
                "At the start of this Unit's activation, each allied Battle Droid Supporting character within range 4 of a character in this Unit may dash",
                synergies = listOf(
                    Synergy(null, UnitType.Support, listOf(KeyWords.BattleDroid))
                ),
                timing = listOf(Timing.Start)
            ),
            Ability(
                unit,
                "Tactical Network",
                AbilityType.Active,
                1,
                "Choose another allied Battle Droid character within range 4. The chosen Character may dash, then may gain hunker, remove one condition from itself, or make a 5 dice attack",
                synergies = listOf(
                    Synergy(null, null, listOf(KeyWords.BattleDroid))
                ),
                timing = listOf(Timing.Active)
            ),
            Ability(
                unit,
                "Target, Concentrate All Firepower",
                AbilityType.Inate,
                0,
                "When an allied Battle Droid character makes an attack, if the targeted character is within range 4 of one or more other allied Battle Droid characters, the attacking character adds 1 die to its attack roll.",
                synergies = listOf(
                    Synergy(null, null, listOf(KeyWords.BattleDroid))
                ),
                timing = listOf(Timing.Active, Timing.AnotherActive)
            ),
            Ability(
                unit,
                "Complete Analysis",
                AbilityType.Inate,
                0,
                "When you spend *forceicon* to place this Unit's Order Card in reserve, spend 1 less *forceicon*"
            )
        )

        return unit
    }


}
