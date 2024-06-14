package com.app.strugglepalapp.data

object StarterBoxFactory {
    private val warbandname = "Starter Set"

    public fun kalani(): Unit {
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

    fun b1BAttleDroids(): Unit {
        val unit = Unit("B1 Battle Droids", "", UnitType.Support, UnitCardColor.Red, 3, 9, 2).apply {
            mainCardUrl = "https://shatterpointdb.com/media/arpd4hfq/star-wars-shatterpoint-b1-unit-card.png"
            abilityCardUrl = "https://shatterpointdb.com/media/xf5l5vmw/star-wars-shatterpoint-b1-abilities.png"
            stanceCardUrl1 = "https://shatterpointdb.com/media/bi4hxev0/b1-stance-card.png"
            keyWords = listOf(KeyWords.B1, KeyWords.BattleDroid, KeyWords.Droid, KeyWords.SeparatistAlliance, KeyWords.Trooper)
            warBandName = warbandname
        }

        unit.abilities = listOf(
            Ability().apply {
                weilder = unit
                name = "Combat A.I. Protocols"
                type = AbilityType.Inate
                cost = 0
                text = "After an allied Battle Droid Unit makes a combat action, choose one of the targeted characters that is within *range*4 of all character in this Unit if able. the chosen character gains *strained* or *exposed*."
                synergies = listOf(
                    Synergy().apply {
                        name = null
                        type = null
                        keyWords = listOf(KeyWords.BattleDroid)
                    }
                )
                timing = listOf(Timing.Active, Timing.AnotherActive)
            },
            Ability().apply {
                weilder = unit
                name = "Well, I Guess I'm in Charge Now"
                type = AbilityType.Inate
                cost = 0
                text = "When this Unit's Order Card would be placed in reserve, it's controlling player may place it on the bottom of their Order Deck instead"
                synergies = null
                timing = listOf(Timing.Start)
            },
            Ability().apply {
                weilder = unit
                name = "I Hate This Job"
                type = AbilityType.Inate
                cost = 0
                text = "While a character in this Unit is contesting one or more Active objectives, it has Protection"
                synergies = null
                timing = listOf(Timing.Targeted)
            }
        )

        return unit
    }

    fun asajjVentress(): Unit {
        val unit = Unit("Asajj Ventress, Sith Assassin", "Asaji Ventress", UnitType.Primary, UnitCardColor.Red, 8, 9, 3, 3).apply {
            mainCardUrl = "https://shatterpointdb.com/media/vcsl0v33/star-wars-shatterpoint-asajj-ventress.png"
            abilityCardUrl = "https://shatterpointdb.com/media/gtbhclqv/star-wars-shatterpoint-asajj-ventress-abilities.png"
            stanceCardUrl1 = "https://shatterpointdb.com/media/4f3chjdq/star-wars-shatterpoint-asajj-ventress-stance-one.png"
            stanceCardUrl2 = "https://shatterpointdb.com/media/unhltw4d/star-wars-shatterpoint-asajj-ventress-stance-two.png"
            keyWords = listOf(KeyWords.Dathomirian, KeyWords.ForceUser, KeyWords.NightSister, KeyWords.SeparatistAlliance)
            warBandName = warbandname
        }

        unit.abilities = listOf(
            Ability().apply {
                weilder = unit
                name = "Dathomirian Dexterity"
                type = AbilityType.Active
                cost = 1
                text = "Each character in this Unit may *jump*. This Unit may use this ability two times during its activation"
                synergies = null
                timing = listOf(Timing.Active)
            },
            Ability().apply {
                weilder = unit
                name = "Force Push"
                type = AbilityType.Active
                cost = 2
                text = "Choose a character in this Unit and an enemy character within *range*3 of that character. Push the choosen enemy character *range*3 away from the choosen allied character"
                synergies = null
                timing = listOf(Timing.Active)
            },
            Ability().apply {
                weilder = unit
                name = "Riposte"
                type = AbilityType.Reactive
                cost = 0
                text = "After a *melee* attack targetting a character in this Unit is resolved, this Unit may use this ability. If the attack roll contained one or more *failure* results, the attacking Unit suffers *damage**damage*"
                synergies = null
                timing = listOf(Timing.Targeted)
            },
            Ability().apply {
                weilder = unit
                name = "Slip Away"
                type = AbilityType.Reactive
                cost = 0
                text = "When another Dathomirian or Separatist Alliance character targets an enemy character that is Engaged with one of more characters in this Unit with an attack, this Unit may use this ability. One character in this Unit that is Engaged with the target character may immediately repos. If it does, this unit gains *hunker*"
                synergies = listOf(
                    Synergy().apply {
                        name = null
                        type = null
                        keyWords = listOf(KeyWords.SeparatistAlliance, KeyWords.Dathomirian)
                    }
                )
                timing = listOf(Timing.AnotherActive)
            },
            Ability().apply {
                weilder = unit
                name = "Sith Assassin"
                type = AbilityType.Identity
                cost = 0
                text = "When a character in this Unit Wounds an enemy Unit, after the effect is resolved, that carachter may *heal**heal**heal*. If it Wounded a Primary Unit or Secondary Unit, it may also *advance* or *jump*. If it Wounder a primary Unit, refresh *forceicon**forceicon*."
                synergies = null
                timing = listOf(Timing.Active)
            }
        )

        return unit
    }

    fun lordMaul(): Unit {
        val unit = Unit("Lord Maul", "Maul", UnitType.Primary, UnitCardColor.Red, 8, 11, 2, 3).apply {
            mainCardUrl = "https://shatterpointdb.com/media/klehavye/swp01_maul_unit_article-1.png?height=600&v=1d978862f118b50"
            abilityCardUrl = "https://shatterpointdb.com/media/i3vdw20w/maulabilities.png"
            stanceCardUrl1 = "https://shatterpointdb.com/media/3jxhjwvb/maulstance2.png"
            stanceCardUrl2 = "https://shatterpointdb.com/media/kkgn3wv2/maulstance1.png"
            keyWords = listOf(KeyWords.Dathomirian, KeyWords.ForceUser, KeyWords.Scoundrel, KeyWords.ShadowCollective)
            warBandName = warbandname
        }

        unit.abilities = listOf(
            Ability().apply {
                weilder = unit
                name = "Force Speed"
                type = AbilityType.Active
                cost = 1
                text = "Each character in this Unit may *advance*."
                synergies = null
                timing = listOf(Timing.Active)
            },
            Ability().apply {
                weilder = unit
                name = "There is No Place to Run"
                type = AbilityType.Active
                cost = 2
                text = "Choose a character in this Unit and an enemy character within *range*3 of that character. Pull the chosen enemy character *range*2 Toward the chosen allied character. Then the chosen enemy character gains Exposed"
                synergies = null
                timing = listOf(Timing.Active)
            },
            Ability().apply {
                weilder = unit
                name = "Revenge, I Must Have Revenge"
                type = AbilityType.Inate
                cost = 0
                text = "When this Unit is Wounded by a *melee* attack, after the attack is resolved, one character in this Unit may immediately *dash* and make a 5 dive *melee* attack targeting the character that Wounded it."
                synergies = null
                timing = listOf(Timing.Targeted)
            },
            Ability().apply {
                weilder = unit
                name = "Sustained By Rage"
                type = AbilityType.Identity
                cost = 0
                text = "While this Unit is not Wounded, when it would spend F to use an ability, it may suffer *damage* equal to the cost of the ability instead.<br/><br/>For every 3 *damage* this Unit has, characters in this Unit add 1 die to their *melee* Attack rolls. <br/>For each injured token this Unit has, characters in this Unit add 3 dice to their *melee* attack rolls."
                synergies = null
                timing = listOf(Timing.Active)
            }
        )

        return unit
    }

    fun garSaxon(): Unit {
        val unit = Unit("Gar Saxon, Merciless Commander", "Gar Saxon", UnitType.Secondary, UnitCardColor.Red, 4, 9, 2).apply {
            mainCardUrl = "https://shatterpointdb.com/media/sp4njwnf/star-wars-shatterpoint-gar-saxon-character-card.png"
            abilityCardUrl = "https://shatterpointdb.com/media/ffmjwwbz/star-wars-shatterpoint-gar-saxon-abilities.png"
            stanceCardUrl1 = "https://shatterpointdb.com/media/xu1pp1jl/star-wars-shatterpoint-gar-saxon-stance.png"
            keyWords = listOf(KeyWords.Mandalorian, KeyWords.ShadowCollective, KeyWords.SuperCommando)
            warBandName = warbandname
        }

        unit.abilities = listOf(
            Ability().apply {
                weilder = unit
                name = "Pride of the Mandalor"
                type = AbilityType.Tactic
                cost = 0
                text = "At the start of this Unit's activation, choose another allied Mandalorian character. The chosen character may *jump*."
                synergies = listOf(
                    Synergy().apply {
                        keyWords = listOf(KeyWords.Mandalorian)
                    }
                )
                timing = listOf(Timing.Start)
            },
            Ability().apply {
                weilder = unit
                name = "Jet Pack"
                type = AbilityType.Active
                cost = 1
                text = "Each character in this Unit may *jump*."
                synergies = null
                timing = listOf(Timing.Active)
            },
            Ability().apply {
                weilder = unit
                name = "Mandalorians are Stronger Together"
                type = AbilityType.Reactive
                cost = 0
                text = "After this Unit makes a move action, it may use this ability. If a character in this Unit is within *range*2 of another allied Mandalorian character, this Unit immediately makes a focus action"
                synergies = listOf(
                    Synergy().apply {
                        keyWords = listOf(KeyWords.Mandalorian)
                    }
                )
                timing = listOf(Timing.Active)
            },
            Ability().apply {
                weilder = unit
                name = "I've Got You In My Sights"
                type = AbilityType.Inate
                cost = 0
                text = "Characters in this Unit have Sharpshooter(2). When a character in this Unit makes a *ranged* attack, the target does not benefit from Cover. After this Unit Makes a focus action, it gains *hunker*"
                synergies = null
                timing = listOf(Timing.Active)
            },
            Ability().apply {
                weilder = unit
                name = "Pack Hunter"
                type = AbilityType.Inate
                cost = 0
                text = "When a character in this Unit makes a *melee* attack targeting an enemy character that is Engaged with another allied Mandalorian character, it adds 2 dice to the attack roll"
                synergies = listOf(
                    Synergy().apply {
                        keyWords = listOf(KeyWords.Mandalorian)
                    }
                )
                timing = listOf(Timing.Active)
            }
        )

        return unit
    }

    fun mandalorianSuperCommandos(): Unit {
        val unit = Unit("Mandalorian Super Commandos", "", UnitType.Support, UnitCardColor.Red, 4, 8, 2).apply {
            mainCardUrl = "https://shatterpointdb.com/media/hdxbgbol/star-wars-shatterpoint-mandalorian-super-commando-unit-card.png"
            abilityCardUrl = "https://shatterpointdb.com/media/fzcj52gl/star-wars-shatterpoint-mandalorian-super-commandos-abilities.png"
            stanceCardUrl1 = "https://shatterpointdb.com/media/umplqvvr/star-wars-mandalorian-super-commandos-stance.png"
            keyWords = listOf(KeyWords.Mandalorian, KeyWords.ShadowCollective, KeyWords.SuperCommando, KeyWords.Trooper)
            warBandName = warbandname
        }

        unit.abilities = listOf(
            Ability().apply {
                weilder = unit
                name = "Jet Pack"
                type = AbilityType.Active
                cost = 1
                text = "Each character in this Unit may *jump*."
                synergies = null
                timing = listOf(Timing.Active)
            },
            Ability().apply {
                weilder = unit
                name = "Mandalorians are Stronger Together"
                type = AbilityType.Reactive
                cost = 0
                text = "After this Unit makes a move action, it may use this ability. If a character in this Unit is within *range*2 of another allied Mandalorian character, this unit immediately makes a focus action"
                synergies = listOf(
                    Synergy().apply {
                        keyWords = listOf(KeyWords.Mandalorian)
                    }
                )
                timing = listOf(Timing.Active)
            },
            Ability().apply {
                weilder = unit
                name = "No Mercy"
                type = AbilityType.Inate
                cost = 0
                text = "When an enemy character that is Engaged with one or more characters in this Unit *advance* or *dash*, after the move is resolved, the moving character's unit suffers *damage**damage* if the moving character is no longer engaged with one or more characters in this Unit."
                synergies = null
                timing = listOf(Timing.Opponent)
            },
            Ability().apply {
                weilder = unit
                name = "Victory or Death!"
                type = AbilityType.Inate
                cost = 0
                text = "Characters in this Unit have Impact(1)"
                synergies = null
                timing = listOf(Timing.Active)
            }
        )

        return unit
    }

}
