package listaencadeadadinamicaavancada;

public class fila{
	
    public tipoNo cabeca;
    public tipoNo fim;

    public tipoNo getCabeca() {
        return cabeca;
    }

    public void setCabeca(tipoNo cabeca) {
        this.cabeca = cabeca;
    }

    public tipoNo getFim() {
        return fim;
    }

    public void setFim(tipoNo fim) {
        this.fim = fim;
    }
    
    
    
    fila(){
        System.out.println("Criando fila...(construtor fila)");
    }

    public void insereInicio(String info, int num){
       if(cabeca == null){ //nao tem ninguem na fila  
            cabeca = new tipoNo();
            cabeca.setInfo(info);
            cabeca.setNum(num);
            cabeca.setProx(null);
       }else{
            tipoNo novo;
            novo = new tipoNo();
            novo.setInfo(info);
            novo.setNum(num);
            novo.setProx(cabeca);
            cabeca = novo;
       }
    }	
    
    public void insereFinal(String info, int num){
        if(cabeca == null){
            cabeca = new tipoNo();
            cabeca.setInfo(info);
            cabeca.setNum(num);
            cabeca.setProx(null);
        }else{
            tipoNo aux,novo;
			
            novo = new tipoNo();
            novo.setInfo(info);
            novo.setNum(num);
            novo.setProx(null);

            aux = cabeca;
            while (aux.getProx() != null) {
                aux = aux.getProx();
            }

            aux.setProx(novo);
	}
		
		System.out.println("Elemento "+info+" inserido com sucesso! ");
    }
	
    public void inserePosicaoEspecifica(String valor,int num, int pos){
       if(pos == 1){ //insereInicio
          insereInicio(valor, num);
       }else{
          int cont=1;
          tipoNo aux=cabeca;
          while( cont != (pos-1) ){
             aux = aux.getProx();
             cont++;
          }
          tipoNo novo = new tipoNo();
          novo.setInfo(valor);
          novo.setNum(num);
          
          novo.setProx(aux.getProx());
          aux.setProx(novo);
       }
    }
	
    public void removeInicio(){
        if(cabeca!=null){
            String valor = cabeca.getInfo();
            System.out.println("Elemento "+valor+" removido com sucesso! ");
            cabeca=cabeca.getProx();
	}
    }
	
     public void removeFinal(){
        if(cabeca==null){ //nao tem ninguem na lista
            System.out.println("Lista vazia!");
	}else if(cabeca.getProx() == null){ //tem apenas um elemento na lista
            String valor=cabeca.getInfo();
            System.out.println("Elemento "+valor+" removido com sucesso! ");
            cabeca=null; //cabeca=cabeca.getProx();    
        }else{ //mais de um elemento na lista
            tipoNo aux;
            aux = cabeca;
            while(aux.getProx().getProx() != null){
               aux = aux.getProx();
            }
            //tenho certeza que estou no penultimo
            aux.setProx(null);


        }
    }
	
    public void imprime(){
        tipoNo aux = cabeca;
        System.out.println("Impressao: ");
        while (aux != null) {
            System.out.print(aux.getInfo() + " - ");
            System.out.print(aux.getNum() + " ");
            aux = aux.getProx();
        }
        System.out.println("");
    }

    public void busca(String valor){
        tipoNo aux = cabeca;        
        while (aux != null && !aux.getInfo().equals(valor)) {
            aux = aux.getProx();         
        } 
        if(aux == null)
           System.out.println("Elemento "+valor+" não encontrado!");
        else
           System.out.println("Elemento "+valor+" encontrado!");
    }
	
  
     public void removeNesimo(int pos){
         
        if(pos == 1){ //insereInicio
           String valor = cabeca.getInfo();
           System.out.println("Elemento "+valor+" removido com sucesso! ");
           cabeca=cabeca.getProx();
       }
        else{
          int cont=1;
          tipoNo aux=cabeca;
          while( cont != (pos-1) ){
             aux = aux.getProx();
             cont++;
          }
        //   System.out.println(aux.getInfo()); // penultimo
          
           if(aux.getProx().getProx() != null){
           aux.setProx(aux.getProx().getProx()); //seta prox do penultimo o prox do prox 
            System.out.println("Removido: " + aux.getProx().getInfo());
           }
           else{
               System.out.println("Removido: " + aux.getProx().getInfo());
               aux.setProx(null);
           }
          
       }
    }
     
   public void divideApartir(fila f2,int pos){
    
          int cont=1;
          tipoNo aux=cabeca;

        //  fila f2 = new fila();         
        
       if(pos == 1){
           System.out.println("Erro");
       } 
       else{
           
          while( cont != (pos-1) ){
             aux = aux.getProx();
             cont++;
          }
          f2.cabeca = aux.getProx();
          aux.setProx(null);

          System.out.println(" ---- ");
       System.out.println("Impressao fila1");
         this.imprime();
       System.out.println("Impressao fila2 \n");
         f2.imprime();
        }
 }
   
