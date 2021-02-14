# CodeployAcademyWso2CustomMediator

Progetto esempio relativo allo sviluppo di un custom mediator java per wso2esb

- Creare il progeto Mediator Project
- Convertire il progetto in maven project per comodità 
- Il tag <build> di questo progetto è diverso da quello creato di default. Usato per semplificare la build (clean package)
  
Il presente mediator ha, al suo interno, più metodi invocati definendo su esb una property custom_method.
Non è tuttavia una soluzione ottimale.
Un custom mediator deve gestire concettualmente un'unica tipologia di mediation.
  
## how deploy

Per effettuare il deploy del custom mediator:

- clean package per ottenere progetto .jar
- copiare il progetto jar sotto il path (repository/components/lib
- riavviare nodo esb

N.B. In eventuali configurazioni di produzione, con più istanze esb, è ovviamente necessario rilasciare il jar su tutti i nodi.
