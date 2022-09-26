
Généralités :
Cons:
- Gitflow : Un seul commit (hors initial commit) : pas facile de voir le processus de développement
Pros:
- README bien fourni, avec les commandes pour lancer et les URL à appeler pour jouer avec l'appli
- Dépendances :
JAVA 11 : pourrait utiliser plus récent mais c'est ok :)
SpringBoot : A jour! (Utilisation de SpringBoot Initializr)
- Utilisation de MongoDB
- Pas l'enonce centré sur le modèle et pourtant c'est bien fait

Tests:
Cons:
- Seulement 3 tests, uniquement les cas passants --> manque des tests de cas aux limites (retrait d'un montant négatif fait un ajout par exemple)
- Pas de TDD
Pros:
- 3 tests qui testent le domaine (cas passants)

Code:
Cons:
- Pas de Logs
- variables pas final
- Pas de notion d'immutabilité
- StringBuilder utilisé bizarrement : sb.append();sb.append(); au lieu de sb.append().append();
- Pas de lombok (getter et setters et equals et hashcode générés par l'IDE je pense)
Pros:
- JavaDoc OK (manque quelques return de temps en temps)
- Operation implémente Comparable pour ordonner les Opérations lors du print/display
- Utilisation des exceptions de JAVA (NoSuchElementException par exemple)
- Bon Naming des variables et des classes
- Pas de commentaire inutiles ni de TODO en suspens
- Pas d'Autowired, injection par constructeur

Hexa:
Cons: None
Pros:
- respect de l'archi hexa dans l'ensemble
- pas de dépendances du domaine vers l'extérieur