     public void insercaoBfila(String valor, int num){

         if(cabeca == null){
             cabeca = new tipoNo();
             cabeca.setInfo(valor);
             cabeca.setNum(num);
             cabeca.setProx(null);
             cabeca.setAnterior(null);
         }
         else{
             tipoNo novoEl, aux;
             
             novoEl = new tipoNo();
              aux = cabeca;
             
             novoEl.setInfo(valor);
             novoEl.setNum(num);          
             novoEl.setProx(null);
             
            
             while(aux.getProx() != null){
                 aux = aux.getProx();
             }
         
             aux.setProx(novoEl);
             novoEl.setAnterior(aux);
             
             System.out.println("Anterior");
             System.out.println(novoEl.getAnterior().getInfo());
             System.out.println("Prox do anterior");
             System.out.println(aux.getProx().getInfo());            
         }
     }
     
    public void remocaoBfila(){
           
        if(cabeca!=null){
            String valor = cabeca.getInfo();
        
            
        System.out.println("Elemento "+valor+" removido com sucesso! ");
                    
         // System.out.println(cabeca.getProx().getAnterior().getInfo());
           
//           if(cabeca.getProx().getAnterior().getInfo() != null){
//               cabeca.getProx().setAnterior(null);
//            }          
           cabeca = cabeca.getProx();          
	}
        else{
            System.out.println("Lista vazia");
        }
        
    }
//    
//    public void obtemOrdemInversaEncad(){
//        
//        tipoNo aux = cabeca;
//        
//        while(aux.getProx() != null){
//            aux = aux.getProx();
//        }
//        //ultima posicao
//      // System.out.println(aux.getInfo());
//       
//        while(aux.getAnterior() != null){
//            System.out.print(aux.getInfo() + " ");
//            aux = aux.getAnterior();
//        } 
//        System.out.println(aux.getInfo()); //ultima posicao queGetAnterior é null
//    }
    
    public void obtemOrdemInversaSimples(){
        
       fila fila2 = new fila();
       tipoNo aux = cabeca;
       
       while(aux != null){ //tira do inicio
        fila2.insereInicio(aux.getInfo(), aux.getNum());
        aux = aux.getProx();
        } 
     fila2.imprime();
    }
     
public void concatenaListas(fila f2){
  tipoNo aux = cabeca;
    while(aux.getProx() != null){
    aux= aux.getProx();    
    }
    //System.out.println(aux.getInfo()); ultima pos

    aux.setProx(f2.getCabeca()); 
    System.out.println("Concatenado!");
    this.imprime();
}

public void criaListaApartirde2(fila f2, fila f3){
    
    
    tipoNo aux = cabeca;
    f3.setCabeca(null);

    while(aux.getProx() != null){
    f3.insereFinal(aux.getInfo(), aux.getNum());
    aux = aux.getProx();
    } 
   f3.insereFinal(aux.getInfo(), aux.getNum());

   tipoNo aux2 = f2.cabeca;

   while(aux2.getProx() != null){
    f3.insereFinal(aux2.getInfo(), aux2.getNum());
    aux2 = aux2.getProx();
    }
   f3.insereFinal(aux2.getInfo(), aux2.getNum());

   f3.imprime();
   
}

public void imprimeTodas(fila f2,fila f3){
    
    System.out.println("\n -- Imprimindo todas listas -- ");
    this.imprime();
    f2.imprime();
    f3.imprime();
    System.out.println("---- \n");
}

    public void ordenarInserindo(String valor, int Num){
         
     tipoNo aux = cabeca;
     
    if(Num < aux.getNum()){
      insereInicio(valor, Num);
    }
    else{
        tipoNo novo = new tipoNo();
        novo.setInfo(valor);
        novo.setNum(Num);
    boolean inseriu=false;
    while(aux.getProx() != null && !inseriu){ 
          if( Num < aux.getProx().getNum()){
           
            novo.setProx(aux.getProx());
            aux.setProx(novo);
            inseriu = true; 
           } 
           aux = aux.getProx();
         }
    }
   this.imprime();
   }
    
