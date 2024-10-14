package com.bahraoui.first_code.TP3

//import java.util.Date

data class Etape(
    var nom: String,
    var dateDebut: String,
    var dateFin: String,
    var distanceParcourire: Double,
    var difficult: String,
)

sealed class Resultat{
    data class Termine(var tempsEffectue:Int, var classement: Byte):Resultat()
    data class Abandonne(var distanceParcouri:Int,var raison:String):Resultat()
}

class Cycliste(
    var nom: String,
    var prenom: String,
    var nationalite: String,
    var age: Int,
    var listEtape: HashMap<Etape, Resultat>,
) {
    fun nouvelleEtap(etape: Etape, resultat: Resultat) {
        listEtape.put(etape, resultat)
    }

    override fun toString(): String {
            val list= StringBuilder()
//            for ((k, v) in listEtape) {
//                list.append("Etape: ${k.nom}, dateDebut: ${k.dateDebut}, dateFin: ${k.dateFin}, distanceParcourire: ${k.distanceParcourire}, difficult: ${k.difficult}\n")
//                list.append("Result: ${v}\n")
//            }

        listEtape.forEach(){ e->
            list.append("Etape: ${e.key.nom}, dateDebut: ${e.key.dateDebut}, dateFin: ${e.key.dateFin}, distanceParcourire: ${e.key.distanceParcourire}, difficult: ${e.key.difficult}\n")
                list.append("Result: ${e.value}\n")
        }
        return "nom: $nom, prenom: $prenom, nationalite: $nationalite, age: $age, list des etapes: $list"
    }


}


fun main(){
    val c1=Cycliste("ahmed","bouzari","Marocain",25, hashMapOf())

    val e1=Etape("Lion","15-09-24","16-09-24",60.6,"facile")
    val e2=Etape("Paris","16-09-24","17-09-24",94.7,"medium")
    val e3=Etape("Toulouse","17-09-24","19-09-24",150.5,"difficile")

    val res1=Resultat.Termine(25,16)
    val res2=Resultat.Termine(50,50)


    c1.nouvelleEtap(e1,res1)
    c1.nouvelleEtap(e2,res2)

    println(c1.toString())
}