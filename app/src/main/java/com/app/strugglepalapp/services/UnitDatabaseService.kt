package com.app.strugglepalapp

import com.app.strugglepalapp.data.StarterBoxFactory
import com.app.strugglepalapp.data.Unit

class UnitDatabaseService() {

    var kalani: Unit = StarterBoxFactory.kalani()
    var b1BattleDroids: Unit = StarterBoxFactory.b1BAttleDroids()
    var asajVentress: Unit = StarterBoxFactory.asajjVentress()
    var lordMaul: Unit = StarterBoxFactory.lordMaul()
    var garSaxxon: Unit = StarterBoxFactory.garSaxon()
    var superCommandos: Unit = StarterBoxFactory.mandalorianSuperCommandos()

    var unitList: List<Unit> = listOf<Unit>(
        kalani,
        b1BattleDroids,
        asajVentress,
        lordMaul,
        garSaxxon,
        superCommandos
    )

}