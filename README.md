# Calculatrice Client/Serveur en Java — Sockets TCP (TP1)

## Description

Ce projet implémente une **calculatrice distribuée** en Java utilisant des **sockets TCP en mode connecté**. Un programme **Client** envoie des requêtes à un programme **Serveur** à travers le réseau ; le serveur effectue le calcul demandé puis renvoie le résultat au client. Le projet a été développé progressivement en trois activités (1‑1, 1‑2, 1‑3), chacune ajoutant une nouvelle fonctionnalité.

## Structure du projet

```
src/
├── clientPackage/
│   ├── Client_1_2.java     → envoie un entier x
│   └── Client_1_3.java     → envoie un choix d'opération + deux opérandes
└── serverPackage/
    ├── Server_1_2.java     → calcule x * 5
    └── Server_1_3.java     → supporte +, -, *, /
```

## Activités

### Activité 1‑1 — Mise en place basique
Paire client/serveur minimale : le client ouvre une connexion TCP vers `localhost:1234`, le serveur l'accepte et répond. Introduction aux classes `ServerSocket`, `Socket` et au cycle *accept / connect*.

---

### Activité 1‑2 — Service de multiplication
Le client lit un entier `x` au clavier et l'envoie. Le serveur calcule `x * 5` et renvoie le résultat. Introduction de `DataInputStream` / `DataOutputStream` pour envoyer et recevoir des types primitifs (gestion correcte des entiers négatifs).

#### Côté Client (`Client_1_2.java`)
![Client 1_2](https://i.postimg.cc/3RjWTTRq/client-1-2.jpg)

#### Côté Serveur (`Server_1_2.java`)
![Serveur 1_2](https://i.postimg.cc/761bkk6W/server-1-2.jpg)

---

### Activité 1‑3 — Calculatrice complète sur deux machines
Deux améliorations :
1. **Communication entre deux machines distinctes** — le serveur s'attache à `0.0.0.0` (toutes les interfaces) via `InetSocketAddress`, et le client se connecte à l'adresse IP réelle du serveur au lieu de `localhost`.
2. **Quatre opérations** — le client affiche un menu (Addition, Soustraction, Multiplication, Division), envoie l'opération choisie et deux opérandes (`double`), et le serveur répond soit avec le résultat, soit avec un message d'erreur (division par zéro).

#### Côté Serveur (`Server_1_3.java`)
![Serveur 1_3](https://i.postimg.cc/3RjWTTRn/server-1-3.jpg)

#### Côté Client (`Client_1_3.java`)
![Client 1_3](https://i.postimg.cc/4dvnggdF/client-1-3.jpg)

---

## Protocole d'échange

| Étape | Sens | Type | Contenu |
|-------|------|------|---------|
| 1 | Client → Serveur | `int` | choix de l'opération (1–4) |
| 2 | Client → Serveur | `double` | premier opérande |
| 3 | Client → Serveur | `double` | deuxième opérande |
| 4 | Serveur → Client | `boolean` | succès ou échec |
| 5 | Serveur → Client | `double` | résultat (si succès) |

## Exécution

1. Sur la machine serveur, récupérer son adresse IP (`ipconfig` sous Windows, `ifconfig` / `ip a` sous Linux) et mettre à jour `ipServeur` dans le client.
2. Lancer le serveur :
   ```bash
   java serverPackage.Server_1_3
   ```
3. Lancer le client sur l'autre machine :
   ```bash
   java clientPackage.Client_1_3
   ```

## Exemple

```
1. Addition
2. Soustraction
3. Multiplication
4. Division
Votre choix : 3
Entrez a : 55
Entrez b : 12
Résultat = 660.0
```

```
Votre choix : 4
Entrez a : 7
Entrez b : 0
Erreur : division par zéro !
```

## Concepts abordés

- Programmation par sockets TCP (`ServerSocket`, `Socket`, `accept`)
- Liaison à une interface réseau (`InetAddress`, `InetSocketAddress`)
- Flux binaires (`DataInputStream`, `DataOutputStream`)
- Protocole requête/réponse client‑serveur
- Gestion des erreurs (division par zéro, choix invalide)
- Communication entre deux machines d'un même réseau local

## Environnement

- JDK ≥ 1.8
- Eclipse / IntelliJ IDEA / VS Code
- Git

## Livrables

- Lien du repository GitHub
- Ce fichier `README.md`