   public void listasParEimpar(fila f2){

    tipoNo aux = cabeca;

    while(cabeca.getNum() % 2 != 0 && cabeca != null){ //impar
            cabeca = cabeca.getProx();
        }       
    while(aux.getProx() != null){
          if(aux.getProx().getNum() % 2 != 0){
              if(aux.getProx().getProx() != null){
                aux.setProx(aux.getProx().getProx());
              }
              else{
                  aux.setProx(null);
              }
            }   
          else{
            aux = aux.getProx();  
          }
    }
    
     tipoNo aux2 = f2.cabeca;

    while(f2.cabeca.getNum() % 2 == 0 && f2.cabeca != null){ //par
            f2.cabeca = f2.cabeca.getProx();
        }       
    while(aux2.getProx() != null){
          if(aux2.getProx().getNum() % 2 == 0){ // par
              if(aux2.getProx().getProx() != null){
                aux2.setProx(aux2.getProx().getProx());
              }
              else{
                  aux2.setProx(null);
              }
            }   
          else{
            aux2 = aux2.getProx();  
          }
    }
    
    
  
    System.out.println("Lista1: ");
    this.imprime();
    System.out.println("Lista2: ");
    f2.imprime();
} 
    
    public void menu(){
        String valor;
        int opcao=0,pos;

        fila fila2 = new fila();
        
        fila fila3 = new fila();

	System.out.print("\n------------ Menu ------------\n");
	while(opcao!=-1){
            opcao = Input.readInt(
                    "\nDigite a opcao: "
                    + "\n(1) Insere no Inicio - l1"
                    + "\n(2) Insere no Fim - l1"
                    + "\n(3) Remove do Inicio - l1"
                    + "\n(4) Remove do Fim - l1"
                    + "\n(5) Imprime - l1"
                    + "\n(6) Busca - l1"
                    + "\n(7) Insere Posicao na Especifica -> l1"
                    + "\n(8) Remove N-esimo termo -> l1"
                    + "\n(9) Divide lista a partir do termo -> l1 e l2"
                    + "\n(10) Concatena 2 listas -> l1 e l2"
                    + "\n(11) Cria nova lista a partir de 2 existentes -> l3"
                    + "\n(12) Ordena Inserindo 1 de cada vez - l1"
                    + "\n(13) Obtem lista inversa - l1"
                    + "\n(14) Deixar pares em lista1 e impares em lista2 -> l1 e l2"
                    + "\n(15) Inserção em fila com NoAnterior - l1"
                    + "\n(16) Remoção em fila com NoAnterior - l1"
                    + "\n(17) imprimir todas Listas - All"       
                    + "\n(-1) Sair.. "
                    + "\nOpcao: ");
            
            switch(opcao){
			
                case 1: //insereInicio
                    valor = Input.readString("Valor: ");
                    pos = Input.readInt("id: ");
                    insereInicio(valor, pos);
		break;
				
		case 2: //insereFinal
                    valor = Input.readString("Valor: ");
                    pos = Input.readInt("id: ");
                    insereFinal(valor, pos);
		break;
				
		case 3: //removeInicio
                    removeInicio();
		break;
				
                case 4: //removeFinal
                    removeFinal();
		break;
				
		case 5: //imprime
                    imprime();
		break;
	        
                case 6:
                    valor = Input.readString("Valor: ");
                    busca(valor);
                break;

                case 7:
                    valor = Input.readString("Valor: ");
                    int num = Input.readInt("id: ");
                    pos = Input.readInt("Posicao: ");
                    inserePosicaoEspecifica(valor,num , pos);
                break;
                
                case 8:
                    pos = Input.readInt("N-esimo numero: ");
                    removeNesimo(pos);
                break;
                
                case 9:
                    pos = Input.readInt("Posicao de divisao: ");
                    divideApartir(fila2, pos);
                    
                break;
                
                case 10:
                    concatenaListas(fila2);
                break;
                
                case 11:
                   criaListaApartirde2(fila2, fila3);
                break;
                
                case 12:
                    valor = Input.readString("Nome: ");
                    pos = Input.readInt("Id: ");
                    ordenarInserindo(valor, pos);
                break;
                
                case 13:
                 //   obtemOrdemInversaEncad();
                    obtemOrdemInversaSimples();
                break;

                case 14:
                     listasParEimpar(fila2);
                break;
                
                case 15: //insercao <>
                    valor = Input.readString("Pessoa: ");
                    pos = Input.readInt("Id: ");
                    insercaoBfila(valor, pos);
                break;
                
                case 16: //remocao<>                  
                    remocaoBfila();
                break;
                
                case 17:                
                    imprimeTodas(fila2, fila3);
                break;
                
		case -1: //sair
                    System.out.println("Saindo!");
		break;
				
		default:
                    System.out.println("Opcao invalida!");
		break;
			
            }
		
	}
    }

    public static void main(String args[]){
        System.out.println("\n************ Lista Encadeada Dinamica ************\n");
	fila F = new fila();
	F.menu();
	System.out.println("\n************ Fim programa ************\n");
    }
}