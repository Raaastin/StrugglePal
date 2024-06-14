package com.app.strugglepalapp.data

class Unit(
    val name: String,
    val uniqueName: String,
    val type: UnitType,
    val cardColor: UnitCardColor,
    val point: Int,
    val wound: Int,
    val injure: Int,
    force: Int = 0
) {
    var warBandName: String? = null
    var era: List<String>? = null
    var injurePool = injure
    var woundPool = wound
    var force = force
    var sp = if (type == UnitType.Primary) point else -1
    var pc = if (type == UnitType.Primary) -1 else point
    var mainCardUrl: String? = null
    var abilityCardUrl: String? = null
    var stanceCardUrl1: String? = null
    var stanceCardUrl2: String? = null
    var top = -7.1
    var left = 11.5
    var keyWords: List<String> = mutableListOf()
    var abilities: List<Ability> = mutableListOf()
}

class Synergy(
    var name: String? = null,
    var type: UnitType? = null,
    var keyWords: List<String> = mutableListOf(),
    var noCardRelated: Boolean = false
)


class Ability(
    var weilder: Unit? = null,
    var name: String? = null,
    var type: AbilityType? = null,
    var cost: Int = 0,
    var text: String? = null,
    var synergies: List<Synergy>? = null,
    var timing: List<Timing> = mutableListOf()
)

enum class AbilityType {
    Tactic,
    Active,
    Reactive,
    Inate,
    Identity
}

enum class Timing {
    /// <summary>
    ///  When the activation starts
    /// </summary>
    Start,

    /// <summary>
    /// During the turn this unit is activated
    /// </summary>
    Active,

    /// <summary>
    /// During the turn an ally is activated
    /// </summary>
    AnotherActive,

    /// <summary>
    /// When the unit is targeted
    /// </summary>
    Targeted,

    /// <summary>
    /// When an allied Unit is targeted
    /// </summary>
    AlliedTargeted,

    /// <summary>
    /// At any time during the opponent's turn
    /// </summary>
    Opponent,

    /// <summary>
    /// At the end of activation
    /// </summary>
    End
}

enum class UnitType {
    Primary,
    Secondary,
    Support
}
enum class UnitCardColor
{
    Red,
    Blue,
    Grey,
    Dark
}