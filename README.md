Kotlin-perusteet

Sovellus käynnistyy ja esille pitäisi tulla lista tehtävistä joita voi itsekin lisäillä addTask-funktion avulla:

fun addTask(list: List<Task>, task: Task): List<Task> {
    return list + task
}

Tehtäviä pitäisi pystyä myös muokkaamaan tehdyksi toggleDone-funktiolla:

fun toggleDone(list: List<Task>, id: Int): List<Task> {
    return list.map {
        if (it.id == id) it.copy(done = !it.done)
        else it
    }
}

Tehtäville tuli myös valmiiksi tehtyä filterByDone-funktio sekä sortByDueDate-funktio, mutta aikarajoitusten ja hitaan koneen takia en kerennyt viimeistellä projektia ja kuvata lopullista demovideota joka näyttäisi viimeisimmän version. Demovideossa kuitenkin näkyy myös nämä funktiot valmiina ilman nappeja yms.
