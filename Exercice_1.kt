package com.bahraoui.first_code.TP3

data class Joueur(
    var nom: String,
    var numero: Int,
    var equipe: Equipe,
    var pointGagne: Int,
    var totalPoint: Int
)


enum class Equipe {
    OCS, OCK, RCA, WAC
}

enum class Pays {
    Maroc, Palestine, Tunisie, Mouritanie
}

class EquipeFinal(var sigle: Equipe, var pays: Pays, var listJoueurs: MutableList<Joueur>) {

    fun ajout(j: Joueur): Boolean {
        if (listJoueurs.contains(j)) {
            return false
        }
        listJoueurs.add(j)
        return true
    }

    fun recherche(j: Joueur): Int {
        for (v in listJoueurs) {
            if (v.nom == j.nom) {
                return listJoueurs.indexOf(v)
            }
        }
        return -1
    }

    fun suppression(j: Joueur): Boolean {
//        if(Team.contains(j)){
//            Team.remove(j)
//            return true
//        }
//        return false
        return listJoueurs.remove(j)
    }

    fun setPoints(j: Joueur, points: Int) {
        if (recherche(j) != -1) {
            j.totalPoint = points
        } else {
            println("ce joueur n'existe pas!")
        }
    }

    fun afficherInfos() {
        print("equipe: $sigle, de $pays, avec les joueur:  ")
        for (v in listJoueurs) {
            if (v == listJoueurs.last()) {
                print("${v.nom}.")
            } else {
                print("${v.nom},")
            }
        }
        println()

    }
}
fun main() {
    var J1 = Joueur("amine", 5, Equipe.OCS, 54, 156)
    var J2 = Joueur("Ayman", 1, Equipe.OCK, 35, 95)
    var J3 = Joueur("Med", 8, Equipe.OCS, 68, 189)
    var J4 = Joueur("said", 7, Equipe.OCK, 16, 250)

//    var listJoueur= mutableListOf(J1,J2,J3)
//    listJoueur.add(J4)
//    for(v in listJoueur){
//        println(v)
//    }

    val equipe1 = EquipeFinal(Equipe.OCS, Pays.Maroc, mutableListOf())
    val equipe2 = EquipeFinal(Equipe.OCK, Pays.Tunisie, mutableListOf())
    val equipe3 = EquipeFinal(Equipe.RCA, Pays.Palestine, mutableListOf())
    val equipe4 = EquipeFinal(Equipe.WAC, Pays.Mouritanie, mutableListOf())

    println(equipe1.ajout(J1))
    equipe1.ajout(J4)
    equipe2.ajout(J2)
    equipe3.ajout(J3)
    equipe4.ajout(J4)


    val listEquipe = mutableListOf(equipe1, equipe2, equipe3, equipe4)
    for (v in listEquipe) {
        v.afficherInfos()
    }

    equipe1.suppression(J4)
    println("\n")
    equipe1.afficherInfos()

}