# 🎮 Tris (Tic-Tac-Toe) in Java

Un'implementazione del classico gioco del Tris con interfaccia grafica realizzata in Java Swing.

---

## 📸 Funzionalità

- Inserimento dei nickname dei due giocatori prima di iniziare
- Interfaccia grafica con griglia 3×3 cliccabile
- Indicatore del turno corrente aggiornato in tempo reale
- Rilevamento automatico di vittoria e pareggio
- **Evidenziazione in verde** delle celle della combinazione vincente
- Bottone **"Nuova Partita"** per rigiocare con gli stessi giocatori senza riaprire l'app
- Chiudendo la finestra di gioco si torna alla schermata di inserimento nomi

---

## 🗂️ Struttura del progetto

```
TrisSwingJava/
├── src/
│   └── main/
│       └── java/
│           ├── Main.java               # Entry point
│           ├── FinestraIniziale.java   # Schermata inserimento nickname
│           ├── FinestraGioco.java      # Finestra di gioco con la griglia
│           ├── Partita.java            # Logica della partita (turni, stato, reset)
│           ├── Griglia.java            # Logica della griglia (mosse, vittoria, pareggio)
│           ├── Player.java             # Modello del giocatore
│           └── StatoPartita.java       # Enum: IN_CORSO, VITTORIA, PAREGGIO
├── build.gradle.kts
└── settings.gradle.kts
```

---

## 🚀 Come eseguire

**Con il Gradle Wrapper (consigliato, non serve Gradle installato):**
```bash
git clone https://github.com/KevinFerrari0505/TrisSwingJava.git
cd TrisSwingJava
.\gradlew build      # Windows
./gradlew build      # Linux/macOS
.\gradlew run        # Windows
./gradlew run         # Linux/macOS
```

**Con IntelliJ IDEA:**
1. Apri la cartella `TrisSwingJava` come progetto
2. Tasto destro su `Main.java` → **Run 'Main'**

### Prerequisiti
- JDK compatibile con la versione dichiarata in `build.gradle.kts`
- Verifica con: `java -version`

---

## 🕹️ Come si gioca

1. All'avvio viene mostrata una schermata dove inserire i nomi dei due giocatori (minimo 2 caratteri ciascuno)
2. Si apre la griglia di gioco: il **Giocatore 1** usa la `X`, il **Giocatore 2** usa la `O`
3. I giocatori si alternano cliccando sulle celle libere
4. Vince chi completa per primo una riga, colonna o diagonale
5. A fine partita le celle vincenti vengono evidenziate in verde
6. Premi **"Nuova Partita"** per rigiocare con gli stessi nomi, oppure chiudi la finestra per inserire nomi diversi

---

## 🏗️ Design delle classi

```
Player
  └── username, simbolo (X o O)

Griglia
  └── matrice char[3][3]
  └── inserisciSimbolo(), controllaVittoria(), controllaPareggio(), getCelleVincenti()

Partita
  └── player1, player2, turnoCorrente, griglia, stato
  └── gioca(), reset(), getVincitore()

StatoPartita (enum)
  └── IN_CORSO | VITTORIA | PAREGGIO

FinestraIniziale  →  crea i Player  →  apre FinestraGioco
FinestraGioco     →  usa Partita    →  gestisce click e UI
```

---

## 🛠️ Tecnologie utilizzate

- **Java** — logica di gioco
- **Java Swing** — interfaccia grafica (`JFrame`, `JPanel`, `JButton`, `JOptionPane`)
- **Gradle** (Kotlin DSL) — build tool

---

## 🤖 AI Assistance
 
Questo progetto è stato sviluppato con il supporto di [Claude](https://claude.ai) (Anthropic).
 
In particolare, Claude ha aiutato ad estendere il gioco con la possibilità di disputare più partite
consecutive senza chiudere l'applicazione: è stato aggiunto un bottone "Nuova Partita" che si attiva
a fine partita, resettando la griglia e mantenendo gli stessi giocatori. È stata inoltre implementata
l'evidenziazione in verde delle celle della combinazione vincente e un'etichetta che mostra il turno
corrente aggiornata ad ogni mossa.
 
Per supportare queste funzionalità, Claude ha guidato il refactoring delle classi esistenti:
in `Partita` sono stati introdotti il campo `vincitore`, il metodo `getVincitore()` per recuperarlo
in modo esplicito e il metodo `reset()` per reinizializzare lo stato della partita; in `Griglia`
è stato aggiunto il metodo `getCelleVincenti()` che restituisce le coordinate delle tre celle
della combinazione vincente.

---

## 👤 Autore

Fatto da **KevinFerrari0505**
